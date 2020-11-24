package com.example.warService.api;

import com.example.warService.service.WarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/war")
public class WarController {

    @Autowired
    private WarService service;

    @GetMapping
    public ResponseEntity<Boolean> war(@RequestParam String kingdom1, @RequestParam String kingdom2)
    {
        return ResponseEntity.ok(service.war(kingdom1, kingdom2));
    }
}
