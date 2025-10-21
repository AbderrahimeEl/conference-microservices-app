package com.ms.keynoteservice.service;

import com.ms.keynoteservice.dto.KeynoteDTO;

import java.util.List;

public interface KeynoteService {
    List<KeynoteDTO> getAllKeynotes();
    KeynoteDTO getKeynoteById(Long id);
    KeynoteDTO createKeynote(KeynoteDTO keynoteDTO);
    KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO);
    void deleteKeynote(Long id);
}
