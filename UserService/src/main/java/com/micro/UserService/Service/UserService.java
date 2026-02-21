
package com.micro.UserService.Service;

import com.micro.UserService.Model.User;
import com.micro.UserService.Repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
    
    public User create(User user){
        return repo.save(user);
    }
    public List<User> getUsers(){
        return repo.findAll();
    }
    
    public User findById(Long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("User not foiund"));
    }
    public void deleteUser(Long id){
        repo.deleteById(id);
    }
    
}
