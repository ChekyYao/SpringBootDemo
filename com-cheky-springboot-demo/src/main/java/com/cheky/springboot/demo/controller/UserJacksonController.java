package com.cheky.springboot.demo.controller;

import com.cheky.springboot.demo.dto.UserDTO;
import com.cheky.springboot.demo.dto.UserJacksonDTO;
import com.cheky.springboot.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 测试 Jackson
 * @author Cheky
 */
@RestController()
@RequestMapping("jackson/users")
public class UserJacksonController {

    /**
     * 依据id查询User
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public UserJacksonDTO getUser(@PathVariable("id") final Integer id){
        return createUser(id);
    }

    /**
     * 新增User
     * @param user
     * @return
     */
    @PostMapping
    public ResponseEntity insertUser(@RequestBody UserJacksonDTO user){
        System.out.println("user = " + user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity updateUser(@PathVariable("id") final Integer id, @RequestBody final UserJacksonDTO user){
        user.setId(id);
        System.out.println("user = " + user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private UserJacksonDTO createUser(Integer id){
        var result = new UserJacksonDTO();
        result.setId(id);
        result.setBirthDate(new Date());
        result.setEmail("139@163.com");
        result.setLastName("Cheky");
        result.setEnabled(true);
        return  result;
    }
}
