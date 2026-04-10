package com.ironhack.demo_lab.service;


import com.ironhack.demo_lab.dto.SongRequest;
import com.ironhack.demo_lab.entity.Album;
import com.ironhack.demo_lab.entity.Song;
import com.ironhack.demo_lab.repository.AlbumRepository;
import com.ironhack.demo_lab.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongService(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> findAll(){
        return songRepository.findAll();
    }

    public Song findById(Long id){
        return songRepository.findById(id).orElseThrow(() -> new RuntimeException("Song not found!"));
    }

    public List<Song> findByAlbumId(Long albumId){
        return songRepository.findByAlbumId(albumId);
    }

    public Song create(SongRequest songRequest){
        Album foundAlbum = albumRepository.findById(songRequest.getAlbumId()).orElseThrow(
                () -> new NullPointerException("An album with this id is not found: " + songRequest.getAlbumId())
        );

        Song song = new Song(songRequest.getTitle(), songRequest.getDurationSeconds(), songRequest.getTrackNumber());
        song.setAlbum(foundAlbum);
        songRepository.save(song);
        return song;
    }
}
