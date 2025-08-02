package com.amalvadkar.dgs.common.repositries;

import com.amalvadkar.dgs.common.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity, String> {
}