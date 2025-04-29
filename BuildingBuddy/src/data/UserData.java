package data;

import myProject.User;

public interface UserData {
	boolean register(User user);
    User login(String username, String password);
}
