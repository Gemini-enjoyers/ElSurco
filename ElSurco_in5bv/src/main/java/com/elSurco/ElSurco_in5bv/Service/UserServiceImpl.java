package com.elSurco.ElSurco_in5bv.Service;

import com.elSurco.ElSurco_in5bv.Entity.User;
import com.elSurco.ElSurco_in5bv.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("User " + id + " not found."));
    }

    @Override
    public User create(User user) {
        user.setIdUser(null);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, User user) {
        User existingUser = getById(id);

        existingUser.setUserFirstName(user.getUserFirstName());
        existingUser.setUserLastName(user.getUserLastName());
        existingUser.setHandle(user.getHandle());
        existingUser.setUemail(user.getUemail());
        existingUser.setUpassword(user.getUpassword());
        existingUser.setUadress(user.getUadress());
        existingUser.setUphone(user.getUphone());
        existingUser.setuStatus(user.getuStatus());

        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Integer id) {
        User existingUser = getById(id);
        userRepository.delete(existingUser);
    }
}