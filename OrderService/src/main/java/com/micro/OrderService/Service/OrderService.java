
package com.micro.OrderService.Service;

import com.micro.OrderService.Client.UserClient;
import com.micro.OrderService.DTO.UserDto;
import com.micro.OrderService.Model.Order;
import com.micro.OrderService.Repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repo;
    
    @Autowired
    private UserClient userclient;
    
    public Order create(Order order){
        /*
        String url="http://localhost:8081/users/"+order.getUserId();
        
        UserDto user=restTemplate.getForObject(url,UserDto.class);
        */
        UserDto user=userclient.getUserById(order.getUserId());
        if(user==null){
            throw new RuntimeException("User not Found");
        }
        
        return repo.save(order);
    }
    
    public List<Order> getAll(){
        return repo.findAll();
    }
    
    public Optional<Order> findbyid(Long id){
        return repo.findById(id);
    }
    
    public void deletebyid(Long id){
        repo.deleteById(id);
    }
    
}
