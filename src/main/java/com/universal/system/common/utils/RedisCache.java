package com.universal.system.common.utils;


import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.universal.system.common.constant.Constants;
import com.universal.system.model.login.LoginUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 姓陈的
 * 2023/10/21 16:21
 */
@Component
public class RedisCache {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate redisTemplate;

    //分
    private static final TimeUnit MINUTES = TimeUnit.MINUTES;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
    //20分钟
    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

    @Value("${token.expireTime}")
    private Long expireTime;


    /**
     * redis存入String类型的值
     * @param key 键名
     * @param value 值
     * @param timeOut 过期时间
     * @param timeUnit 时间单位，（秒/分/时）
     */
    public void setString(String key, Object value, long timeOut, TimeUnit timeUnit){
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value),timeOut,timeUnit);
    }

    /**
     * redis存入String类型的值
     * @param key 键名
     * @param value 值
     */
    public void setString(String key, Object value){
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value),expireTime,MINUTES);
    }

    /**
     * redis存入LoginUser
     * @param key 键名
     * @param loginUser 值
     */
    public void setLoginUser(String key, LoginUser loginUser){
        loginUser.setExpireTime(System.currentTimeMillis()+expireTime*MILLIS_MINUTE);
//        redisTemplate.opsForValue().set(key,loginUser,expireTime,MINUTES);
        setString(key,loginUser);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 获取登录用户
     * @param key 键名
     * @return
     */
    public LoginUser getLoginUser(String key){

        String strJson = stringRedisTemplate.opsForValue().get(key);
        if(StringUtils.isNotEmpty(strJson)){

            return JSONUtil.toBean(strJson,LoginUser.class);
        }

        return null;
    }

    /**
     * 获取redis值
     * @param key 键名
     * @return
     */
    public String getJsonStr(String key){

        return stringRedisTemplate.opsForValue().get(key);

    }


    /**
     * 验证令牌有效期，相差不足20分钟，自动刷新缓存
     *
     * @param loginUser
     * @return 令牌
     */
    public void verifyToken(LoginUser loginUser,String key)
    {
        long expireTime = loginUser.getExpireTime();
        long currentTime = System.currentTimeMillis();

        if (expireTime - currentTime <= MILLIS_MINUTE_TEN)
        {
            setLoginUser(key,loginUser);
        }
    }



}
