package com.ms.keynoteservice.repository;

import com.ms.keynoteservice.entity.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KeynoteRepository extends JpaRepository<Keynote, Long> {
}
