package com.ms.conferenceservice.repository;

import com.ms.conferenceservice.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

}
