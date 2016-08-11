package br.com.bluesoft.guardian.fixture;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import br.com.bluesoft.guardian.fixture.fixtures.AccountFixture;
import br.com.bluesoft.guardian.fixture.fixtures.AgencyFixture;
import br.com.bluesoft.guardian.fixture.fixtures.BankFixture;
import br.com.bluesoft.guardian.fixture.fixtures.PersonFixture;
import br.com.bluesoft.guardian.fixture.models.Account;
import br.com.bluesoft.guardian.fixture.models.Agency;
import br.com.bluesoft.guardian.fixture.models.Bank;
import br.com.bluesoft.guardian.fixture.models.Person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GuardianFixtureTest {
    private GuardianFixture fixture = new SimpleGuardianFixture();

    @Test
    public void testBuildSimpleTemplate() throws Exception {
        Bank bank = new BankFixture(fixture).build();
        assertNotNull(bank.getName());
        assertNotNull(bank.getNumber());
    }

    @Test
    public void testBuildList() throws Exception {

        Set<Person> persons = new HashSet<>(new PersonFixture(fixture).juridic().age(20).build(10));

        assertTrue(persons.size() == 10);
        for(Person person : persons) {
            assertNotNull(person.getName());
            assertNotNull(person.getAge());
            assertTrue(20 == person.getAge());
            assertNotNull(person.getDocument());
            assertTrue(person.getDocument().length() == "##.###.###/####-##".length());
        }
    }

    @Test
    public void testBuildRandomRelationalTemplates() throws Exception {
        Agency agency = new AgencyFixture(fixture).build();
        assertNotNull(agency);
        assertNotNull(agency.getBank());
        assertNotNull(agency.getBank().getName());
        assertNotNull(agency.getBank().getNumber());
    }

    @Test
    public void testBuildSpecifiRelationalTemplates() throws Exception {
        Bank bank = new BankFixture(fixture).build();
        Agency agency = new AgencyFixture(fixture).bank(bank).build();

        assertNotNull(agency);
        assertNotNull(agency.getBank());
        assertEquals(bank, agency.getBank());
    }

    @Test
    public void testComplexObjectTemplate() throws Exception {
        Account account = new AccountFixture(fixture).build();
        assertNotNull(account);
        assertNotNull(account.getNumber());
        assertNotNull(account.getDigit());
        assertNotNull(account.getAgency());
        assertNotNull(account.getAgency().getBank());
        assertNotNull(account.getOwner());
    }
}
