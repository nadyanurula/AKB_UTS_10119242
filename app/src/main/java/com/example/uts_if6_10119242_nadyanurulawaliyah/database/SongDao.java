package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SongDao {
    @Query("SELECT * FROM song")
    List<Song> getAllSongs();

    @Query("DELETE FROM song")
    void deleteAllSongs();
    @Insert
    void insert(Song... Songs);
}
