package com.challenge.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fullname", length = 100, nullable = false)
    @Size(max = 100)
    @NotNull
    private String full_name;

    @Email
    @NotNull
    @Column(name = "email", length = 100, nullable = false)
    @Size(max = 100)
    private String email;

    @NotNull
    @Column(name = "nickname", length = 50, nullable = false)
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Column(name = "password", length = 255, nullable = false)
    @Size(max = 255)
    private String password;

    @OneToMany
    private List<Candidate> candidates;

    @OneToMany
    private List<Submission> submissions;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
