package com.ironhack.demo_lab.repository;


import com.ironhack.demo_lab.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByArtistId(Long artistId);

    @Query("SELECT a.artist.name, COUNT(a) FROM Album a GROUP BY a.artist.name")
    List<Object[]> countAlbumByArtist();
}
