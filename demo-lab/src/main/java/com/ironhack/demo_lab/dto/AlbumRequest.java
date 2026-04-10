package com.ironhack.demo_lab.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AlbumRequest {

    @NotNull
    @NotBlank
    @Size(max = 200, message = "Album title cannot be longer than 200 characters!")
    private String title;

    @NotNull
    private Integer releaseYear;

    @NotNull
    private Long artistId;

    public AlbumRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
}
