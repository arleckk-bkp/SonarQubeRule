package com.hitss.sonarqube.java.checks;

import org.junit.Test;

import com.hitss.sonarqube.rules.MyFirstCustomRule;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class MyFirstCustomCheckTest {

	@Test
	public void verify() {
		JavaCheckVerifier.verify("src/test/files/MyFirstCustomCheck.java", new MyFirstCustomRule());
	}
	
}
