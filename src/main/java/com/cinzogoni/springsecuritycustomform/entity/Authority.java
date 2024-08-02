package com.cinzogoni.springsecuritycustomform.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "authority", nullable = false)
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;
}
