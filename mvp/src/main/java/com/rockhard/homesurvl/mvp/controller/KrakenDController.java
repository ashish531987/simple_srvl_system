package com.rockhard.homesurvl.mvp.controller;

import com.rockhard.homesurvl.mvp.model.JwkConfig;
import com.rockhard.homesurvl.mvp.service.JwkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class KrakenDController {
    @Autowired
    JwkService jwkService;

    static final Long EXPIRY_OFFSET = 15 * 60000L; // 15 minutes

    @GetMapping(value = "/mvp/jwk/symmetric.json", produces = "application/json")
    public ResponseEntity<HashMap<String, JwkConfig[]>> home() {
        JwkConfig[] jwkConfig = jwkService.getJwkKeys();
        HashMap<String,JwkConfig[]> responseMap = new HashMap<>();
        responseMap.put("keys", jwkConfig);
        return ResponseEntity.ok(responseMap);
    }

    @GetMapping(value = "/mvp/api/auth/v1/token", produces = "application/json")
    public ResponseEntity<String> getToken() {
        String expiryInString = Long.toString((System.currentTimeMillis() + EXPIRY_OFFSET) / 1000);
        return ResponseEntity.ok("{ \n" +
                "    \"access_token\": { \n" +
                "        \"aud\": \"https://your.krakend.io\", \n" +
                "        \"iss\": \"https://your-backend\", \n" +
                "        \"sub\": \"1234567890qwertyuio\", \n" +
                "        \"jti\": \"mnb23vcsrt756yuiomnbvcx98ertyuiop\", \n" +
                "        \"roles\": [\"admin\", \"device\"], \n" +
                "        \"exp\": " + expiryInString + " \n" +
                "    }, \n" +
                "    \"refresh_token\": { \n" +
                "        \"aud\": \"https://your.krakend.io\", \n" +
                "        \"iss\": \"https://your-backend\", \n" +
                "        \"sub\": \"1234567890qwertyuio\", \n" +
                "        \"jti\": \"mnb23vcsrt756yuiomn12876bvcx98ertyuiop\", \n" +
                "        \"exp\": " + expiryInString + "\n" +
                "    }, \n" +
                "    \"exp\": " + expiryInString + " \n" +
                "} ");
    }
}
