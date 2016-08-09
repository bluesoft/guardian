package br.com.bluesoft.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;

import br.com.bluesoft.guardian.GuardianProfiles;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.JpaGuardianFixture;

@Profile(GuardianProfiles.TEST)
@Configuration
public class GuardianConfig {

    @Bean
    public GuardianFixture factory(EntityManager entityManager) {
        return new JpaGuardianFixture(entityManager);
    }

}
