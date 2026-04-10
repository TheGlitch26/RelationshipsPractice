package com.ironhack.demo_lab.controller;


import com.ironhack.demo_lab.dto.SongRequest;
import com.ironhack.demo_lab.entity.Artist;
import com.ironhack.demo_lab.entity.Song;
import com.ironhack.demo_lab.service.SongService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }


    @GetMapping
    public List<Song> getSongs(@RequestParam(required = false) Long albumId){
        if(albumId == null){
            return songService.findAll();
        }
        return songService.findByAlbumId(albumId);
    }

    @GetMapping("/{id}")
    public Song getSongsById(@PathVariable Long id){
        return songService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@Valid @RequestBody SongRequest songRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(songService.create(songRequest));
    }
}
