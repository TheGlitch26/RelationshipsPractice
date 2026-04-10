package com.ironhack.demo_lab.controller;


import com.ironhack.demo_lab.dto.AlbumRequest;
import com.ironhack.demo_lab.entity.Album;
import com.ironhack.demo_lab.entity.Artist;
import com.ironhack.demo_lab.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAlbums(@RequestParam(required = false) Long artistId){
        if(artistId == null){
            return albumService.findAll();
        }

        return albumService.findByArtistId(artistId);
    }

    @GetMapping("/{id}")
    public Album getAlbumsById(@PathVariable Long id){
        return albumService.findById(id);
    }

    @GetMapping("/count")
    public List<Object[]> countAlbumsPerArtist(){
        return albumService.countAlbumsPerArtist();
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody AlbumRequest albumRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.create(albumRequest));
    }
}
