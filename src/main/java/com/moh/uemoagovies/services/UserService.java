package com.moh.uemoagovies.services;

import com.moh.uemoagovies.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
