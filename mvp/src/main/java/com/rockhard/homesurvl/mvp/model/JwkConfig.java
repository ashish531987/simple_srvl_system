package com.rockhard.homesurvl.mvp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jwk_config")
public class JwkConfig {
    @Id
    @Column(name = "kid", nullable = false, length = 45)
    private String kid;

    @Column(name = "k", length = 90)
    private String k;

    @Column(name = "alg", length = 10)
    private String alg;

    @Column(name = "kty", length = 10)
    private String kty;

    public String getKty() {
        return kty;
    }

    public void setKty(String kty) {
        this.kty = kty;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }
}