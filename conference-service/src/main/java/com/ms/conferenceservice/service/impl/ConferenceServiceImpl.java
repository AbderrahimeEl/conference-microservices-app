package com.ms.conferenceservice.service.impl;

import com.ms.conferenceservice.client.KeynoteClient;
import com.ms.conferenceservice.dto.ConferenceDTO;
import com.ms.conferenceservice.dto.KeynoteDTO;
import com.ms.conferenceservice.dto.ReviewDTO;
import com.ms.conferenceservice.entity.Conference;
import com.ms.conferenceservice.entity.Review;
import com.ms.conferenceservice.mapper.ConferenceMapper;
import com.ms.conferenceservice.mapper.ReviewMapper;
import com.ms.conferenceservice.repository.ConferenceRepository;
import com.ms.conferenceservice.repository.ReviewRepository;
import com.ms.conferenceservice.service.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

    ConferenceRepository conferenceRepository;
    ReviewRepository reviewRepository;
    private final KeynoteClient keynoteClient;


    @Override
    public List<ConferenceDTO> getConferences() {
        return conferenceRepository.findAll().stream().map(ConferenceMapper::mapToConferenceDTO).collect(Collectors.toList());
    }

    @Override
    public ConferenceDTO getConference(Long id) {
        Conference c = conferenceRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Conference not found with id" + id));
        ConferenceDTO dto = ConferenceMapper.mapToConferenceDTO(c);
        if (c.getKeynoteId() != null) {
            KeynoteDTO keynote = keynoteClient.getKeynoteById(c.getKeynoteId());
            dto.setKeynote(keynote);
        }
        return dto;
    }

    @Override
    public ConferenceDTO createConference(ConferenceDTO conference) {
        Conference c = ConferenceMapper.mapToConference(conference);
        Conference saved  = conferenceRepository.save(c);
        return ConferenceMapper.mapToConferenceDTO(saved);
    }

    @Override
    public ConferenceDTO updateConference(Long id,ConferenceDTO conference) {
        if(conference == null) {
            throw new RuntimeException("conference is null");
        }
        Conference existing = conferenceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Conference not found with id" + id));
        existing.setTitle(conference.getTitle());
        existing.setDate(conference.getDate());
        existing.setDuration(conference.getDuration());
        existing.setScore(conference.getScore());
        existing.setInscriptions(conference.getInscriptions());
        Conference saved = conferenceRepository.save(existing);
        return ConferenceMapper.mapToConferenceDTO(saved);
    }

    @Override
    public void deleteConference(Long id) {
        if(!conferenceRepository.existsById(id)) {
            throw new NoSuchElementException("Conference not found with id" + id);
        }
        conferenceRepository.deleteById(id);
    }

    @Override
    public List<ReviewDTO> getReviewsByConferenceId(Long id) {
        return reviewRepository.findReviewsByConferenceId(id)
                .stream()
                .map(ReviewMapper::mapToReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO addReviewToConference(Long conferenceId, ReviewDTO reviewDTO) {
        Conference c = conferenceRepository.findById(conferenceId).orElseThrow(
                () -> new NoSuchElementException("Conference not found with id" + conferenceId)
        );
        Review review = ReviewMapper.mapToReview(reviewDTO,c);
        Review saved = reviewRepository.save(review);
        return ReviewMapper.mapToReviewDTO(saved);
    }

    @Override
    public double calculateConferenceNote(Long conferenceId) {
        List<Review> reviews = reviewRepository.findReviewsByConferenceId(conferenceId);
        if(reviews.isEmpty()) {
            throw new RuntimeException("no review exist for conference " + conferenceId);
        }
        double sum = reviews.stream().mapToInt(Review::getNote).sum();
        return sum/reviews.size();
    }

    @Override
    public ConferenceDTO assignKeynoteToConference(Long conferenceId, Long keynoteId) {
        Conference c = conferenceRepository.findById(conferenceId).orElseThrow(
                () -> new NoSuchElementException("Conference not found with id" + conferenceId)
        );
        c.setKeynoteId(keynoteId);
        Conference saved = conferenceRepository.save(c);
        return ConferenceMapper.mapToConferenceDTO(saved);
    }
}
