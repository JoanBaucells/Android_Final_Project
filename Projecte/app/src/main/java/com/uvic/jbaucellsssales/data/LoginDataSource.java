package com.uvic.jbaucellsssales.data;

import com.uvic.jbaucellsssales.Entitats.User;
import com.uvic.jbaucellsssales.Singleton.App_singleton;
import com.uvic.jbaucellsssales.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {
        String sError = "Error logging in user doesn't exist.";
        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            username);
            for (User u: App_singleton.getInstance().getList_users()) {
                if(u.getUsername().equals(username)) {
                    sError = "Error logging in password isn't correct.";
                    if (u.getPassword().equals(password)) {
                        sError = "";
                        return new Result.Success<>(fakeUser);
                    }
                }
            }

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
        return new Result.Error(new IOException(sError));
    }

    public void logout() {
        // TODO: revoke authentication
    }
}