package com.ducetech.api.security.impl;

import com.ducetech.api.security.TokenManager;
import com.ducetech.util.CodecUtil;
import com.github.pagehelper.StringUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lenzhao on 17-2-2.
 */
public class DefaultTokenManager implements TokenManager {

    private static Map<String, String> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String createToken(String userId) {
        String token = CodecUtil.createUUID();
        tokenMap.put(token, userId);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtil.isEmpty(token) && tokenMap.containsKey(token);
    }
}
