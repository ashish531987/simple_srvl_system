package com.rockhard.homesurvl.mvp.service;

import com.rockhard.homesurvl.mvp.model.IpTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CloudService {
    @Autowired
    IPfyCloudService iPfyPublicIPService;

    @Autowired
    IpTrackerService ipTrackerService;

    @Scheduled(fixedDelay = 60000)
    public void checkPublicIpIsChanged() {
        // Get latest public ip
        String latestPublicIp = iPfyPublicIPService.getPublicIP();

        // Save ip tracker
        IpTracker ipTracker = new IpTracker();
        ipTracker.setId(latestPublicIp);
        ipTracker.setDatetime(Instant.now());
        ipTrackerService.saveIPAddress(ipTracker);
    }
}
