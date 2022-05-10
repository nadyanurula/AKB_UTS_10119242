package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Friend {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="friend_name")
    public String friendName;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Friend(String friendName,String imagename){
        this.friendName = friendName;
        this.imagename = imagename;
    }

    public static Friend[] isiData(){
        return new Friend[]{
                new Friend("Teman teman ", "image2"),
                new Friend("Teman makan ", "image3"),

        };
    }


}

