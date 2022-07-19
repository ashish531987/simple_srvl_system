package com.rockhard.homesurvl.mvp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KrakenDController {

    @GetMapping(value = "/mvp/jwk/symmetric.json", produces = "application/json")
    public  ResponseEntity<String> home() {
        return ResponseEntity.ok("{\n" +
                "\t\"keys\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"kty\": \"oct\",\n" +
                "\t\t\t\"alg\": \"A128KW\",\n" +
                "\t\t\t\"k\": \"GawgguFyGrWKav7AX4VKUg\",\n" +
                "\t\t\t\"kid\": \"sim1\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"kty\": \"oct\",\n" +
                "\t\t\t\"k\": \"AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQ-EstJQLr_T-1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow\",\n" +
                "\t\t\t\"kid\": \"B5c_UiQ9Ka3pkJsWxUkFW8BDiWtCgGBnrK1bBMXgN-I\",\n" +
                "\t\t\t\"alg\": \"HS256\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}");
    }

    @GetMapping(value = "/mvp/api/auth/v1/token", produces = "application/json")
    public ResponseEntity<String> getToken(){
        long expiry = 60000L;
        String expiryInString = Long.toString((System.currentTimeMillis() + expiry)/ 1000);
        return ResponseEntity.ok("{ \n" +
                "    \"access_token\": { \n" +
                "        \"aud\": \"https://your.krakend.io\", \n" +
                "        \"iss\": \"https://your-backend\", \n" +
                "        \"sub\": \"1234567890qwertyuio\", \n" +
                "        \"jti\": \"mnb23vcsrt756yuiomnbvcx98ertyuiop\", \n" +
                "        \"roles\": [\"role_a\", \"role_b\"], \n" +
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
