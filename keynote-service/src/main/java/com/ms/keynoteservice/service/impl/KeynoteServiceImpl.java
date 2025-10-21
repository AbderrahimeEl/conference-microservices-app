package com.ms.keynoteservice.service.impl;

import com.ms.keynoteservice.dto.KeynoteDTO;
import com.ms.keynoteservice.entity.Keynote;
import com.ms.keynoteservice.mapper.KeynoteMapper;
import com.ms.keynoteservice.repository.KeynoteRepository;
import com.ms.keynoteservice.service.KeynoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeynoteServiceImpl implements KeynoteService {

    private final KeynoteRepository repository;

    @Override
    public List<KeynoteDTO> getAllKeynotes() {
        return repository.findAll().stream()
                .map(KeynoteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public KeynoteDTO getKeynoteById(Long id) {
        Keynote k = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Keynote not found with id " + id));
        return KeynoteMapper.toDTO(k);
    }

    @Override
    public KeynoteDTO createKeynote(KeynoteDTO keynoteDTO) {
        Keynote saved = repository.save(KeynoteMapper.toEntity(keynoteDTO));
        return KeynoteMapper.toDTO(saved);
    }

    @Override
    public KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO) {
        Keynote existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Keynote not found with id " + id));
        existing.setFirstName(keynoteDTO.getFirstName());
        existing.setLastName(keynoteDTO.getLastName());
        existing.setEmail(keynoteDTO.getEmail());
        existing.setFunction(keynoteDTO.getFunction());
        Keynote updated = repository.save(existing);
        return KeynoteMapper.toDTO(updated);
    }

    @Override
    public void deleteKeynote(Long id) {
        Keynote existing = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Keynote not found with id " + id));
        repository.delete(existing);
    }
}
