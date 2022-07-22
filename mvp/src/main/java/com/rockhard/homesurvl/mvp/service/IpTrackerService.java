package com.rockhard.homesurvl.mvp.service;

import com.rockhard.homesurvl.mvp.model.IpTracker;
import com.rockhard.homesurvl.mvp.repository.IpTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpTrackerService {
    @Autowired
    IpTrackerRepository ipTrackerRepository;

    public void saveIPAddress(IpTracker ipTracker){
        ipTrackerRepository.saveAndFlush(ipTracker);
    }
}
