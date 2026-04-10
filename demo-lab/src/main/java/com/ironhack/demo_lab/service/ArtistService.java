package com.ironhack.demo_lab.service;

import com.ironhack.demo_lab.entity.Artist;
import com.ironhack.demo_lab.repository.AlbumRepository;
import com.ironhack.demo_lab.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    public List<Artist> findAll(){
        return artistRepository.findAll();
    }

    public Artist findById(Long id){
        return artistRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Artist with this id is not found: " + id)
        );
    }

    public List<Artist> findByGenre(String genre){
        return artistRepository.findByGenre(genre);
    }

    public Artist create(Artist artist){
        Artist createdArtist = new Artist(
                artist.getName(),
                artist.getGenre(),
                artist.getCountry()
        );
        artistRepository.save(createdArtist);
        return createdArtist;
    }
}
