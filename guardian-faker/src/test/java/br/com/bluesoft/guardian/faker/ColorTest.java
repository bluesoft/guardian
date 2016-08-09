package br.com.bluesoft.guardian.faker;

import org.junit.Before;
import org.junit.Test;


import br.com.bluesoft.guardian.faker.matchers.MatchesRegularExpression;

import static org.hamcrest.MatcherAssert.assertThat;

public class ColorTest {

    private Faker faker;

    @Before
    public void before() {
        faker = new Faker();
    }

    @Test
    public void testName() {
        assertThat(faker.color().name(), MatchesRegularExpression.matchesRegularExpression("(\\w+ ?){1,2}"));
    }
}
