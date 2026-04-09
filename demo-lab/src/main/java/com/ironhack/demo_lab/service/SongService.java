package com.ironhack.demo_lab.service;


import com.ironhack.demo_lab.entity.Album;
import com.ironhack.demo_lab.entity.Song;
import com.ironhack.demo_lab.repository.AlbumRepository;
import com.ironhack.demo_lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final AlbumService albumService;

    public SongService(SongRepository songRepository, AlbumService albumService) {
        this.songRepository = songRepository;
        this.albumService = albumService;
    }

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public Song findById(Long id){
        return songRepository.findById(id).orElseThrow(() -> new RuntimeException("Song not found!"));
    }

    public Song create(Song song, Long albumId){
        Song createdSong = new Song(song.getTitle(), song.getDurationSeconds(), song.getTrackNumber());
        Album foundAlbum = albumService.findById(albumId);
        if(foundAlbum == null){

        }
    }
}
