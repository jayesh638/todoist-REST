package com.example.todoist.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer taskId;

    Integer projectId;

    String posted;

    @Column(columnDefinition = "TEXT")
    String content;

    @OneToOne
    Attachment attachment;
}