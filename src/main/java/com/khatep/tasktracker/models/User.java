package com.khatep.tasktracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @Setter
    private String name;
    @Setter
    private String email;

    @Setter
    private String passwordHash;
}
