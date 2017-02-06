package com.ducetech.api.security.impl;

import com.ducetech.api.security.TokenManager;
import com.ducetech.framework.model.User;
import com.ducetech.redis.MyRedisTemplate;
import com.ducetech.util.CodecUtil;
import com.ducetech.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTokenManager implements TokenManager {

    private static final long DEFAULT_SECONDS = 0L;

    private long seconds = DEFAULT_SECONDS;

    @Autowired
    private MyRedisTemplate myRedisTemplate;

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public String createToken(String userId) {
        String token = CodecUtil.createUUID();
        if (seconds != 0L) {
           myRedisTemplate.setx(token, userId, seconds);
        } else {
            myRedisTemplate.setItem(token, userId);
        }
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        boolean result;
        result = myRedisTemplate.exists(token);
        if (seconds != 0) {
            result = myRedisTemplate.expire(token, seconds);
        }
        return result;
    }
}
