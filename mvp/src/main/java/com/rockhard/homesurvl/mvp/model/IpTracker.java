package com.rockhard.homesurvl.mvp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "ip_tracker")
public class IpTracker {
    @Id
    @Column(name = "public_ip", nullable = false, length = 45)
    private String id;

    @Column(name = "datetime")
    private Instant datetime;

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}