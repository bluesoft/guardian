package br.com.bluesoft.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import br.com.bluesoft.demo.fixtures.AgencyFixture;
import br.com.bluesoft.demo.fixtures.PersonFixture;
import br.com.bluesoft.demo.models.Agency;
import br.com.bluesoft.demo.models.Person;
import br.com.bluesoft.guardian.GuardianProfiles;
import br.com.bluesoft.guardian.fixture.GuardianFixture;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(GuardianProfiles.TEST)
@Transactional
public class DemoApplicationTests {

    @Autowired
    private GuardianFixture guardianFixture;

    @Test
    public void expectedToPersistEntity() throws Exception {
        Person person = new PersonFixture(guardianFixture).create();

        assertThat(person).isNotNull();

        assertThat(person.getId())
            .isNotNull()
            .isGreaterThan(0);
    }

    @Test
    public void expectedToPersistMultiplesEntities() throws Exception {
        List<Person> persons = new PersonFixture(guardianFixture).create(10);

        assertThat(persons)
            .hasSize(10)
            .extracting(Person::getId)
            .doesNotContainNull();
    }

    @Test
    public void expectedToPersistDependencies() throws Exception {
        Agency agency = new AgencyFixture(guardianFixture).create();

        assertThat(agency).isNotNull();
        assertThat(agency.getId())
            .isNotNull()
            .isGreaterThan(0);

        assertThat(agency.getBank()).isNotNull();
        assertThat(agency.getBank().getId())
            .isNotNull()
            .isGreaterThan(0);
    }
}
