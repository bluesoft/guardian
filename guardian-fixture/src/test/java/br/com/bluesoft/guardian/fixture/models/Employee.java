package br.com.bluesoft.guardian.fixture.models;


import java.math.BigDecimal;

public class Employee extends Person {

    private BigDecimal salary;

    public Employee(BigDecimal salary, String name, Integer age, String document) {
        super(name, age, document);
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
