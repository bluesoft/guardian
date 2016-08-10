package br.com.bluesoft.guardian.faker;


import br.com.bluesoft.guardian.faker.matchers.MatchesRegularExpression;
import org.junit.*;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;

public class RoleTest {

    private Faker faker;

    @Before
    public void before() {
        faker = new Faker(Locale.getDefault());
    }

    @Test
    public void testName() {
        assertThat(faker.role().name(), MatchesRegularExpression.matchesRegularExpression("[A-Za-z]+"));
    }

}
