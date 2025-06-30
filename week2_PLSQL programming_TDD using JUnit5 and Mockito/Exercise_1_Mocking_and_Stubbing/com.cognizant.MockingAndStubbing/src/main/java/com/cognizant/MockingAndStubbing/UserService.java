package com.cognizant.MockingAndStubbing;

public class UserService {
	private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserEmail(String username) {
        User user = userRepository.findByUsername(username);
        return user != null ? user.getEmail() : null;
    }
}
