package com.ms.conferenceservice.client;


import com.ms.conferenceservice.dto.KeynoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service",
        url = "http://localhost:8081"
)
public interface KeynoteClient {
    @GetMapping("/keynotes/{id}")
    KeynoteDTO getKeynoteById(@PathVariable("id") Long id);
}