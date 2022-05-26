package org.example.controllers;

import org.example.entities.PostOffice;
import org.example.services.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/office_filter")
public class PostOfficeFilterController {
    @Autowired
    private PostOfficeService postOfficeService;

    @GetMapping("{field}/{param}")
    public ResponseEntity<List<PostOffice>> filterDepartures(@PathVariable String field, @PathVariable String param){
        return ResponseEntity.ok(postOfficeService.filterOffices(field, param));
    }
}
