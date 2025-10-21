package com.ms.keynoteservice.mapper;

import com.ms.keynoteservice.dto.KeynoteDTO;
import com.ms.keynoteservice.entity.Keynote;

public class KeynoteMapper {

    public static KeynoteDTO toDTO(Keynote keynote) {
        if (keynote == null) return null;
        return new KeynoteDTO(
                keynote.getId(),
                keynote.getFirstName(),
                keynote.getLastName(),
                keynote.getEmail(),
                keynote.getFunction()
        );
    }

    public static Keynote toEntity(KeynoteDTO dto) {
        if (dto == null) return null;
        return new Keynote(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getFunction()
        );
    }
}
