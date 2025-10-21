package com.ms.conferenceservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {

    private Long id;

    @NotNull(message = "Date is required")
    private Instant date;

    @NotBlank(message = "Text is required")
    private String texte;

    @Min(value = 1, message = "Note must be between 1 and 5")
    @Max(value = 5, message = "Note must be between 1 and 5")
    private int note;

    private Long conferenceId;
}
