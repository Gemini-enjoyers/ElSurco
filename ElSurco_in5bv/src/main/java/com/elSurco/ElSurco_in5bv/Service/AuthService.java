package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.User;
import com.elSurco.ElSurco_in5bv.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(User user) {
        if (userRepository.existsByUserEmail(user.getUserEmail())) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        String hash = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(hash);

        userRepository.save(user);
    }

    public Map<String, Object> login(User userRequest) {
        User userEntity = userRepository.findByUserEmail(userRequest.getUserEmail())
                .orElseThrow(() -> new IllegalArgumentException("Incorrect email / does not exist."));

        boolean isMatch = passwordEncoder.matches(userRequest.getUserPassword(), userEntity.getUserPassword());
        if (!isMatch) throw new IllegalArgumentException("Incorrect password");
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("idUser", userEntity.getIdUser());
        response.put("email", userEntity.getUserEmail());
        response.put("handle", userEntity.getHandle());
        response.put("status", userEntity.getUserStatus());

        return response;
    }
}