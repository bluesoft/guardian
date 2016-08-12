package br.com.bluesoft.guardian.fixture.fixtures;


import java.math.BigDecimal;

import br.com.bluesoft.guardian.fixture.FixtureField;
import br.com.bluesoft.guardian.fixture.GuardianFixture;
import br.com.bluesoft.guardian.fixture.models.Employee;

public class EmployeeFixture extends AbstractPersonFixture<Employee> {

    private FixtureField<BigDecimal> salary = field(f -> BigDecimal.valueOf(f.faker().number().randomDouble(2, 100, 5000)));

    public EmployeeFixture(GuardianFixture guardianFixture) {
        super(guardianFixture);
    }

    public BigDecimal getSalary() {
        return salary.getValue();
    }
}
