package com.example.tasklist.model.task;

import com.example.tasklist.model.task.Status;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private LocalDateTime expirationDate;

    @Column(name = "image")
    @CollectionTable(name = "tasks_images")
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;
}
