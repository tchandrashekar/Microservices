
package com.micro.OrderService.Controller;

import com.micro.OrderService.Model.Order;
import com.micro.OrderService.Service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderservice;
    
    @PostMapping("create")
    public ResponseEntity<Order> create(@RequestBody Order order){
        return ResponseEntity.ok(orderservice.create(order));
    }
    
    @GetMapping()
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(orderservice.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> findbyid(@PathVariable Long id){
        return ResponseEntity.ok(orderservice.findbyid(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable Long id){
        orderservice.deletebyid(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    
    
    
}
