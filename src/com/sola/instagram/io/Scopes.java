package com.sola.instagram.io;

import java.util.ArrayList;
import java.util.List;

public class Scopes {
	public static enum Scope {
		BASIC("basic"), COMMENTS("comment"), RELATIONSHIPS("relationships"), LIKES(
				"likes");
		private final String value;

		private Scope(String value) {
			this.value = value;
		}
		private String value() {
			return value;
		}
	}

	private static Scopes instance = null;
	private List<String> scopesList = new ArrayList<String>();

	public Scopes() {
		addScope(Scope.BASIC);
	}

	public static Scopes getInstance() {
		if (instance == null) {
			instance = new Scopes();
		}
		return instance;
	}

	public void addScope(Scope scope) {
		switch (scope) {
		case BASIC:
			if (scopesList.indexOf(Scope.BASIC.value()) < 0) {
				scopesList.add(Scope.BASIC.value());
			}
			break;
		case COMMENTS:
			if (scopesList.indexOf(Scope.COMMENTS.value()) < 0) {
				scopesList.add(Scope.COMMENTS.value());
			}
			break;
		case RELATIONSHIPS:
			if (scopesList.indexOf(Scope.RELATIONSHIPS.value()) < 0) {
				scopesList.add(Scope.RELATIONSHIPS.value());
			}
			break;
		case LIKES:
			if (scopesList.indexOf(Scope.LIKES.value()) < 0) {
				scopesList.add(Scope.LIKES.value());
			}
			break;
		default:
			break;
		}
	}
	@Override
	public String toString() {
		String scopeString="";
		for (String string : scopesList) {
			scopeString+="+"+string;
		}
		return scopeString.substring(1, scopeString.length());
	}
}
