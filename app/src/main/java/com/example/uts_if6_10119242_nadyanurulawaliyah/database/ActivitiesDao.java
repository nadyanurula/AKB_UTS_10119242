package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import android.app.ListActivity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ActivitiesDao {

        @Query("SELECT * FROM activities")
        List<Activities> getAllActivities();

        @Query("DELETE FROM activities")
        void deleteAllActivities();
        @Insert
        void insert(Activities... Activities);
}
