package com.amalvadkar.dgs.common.repositries;

import com.amalvadkar.dgs.common.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, String> {

    @Query("""
            select u from UserEntity u
            where u.roleEntity.name = :role and u.deleteFlag = false and u.active = true
            """)
    List<UserEntity> findUsersBy(@Param("role") String role);


}