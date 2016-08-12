package br.com.bluesoft.guardian.fixture.models;


import java.math.BigDecimal;

public class Employee extends Person {

    private BigDecimal salary;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
