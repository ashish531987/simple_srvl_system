package com.rockhard.homesurvl.mvp.repository;

import com.rockhard.homesurvl.mvp.model.JwkConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwkConfigRepository extends JpaRepository<JwkConfig, String> {
}