package com.universal.system.common.utils.jwt;

import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * @author 姓陈的
 * 2023/6/5 15:32
 */
@Component
public class JwtUtil {


    // 令牌自定义标识
    @Value("${token.auth}")
    private String auth;


    private static long tokenExpiration = 365 * 24 * 60 * 60 * 10000;
    private static String tokenSignKey = "@sdfhsbhj57b$#hbhs_sajsb";
    private static final String KEY = "token_key";

    public String createToken(String uuid) {
        String token = Jwts.builder()
                .setSubject("AUTH-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim(KEY, uuid)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    /**
     * 解析jwt里的tokenKey
     * @param token
     * @return
     */
    public String getTokenKey(String token) {
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get(KEY);
    }

    /**
     * 解析jwt里的tokenKey
     * @param request
     * @return
     */
    public String getTokenKey(HttpServletRequest request) {
        String token = request.getHeader(auth);
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get(KEY);
    }

    /**
     * 获取请求头token字符串
     * @param request
     * @return
     */
    public String getToken(HttpServletRequest request){
        String token = request.getHeader(auth);
        return token;
    }


    public static void main(String[] args) {
//        String token = JwtUtil.createToken(1L, "admin");
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);
//        String token = createToken(uuid.toString());
//        System.out.println(token);
//        System.out.println(JwtUtil.getTokenKey("eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAA3KsQ5AMBAA0H-52SVt71TbzSAxo7MoN0mQICHi33nze2A_EwQoY1djbKsGMpBrg6Ct95aYXZ7Bsc6y9LPcfxxGZ02yBoVMQuZiwlSIQtHekSNSOTG8Hyb8g99XAAAA.Oq0GcNVw_MOx9WK9GMqVUymTg442kWtaFnPq5Q0B1BrnGyBIvjw-_-1HTwbXNkrWn0bQvO7_KoVdWrRvIqHs5A"));

        //b10bd094-bf85-4889-a0d4-c750db2be992
    }


}
