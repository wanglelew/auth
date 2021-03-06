package com.wang.videoblog.authservice;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Encoder;

import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * @author 王乐乐 WLL
 * @Classname JwtTest
 * @Describe:
 * @date 2021/3/6 9:53
 */
@SpringBootTest
public class JwtTest {
    @Test
    public void createJwt(){
        //密钥
        String key="123456789_123456789_123456789";
        //1.对密钥进行base64编码
        String base64 = new BASE64Encoder().encode(key.getBytes());
        //2.生成密钥对象
        SecretKey secretKey = Keys.hmacShaKeyFor(base64.getBytes());//根据base64长度自动选择相应的 HMAC 算法
        //3.利用jjwt生成token
        String jwt = Jwts.builder().setSubject("{\"userId\":123}").signWith(secretKey).compact();
        System.out.println(jwt);

    }
    @Test
    public void checkJwt(){
        String jwt="1eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJ1c2VySWRcIjoxMjN9In0.LeaJdS1PQ7raWd6Vt4vd3J1qQR_axHDBMkAsFkYf0pc";
        //密钥
        String key="123456789_123456789_123456789";
        //1.对密钥进行base64编码
        String base64 = new BASE64Encoder().encode(key.getBytes());
        //2.生成密钥对象
        SecretKey secretKey = Keys.hmacShaKeyFor(base64.getBytes());//根据base64长度自动选择相应的 HMAC 算法

        //3.验证token
        try {
            JwtParser parser=Jwts.parserBuilder().setSigningKey(secretKey).build();
            Jws<Claims> claimsJws = parser.parseClaimsJws(jwt);
            String subject = claimsJws.getBody().getSubject();
            System.out.println(subject);
        }catch (JwtException e){
            System.out.println("jwt校验失败");
            e.printStackTrace();
        }

    }
}
