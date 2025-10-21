package com.ms.keynoteservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeynoteDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
}
