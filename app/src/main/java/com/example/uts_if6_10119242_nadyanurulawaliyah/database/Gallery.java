package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Gallery {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Gallery(String imagename){
        this.imagename = imagename;
    }
    public static Gallery[] isiFoto(){
        return new Gallery[]{
                new Gallery("image1"),
                new Gallery("image2"),
                new Gallery("image3"),

        };
    }
}
