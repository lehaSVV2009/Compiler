package com.kadet.compiler;

public enum Type {

	INT("int"), FLOAT("float"),BOOL ("bool"), NON("none");

	private String name;

	Type(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}