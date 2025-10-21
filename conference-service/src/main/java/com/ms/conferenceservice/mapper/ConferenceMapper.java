package com.ms.conferenceservice.mapper;

import com.ms.conferenceservice.dto.ConferenceDTO;
import com.ms.conferenceservice.entity.Conference;

public class ConferenceMapper {

    public static Conference mapToConference(ConferenceDTO dto) {
        if (dto == null) {
            return null;
        }

        Conference conference = new Conference();
        conference.setId(dto.getId());
        conference.setTitle(dto.getTitle());
        conference.setDate(dto.getDate());
        conference.setDuration(dto.getDuration());
        conference.setScore(dto.getScore());
        conference.setInscriptions(dto.getInscriptions());
        conference.setKeynoteId(dto.getKeynoteId());
        return conference;
    }

    public static ConferenceDTO mapToConferenceDTO(Conference entity) {
        if (entity == null) {
            return null;
        }

        ConferenceDTO dto = new ConferenceDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDate(entity.getDate());
        dto.setDuration(entity.getDuration());
        dto.setScore(entity.getScore());
        dto.setInscriptions(entity.getInscriptions());
        dto.setKeynoteId(entity.getKeynoteId());
        return dto;
    }
}
