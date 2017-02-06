package com.ducetech.api.controller;

import com.ducetech.api.model.AdvertiserParam;
import com.ducetech.api.model.Response;
import com.ducetech.api.security.IgnoreSecurity;
import com.ducetech.api.security.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenzhao on 17-2-2.
 */

@RestController
public class AdvertiserController {

    @Autowired
    private TokenManager tokenManager;

    @IgnoreSecurity
    @RequestMapping(value = "/api/advertiser", method = RequestMethod.POST)
    public Response createAdvertiser(@RequestBody AdvertiserParam advertiserParam) {
        // 创建 token
        String token = tokenManager.createToken("10001");
        return new Response().success(token);
    }

    @RequestMapping(value = "/api/advertiser/{id}", method = RequestMethod.GET)
    public Response getAdvertiser(@PathVariable("id") String advertiserId) {
        return new Response().success(advertiserId);
    }
}
