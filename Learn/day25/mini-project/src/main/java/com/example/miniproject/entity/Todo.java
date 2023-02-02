package com.example.miniproject.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name ="Todo")
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private boolean status;

    @PrePersist // Truoc khi luu
    public  void prePersist() {
        status = false;
    }
}
