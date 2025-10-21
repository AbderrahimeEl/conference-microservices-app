package com.ms.conferenceservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Instant date;
    private String texte;
    private int note;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;
}
