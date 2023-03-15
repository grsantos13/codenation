package com.challenge.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Embeddable
public class CandidateId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotBlank
    private User user;

    @ManyToOne
    @JoinColumn(name = "acceleration_id")
    @NotBlank
    private Acceleration acceleration;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @NotBlank
    private Company company;
}
