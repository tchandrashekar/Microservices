
package com.micro.OrderService.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String productname;
    private Long quantity;
    
    private Long userId;
    
    
}
