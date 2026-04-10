package com.ironhack.demo_lab.controller;


import com.ironhack.demo_lab.entity.Artist;
import com.ironhack.demo_lab.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }


    @GetMapping
    public List<Artist> getArtists(@RequestParam(required = false) String genre){
        if(genre == null || genre.isBlank()){
            return artistService.findAll();
        }
        return artistService.findByGenre(genre);
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id){
        return artistService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Artist> createArtist(@Valid @RequestBody Artist artist){
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.create(artist));
    }
}
