package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Videos {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="videoid")
    public String videoid;

    public Videos(String videoid){
        this.videoid = videoid;
    }

    public static Videos[] isiVideo(){
        return new Videos[]{
                new Videos("1Ma65-Xr4MI"),
                new Videos("bDxj87pn5zM"),
                new Videos("fO36eL-QfRY"),


        };
    }
}
