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
@Table(name = "submission")
public class Submission {

    @EmbeddedId
    private SubmissionId id;


    @NotNull
    @Column(name = "score", nullable = false)
    private float score;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
