
package com.micro.UserService.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="User")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
