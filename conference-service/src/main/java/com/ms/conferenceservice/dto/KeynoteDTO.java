package com.ms.conferenceservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KeynoteDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
}
