package com.ms.conferenceservice.repository;

import com.ms.conferenceservice.dto.ReviewDTO;
import com.ms.conferenceservice.entity.Conference;
import com.ms.conferenceservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByConferenceId(Long conferenceId);

}