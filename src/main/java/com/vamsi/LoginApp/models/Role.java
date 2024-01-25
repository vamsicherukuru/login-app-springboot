package com.vamsi.LoginApp.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "spring_security_role")
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name")
    private String name;
}
