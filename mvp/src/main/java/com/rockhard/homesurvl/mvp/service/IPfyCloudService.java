package com.rockhard.homesurvl.mvp.service;

import com.rockhard.homesurvl.mvp.model.IpifyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IPfyCloudService implements DiscoverPublicIP {
    @Autowired
    RestTemplate restTemplate;

    private static final String ipfyURL = "https://api.ipify.org?format=json";
    @Override
    public String getPublicIP() {
        IpifyResponseDTO ipfiyResponse = restTemplate.getForObject("https://api.ipify.org?format=json", IpifyResponseDTO.class);
        if (ipfiyResponse != null) {
            return ipfiyResponse.getIp();
        }
        return null;
    }
}
