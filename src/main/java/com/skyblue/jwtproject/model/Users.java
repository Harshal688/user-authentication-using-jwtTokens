package com.skyblue.jwtproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "yes_users")
@Data
public class Users {

    @Id
    private String username;
    private String email;
    private String password;
}
