package com.amalvadkar.dgs.common.repositries;

import com.amalvadkar.dgs.common.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {
}