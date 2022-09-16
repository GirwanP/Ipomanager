package com.gp.ipomanager.userservice;

import com.gp.ipomanager.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

	void saveCandidateUser(User user);

	void saveAdminUser(User user);

	boolean disableUser(String username);

	boolean activateUser(String username);

	boolean isCurrentUserAdmin(User u);

	boolean isCurrentUserCustomer(User u);
}
