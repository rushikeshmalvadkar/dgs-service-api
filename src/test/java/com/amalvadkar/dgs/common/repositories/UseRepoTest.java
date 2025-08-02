package com.amalvadkar.dgs.common.repositories;

import com.amalvadkar.dgs.AbstractJpaTest;
import com.amalvadkar.dgs.common.entities.UserEntity;
import com.amalvadkar.dgs.common.repositries.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UseRepoTest extends AbstractJpaTest {

    @Autowired
    UserRepo userRepo;

    @Test
    void should_fetch_all_system_role_users() {
        List<UserEntity> users = userRepo.findUsersBy("System");
        assertThat(users).hasSize(1);
        assertThat(users).extracting("name").containsExactlyInAnyOrder(
                "System"
        );
        assertThat(users).extracting("email").containsExactlyInAnyOrder(
                "system@yourdomain.com"
        );
    }
}
