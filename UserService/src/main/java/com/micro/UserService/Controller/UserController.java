
package com.micro.UserService.Controller;

import com.micro.UserService.Model.User;
import com.micro.UserService.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userservice;
    
    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok(userservice.create(user));
    }
    
    @GetMapping()
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userservice.getUsers());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getbyId(@PathVariable Long id){
        return ResponseEntity.ok(userservice.findById( id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyId(@PathVariable Long id){
         userservice.deleteUser(id);
         return ResponseEntity.ok("Deleted Successfully");
    }
    
}
