package com.thiagoschreck.local.melisocial.entity.user;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class User {
	@Setter
	private Integer userId;
	private final String userName;

	protected User(String userName) {
		this.userName = userName;
	}
}
