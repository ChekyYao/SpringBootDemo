package com.cheky.springboot.demo.config;

import com.cheky.springboot.demo.model.LoginUserDO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author cheky
 * @date 2020-12-21
 */
@Configuration
public class JwtTokenConfig {
    private static Logger logger = LoggerFactory.getLogger(JwtTokenConfig.class);
    /** 秘钥 */
    @Value("${jwt.secret}")
    private String secret;

    /** 过期时间(秒) */
    @Value("${jwt.expire}")
    private long expire;

    /**
     * 生成jwt token
     */
    public String generateToken(LoginUserDO user) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(user.toString())
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            logger.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * token是否过期
     * @return true：过期
     */
    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
