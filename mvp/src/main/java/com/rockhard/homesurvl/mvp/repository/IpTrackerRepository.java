package com.rockhard.homesurvl.mvp.repository;

import com.rockhard.homesurvl.mvp.model.IpTracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpTrackerRepository extends JpaRepository<IpTracker, String> {
}