package com.amalvadkar.dgs.common.repositories;

import com.amalvadkar.dgs.AbstractJpaTest;
import com.amalvadkar.dgs.common.entities.RoleEntity;
import com.amalvadkar.dgs.common.repositries.RoleRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleRepoTest extends AbstractJpaTest {

    private static final Map<String, String> ROLE_NAME_TO_DESCRIPTION_MAP = new HashMap<>();

    @BeforeAll
    static void beforeAll() {
        ROLE_NAME_TO_DESCRIPTION_MAP.put("System", "Responsible to send email notifications and perform other automated tasks");
        ROLE_NAME_TO_DESCRIPTION_MAP.put("Admin", "Responsible to manage everything along with users and organizations");
        ROLE_NAME_TO_DESCRIPTION_MAP.put("Manager", "Responsible to manage projects, contexts and terms along with user assignment to project");
        ROLE_NAME_TO_DESCRIPTION_MAP.put("Member", "Responsible to view terms and contexts related to assigned projects");
    }

    @Autowired
    RoleRepo roleRepo;

    @Test
    void should_fetch_all_roles(){
        List<RoleEntity> allRoles = roleRepo.findAll();
        assertThat(allRoles).hasSize(ROLE_NAME_TO_DESCRIPTION_MAP.size());
        for (RoleEntity roleEntity : allRoles) {
            assertThat(ROLE_NAME_TO_DESCRIPTION_MAP.containsKey(roleEntity.getName())).isTrue();
            assertThat(ROLE_NAME_TO_DESCRIPTION_MAP.get(roleEntity.getName())).isEqualTo(roleEntity.getDescription());
        }
    }

}
