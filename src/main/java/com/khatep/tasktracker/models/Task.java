package com.khatep.tasktracker.models;

import com.khatep.tasktracker.models.enums.TaskPriority;
import com.khatep.tasktracker.models.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Setter
    private String title;

    @Setter
    @Enumerated(EnumType.STRING)
    private TaskPriority taskPriority;

    @Setter
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
