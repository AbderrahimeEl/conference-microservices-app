package com.ms.conferenceservice.service.impl;

import com.ms.conferenceservice.dto.ReviewDTO;
import com.ms.conferenceservice.entity.Review;
import com.ms.conferenceservice.mapper.ReviewMapper;
import com.ms.conferenceservice.repository.ReviewRepository;
import com.ms.conferenceservice.service.ReviewService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    @Override
    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream().map(ReviewMapper::mapToReviewDTO).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review == null) {
            throw new NoSuchElementException("Review not found with id " + id);
        }
        return ReviewMapper.mapToReviewDTO(review);
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review saved = reviewRepository.save(ReviewMapper.mapToReview(reviewDTO, null));
        return ReviewMapper.mapToReviewDTO(saved);
    }

    @Override
    public ReviewDTO updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Review not found with id " + id));
        review.setTexte(reviewDTO.getTexte());
        review.setNote(reviewDTO.getNote());
        review.setDate(reviewDTO.getDate());
        reviewRepository.save(review);
        return ReviewMapper.mapToReviewDTO(review);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Review not found with id " + id));
        reviewRepository.delete(review);
    }
}
