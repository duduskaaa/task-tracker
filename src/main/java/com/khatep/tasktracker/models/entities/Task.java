package com.khatep.tasktracker.models.entities;

import com.khatep.tasktracker.models.enums.TaskPriority;
import com.khatep.tasktracker.models.enums.TaskStatus;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tasks")
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private TaskPriority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @PrePersist
    public void beforeCreate() {
        if (priority == null) priority = TaskPriority.MEDIUM;
        if (status == null) status = TaskStatus.IN_WAITING;
    }
}

