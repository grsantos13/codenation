package com.challenge.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "candidate")
public class Candidate {

    @EmbeddedId
    private CandidateId id;


    @Column(name = "status", nullable = false)
    @NotNull
    private int status;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
