package com.ms.conferenceservice.controller;

import com.ms.conferenceservice.dto.ConferenceDTO;
import com.ms.conferenceservice.dto.ReviewDTO;
import com.ms.conferenceservice.entity.Conference;
import com.ms.conferenceservice.service.impl.ConferenceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {
    private final ConferenceServiceImpl conferenceService;

    public ConferenceController(ConferenceServiceImpl conferenceService) {
        this.conferenceService = conferenceService;
    }

    //    Get a list of all conferences
    @GetMapping("")
    public ResponseEntity<List<ConferenceDTO>> getConferences() {
        return ResponseEntity.ok(conferenceService.getConferences());
    }

    // Get details of a specific conference (including reviews)
    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getConference(@PathVariable Long id) {
        return ResponseEntity.ok(conferenceService.getConference(id));

    }

    // POST	/conferences	Create a new conference
    @PostMapping("")
    public ResponseEntity<ConferenceDTO> addConference(@RequestBody ConferenceDTO conference) {
        ConferenceDTO created = conferenceService.createConference(conference);
        return new ResponseEntity<>(created, HttpStatus.CREATED);    }

    // Update an existing conference
    @PutMapping("/{id}")
    public ResponseEntity<ConferenceDTO> updateConference(@PathVariable Long id, @RequestBody ConferenceDTO conference) {
        return ResponseEntity.ok(conferenceService.updateConference(id, conference));
    }

    //  Delete a conference
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }

    // reviews of a conference
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDTO>> getReviewsByConference(@PathVariable Long id) {
        return ResponseEntity.ok(conferenceService.getReviewsByConferenceId(id));
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewDTO> addReview(@PathVariable Long id, @RequestBody ReviewDTO review) {
        ReviewDTO created = conferenceService.addReviewToConference(id, review);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/average-points")
    public ResponseEntity<Double> getAveragePoints(@PathVariable Long id) {
        return ResponseEntity.ok(conferenceService.calculateConferenceNote(id));
    }

    @PutMapping("")
    public ResponseEntity<ConferenceDTO> assignKeynote(@PathVariable Long conferenceId,
                                                       @PathVariable Long keynoteId){
        return ResponseEntity.ok(conferenceService.assignKeynoteToConference(conferenceId,keynoteId));
    }
}