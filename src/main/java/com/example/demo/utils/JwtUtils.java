package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Account;

import java.util.Calendar;

public class JwtUtils {
    //7天过期
    private static long expire = 604800;
    //32位秘钥
    private static String secret = "abcdfghiabcdfghiabcdfghiabcdfghi";

    //生成token
    public static String generateToken(Account account){
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间7天
        instance.add(Calendar.DATE, 7);
        JWTCreator.Builder builder = JWT.create();
        // 构建Jwt负载
        builder.withClaim("username", account.getAccount())
                .withClaim("userId", account.getId());
        // 返回Jwt
        return builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(secret));
    }

    /**
     * 验证token合法性 成功返回token
     * @return
     */
    public static Account verify(String token) {
        JWTVerifier build = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT decodedJWT = build.verify(token);
        // 解码
        int id = decodedJWT.getClaim("userId").asInt();
        String username = decodedJWT.getClaim("username").asString();
        // 持久化
        Account account = new Account();
        account.setId(id);
        account.setAccount(username);
        // 返回用户对象
        return account;
    }
}
