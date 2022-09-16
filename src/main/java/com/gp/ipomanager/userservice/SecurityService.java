package com.gp.ipomanager.userservice;

import com.gp.ipomanager.entities.User;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);

	User getLoggedInUser();
}
