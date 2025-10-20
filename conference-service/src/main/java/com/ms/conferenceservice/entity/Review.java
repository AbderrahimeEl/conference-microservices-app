package com.ms.conferenceservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private String texte;
    private int note;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;
}
