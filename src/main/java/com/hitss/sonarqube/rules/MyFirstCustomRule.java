package com.hitss.sonarqube.rules;

import java.util.Arrays;
import java.util.List;

import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

@Rule(key = "MyFirstCustomRule",
name = "MyFirstCustomRule",
description = "Cantidad de parámetros en método",
priority = Priority.MINOR,
tags = {"bug"})
public class MyFirstCustomRule extends IssuableSubscriptionVisitor {

	@Override
	public List<Kind> nodesToVisit() {
		return Arrays.asList(Kind.METHOD);
	}
	
	@Override
	public void visitNode(Tree tree) {
		MethodTree method = (MethodTree) tree;
		if(method.parameters().size() == 0) {
			reportIssue(method, "El método no debe contener más de 5 parámetros '"+method.simpleName().name()+"'");
		}
	}
	
}
