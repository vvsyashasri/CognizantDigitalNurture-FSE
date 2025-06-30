package com.cognizant;
import com.cognizant.*;

public class UserServiceTest {
	public static void main(String[] args) {
        UserService service = new UserService();

        service.login(null, "admin123");

        service.login("admin", "wrongpassword");

        service.login("admin", "admin123");
    }
}
