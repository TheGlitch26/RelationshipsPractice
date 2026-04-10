package com.ironhack.demo_lab.service;


import com.ironhack.demo_lab.dto.AlbumRequest;
import com.ironhack.demo_lab.entity.Album;
import com.ironhack.demo_lab.entity.Artist;
import com.ironhack.demo_lab.repository.AlbumRepository;
import com.ironhack.demo_lab.repository.ArtistRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }




    public List<Album> findAll(){
        return albumRepository.findAll();
    }

    public Album findById(Long id){
        return albumRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Could not find album with this id: " + id)
        );
    }

    public List<Album> findByArtistId(Long artistId){
        return albumRepository.findByArtistId(artistId);
    }


    public Album create(AlbumRequest albumRequest){
        Artist foundArtist = artistRepository.findById(albumRequest.getArtistId()).orElseThrow(
                () -> new IllegalArgumentException("Could not find album with this id: " + albumRequest.getArtistId())
        );

        Album album = new Album(albumRequest.getTitle(), albumRequest.getReleaseYear());
        album.setArtist(foundArtist);
        albumRepository.save(album);
        return album;
    }

    public List<Object[]> countAlbumsPerArtist(){
        return albumRepository.countAlbumByArtist();
    }

}
