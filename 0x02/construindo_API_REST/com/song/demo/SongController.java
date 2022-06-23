package com.song.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/")
    public String apiSong(){
        return "Hi, you are in the SongAPI!";
    }

    @GetMapping("/welcome")
    public String mensagemBoasVindas(){
        return "Welcome to our application!";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs(){
        return songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public Song findSongById(@PathVariable Integer id){
        return songRepository.getSongById(id);
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public Song addSong(@RequestBody Song song){
        try {
            songRepository.addSong(song);
            System.out.println("Song added successfully!");

        } catch (Exception e) {
            System.out.println("Error in add song: " + e.getMessage());
        }

        return song;
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public Song updateSong(@RequestBody Song song){
        try {
            songRepository.updateSong(song);
            System.out.println("Song " + song.getNome() + " updated successfully!");
        } catch (Exception e){
            System.out.println("Error on update song " + song.getNome() + ": " + e.getMessage());
        }

        return song;
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public void deleteSongById(@RequestBody Song song){
        try {
            songRepository.removeSong(song);
            System.out.println("Song deleted successfully!");
        } catch (Exception e){
            System.out.println("Error on delete song " + song.getNome() + ": " + e.getMessage());
        }
    }
}
