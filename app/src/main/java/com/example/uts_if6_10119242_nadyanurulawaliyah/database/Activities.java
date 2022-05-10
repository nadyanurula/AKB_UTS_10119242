package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Activities {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="kegiatan")
    public String kegiatan;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public Activities(String kegiatan,String imagename){
        this.kegiatan = kegiatan;
        this.imagename = imagename;
    }

    public static Activities[] isiAktifitas(){
        return new Activities[]{
                new Activities("Menonton youtube","youtube"),
                new Activities("Berkumpul dengan teman","image2"),
                new Activities("Menonton Tiktok","tiktok"),

        };
    }
}
