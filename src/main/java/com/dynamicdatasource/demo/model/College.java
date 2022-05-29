package com.dynamicdatasource.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "collegeId")
    int id;
    @Column(name = "collegeName")
    String name;
    @Column(name = "collegeLocation")
    String location;
}
