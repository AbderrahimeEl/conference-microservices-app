package com.ms.conferenceservice.service;

import com.ms.conferenceservice.dto.ConferenceDTO;
import com.ms.conferenceservice.dto.ReviewDTO;
import com.ms.conferenceservice.entity.Conference;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ConferenceService {
    // Get a list of all conferences
    List<ConferenceDTO> getConferences();

    // get conference by id
    ConferenceDTO getConference(Long id);

    // create a conference
    ConferenceDTO createConference(ConferenceDTO conference);

    // Update an existing conference
    ConferenceDTO updateConference(Long id, ConferenceDTO conference);

    // delete it
    void deleteConference(Long id);

    // read the name
    List<ReviewDTO> getReviewsByConferenceId( Long id);

    // add review
    ReviewDTO addReviewToConference(Long conferenceId, ReviewDTO reviewDTO);

    // average note
    double calculateConferenceNote(Long conferenceId);


    // asign keynote
    public ConferenceDTO assignKeynoteToConference(Long conferenceId, Long keynoteId);


    }
