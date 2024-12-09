package com.myRestaurant.manager.Service.Impl;

import java.util.List;

import com.myRestaurant.manager.Dto.UserDto;

public interface UserServiceImpl {
	List<UserDto> getAllUser();
	public List<UserDto> searchUsersByUsername(String username);
	boolean deleteUser(int id);
}
