package br.com.bluesoft.guardian;


import org.junit.Rule;
import org.junit.rules.ExpectedException;

public abstract class GuardianTest {
    @Rule
    public ExpectedException excpetion = ExpectedException.none();
}
