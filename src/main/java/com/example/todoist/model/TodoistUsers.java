package com.example.todoist.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TodoistUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String userName;

    String email;

    String password;

    @ManyToMany
    List<Project> projects;


}
