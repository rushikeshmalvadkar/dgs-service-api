package com.amalvadkar.dgs.common.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBaseEntity extends AbstractStringIdBaseEntity {

    @Column(name = "delete_flag", nullable = false)
    private boolean deleteFlag;

    @Column(name = "created_on")
    private Instant createdOn;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private UserEntity updatedBy;


    @PrePersist
    public void prePersist() {
       this.deleteFlag = false;
       this.createdOn = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
       this.updatedOn = Instant.now();
    }

}