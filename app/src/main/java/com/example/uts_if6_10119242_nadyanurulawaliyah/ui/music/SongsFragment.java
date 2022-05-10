package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.music;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Activities;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.AppDatabase;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Song;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.ActivityFragmentBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.SongsFragmentBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily.ActivityFragment;
import com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily.ActivityListAdapter;

import java.util.List;
import java.util.concurrent.Executors;


public class SongsFragment extends Fragment {

    private SongsListAdapter songsListAdapter;
    private SongsFragmentBinding binding;
    public static SongsFragment newInstance() {
        return new SongsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SongsFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        initRecycle();

        loadSongsList();

        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        FloatingActionButton fabButton = binding.clearTable;
        fabButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.songDao().deleteAllSongs();
            db.songDao().insert(Song.isiLagu());
            handler.post(this::loadSongsList);
        }));

        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewSongs;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        songsListAdapter = new SongsListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((songsListAdapter));
    }

    private void loadSongsList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Song> songList = db.songDao().getAllSongs();
        songsListAdapter.setSongsList(songList);
    }

}