package com.example.uts_if6_10119242_nadyanurulawaliyah.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Song {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name ="imagename")
    public String imagename;

    @ColumnInfo(name ="titlesong")
    public String titlesong;

    @ColumnInfo(name ="artistname")
    public String artistname;

    public Song(String imagename,String titlesong,String artistname){
        this.imagename = imagename;
        this.titlesong = titlesong;
        this.artistname = artistname;
    }

    public static Song[] isiLagu(){
        return new Song[]{
                new Song("_pemuda","PECAH SERIBU","ELVY SUKAESIH"),
                new Song("uyetone","YANG SEDANG-SEDANG SAJA","KALIA SISKA ft SKA 86"),
                new Song("uyetone","SENYUM MEMBAWA LUKA (ANGGUR MERAH)","KALIA SISKA ft SKA 86"),
                new Song("uyetone","CINTA BAWA DUKA RINDU BALAS DENDAM (JALAN DATAR)","KALIA SISKA ft SKA 86"),

        };
    }
}
