package com.rockhard.homesurvl.mvp.service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.gen.OctetSequenceKeyGenerator;
import com.rockhard.homesurvl.mvp.model.JwkConfig;
import com.rockhard.homesurvl.mvp.repository.JwkConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class JwkService {
    @Autowired
    JwkConfigRepository jwkConfigRepository;

    public JwkConfig[] getJwkKeys() {
        int totalCount = (int)jwkConfigRepository.count();
        if(totalCount < 1){
            // Generate a secret key with 256 bits
            try {
                // Convert to JWK format
                OctetSequenceKey jwk = new OctetSequenceKeyGenerator(256)
                        .keyID(UUID.randomUUID().toString()) // give the key some ID (optional)
                        .algorithm(JWSAlgorithm.HS256) // indicate the intended key alg (optional)
                        .generate();

                System.out.println("jwk is "+jwk.toString());

                String key = jwk.getKeyValue().toString();
                String kid = jwk.getKeyID();
                String algo = jwk.getAlgorithm().getName();
                String keyType = jwk.getKeyType().toString();

                System.out.println("key is "+key);
                System.out.println("kid is "+kid);
                System.out.println("algo is "+algo);
                System.out.println("keyType is "+keyType);

                JwkConfig jwkConfig = new JwkConfig();
                jwkConfig.setKid(kid);
                jwkConfig.setAlg(algo);
                jwkConfig.setKty(keyType);
                jwkConfig.setK(key);

                jwkConfigRepository.saveAndFlush(jwkConfig);

            } catch (JOSEException e) {
                e.printStackTrace();
            }
    }
        return jwkConfigRepository.findAll().toArray(new JwkConfig[totalCount]);
    }
}
