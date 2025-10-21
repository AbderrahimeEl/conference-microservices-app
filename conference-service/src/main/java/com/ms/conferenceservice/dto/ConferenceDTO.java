package com.ms.conferenceservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConferenceDTO {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Date is required")
    private Instant date;

    @Positive(message = "Duration must be positive")
    private double duration;

    @Min(value = 0, message = "Score must be at least 0")
    @Max(value = 5, message = "Score must not exceed 5")
    private double score;

    @Min(value = 0, message = "Inscriptions must be at least 0")
    private int inscriptions;

    private Long keynoteId;

    private KeynoteDTO keynote;       // fetched via Feign



    //private List<ReviewDTO> reviews;
}
