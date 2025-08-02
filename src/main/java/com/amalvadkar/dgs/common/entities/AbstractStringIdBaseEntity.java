package com.amalvadkar.dgs.common.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractStringIdBaseEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @PrePersist
    public void prePersist() {
        this.id = UlidCreator.getUlid().toString();
    }
}