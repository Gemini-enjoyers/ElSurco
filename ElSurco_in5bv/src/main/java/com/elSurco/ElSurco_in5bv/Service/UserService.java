package com.elSurco.ElSurco_in5bv.Service;
import com.elSurco.ElSurco_in5bv.Entity.User;
import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Integer id);
    User create(User user);
    User update(Integer id, User user);
    void delete(Integer id);
}