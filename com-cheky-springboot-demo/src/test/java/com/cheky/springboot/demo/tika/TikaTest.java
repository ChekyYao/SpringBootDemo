package com.cheky.springboot.demo.tika;

import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class TikaTest {

    @Test
    public void testParse() throws Exception {
        String content= TikaTest.parse("..\\DATABASE.sql");
        System.out.println(content);
    }

    public static String parse(String filePath) throws Exception{
        return parse(filePath,10*1024*1024);
    }

    public static String parse(String filePath,int limit) throws Exception{
        File file=new File(filePath);
        if(!file.exists()){
            System.out.println("目标文件不存在！");
            return null;
        }
        BodyContentHandler handler=null;
        if(limit>10*1024*1024) {
            handler = new BodyContentHandler(limit);
        }else{
            handler = new BodyContentHandler(10 * 1024 * 1024);
        }
        Metadata meta=new Metadata();
        FileInputStream input=new FileInputStream(file);
        ParseContext context=new ParseContext();
        new AutoDetectParser().parse(input,handler,meta,context);
        return handler.toString();
    }
}
