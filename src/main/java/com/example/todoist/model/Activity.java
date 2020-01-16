package com.example.todoist.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String objectType;
    private long objectId;
    private String eventType;
    private String eventDateTime;
    private Long parentProjectId;
    private Long parentItemId;
    private Long initiatorId;

    @OneToOne
    private ExtraData extraData;
}