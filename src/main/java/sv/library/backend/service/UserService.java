package sv.library.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.library.backend.entity.User;
import sv.library.backend.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

    // Register a new user
    public User registerUser(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Login user
    public String loginUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent() && bcryptEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
            return "Login successful";
        }
        throw new RuntimeException("Invalid credentials");
    }

    // Find user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Update user details
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Delete user
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // Find user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
