package com.example.back.controller;

import com.example.back.model.Count;
import com.example.back.model.CountDTO;
import com.example.back.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/count")
public class CountController {

    private final CountService countService;

    @Autowired
    public CountController(CountService countService) {
        this.countService = countService;
    }

    @PostMapping("/incread")
    public ResponseEntity<Count> incread(@RequestBody CountDTO countDTO) {
        Count count = countService.incread(countDTO);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/decread")
    public ResponseEntity<Count> decread(@RequestBody CountDTO countDTO) {
        Count count = countService.decread(countDTO);
        return ResponseEntity.ok(count);
    }

    @GetMapping
    public ResponseEntity<CountDTO> getCount(@RequestParam Integer countId) {
        CountDTO countDTO = countService.getCount(countId);
        return ResponseEntity.ok(countDTO);
    }

}
