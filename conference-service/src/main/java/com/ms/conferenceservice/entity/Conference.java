package com.ms.conferenceservice.entity;


//son id, son titre, son type (académique ou commerciale), sa date, sa durée, le
//nombre d’inscrits et son score.

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Conference {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private Instant date;
    private double duration;
    private double score;
    private int inscriptions;

    private Long keynoteId;


//    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
//    private List<Review> reviews;

}
