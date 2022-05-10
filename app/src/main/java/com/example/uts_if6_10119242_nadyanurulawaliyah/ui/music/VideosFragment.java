package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.music;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.AppDatabase;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Song;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Videos;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.SongsFragmentBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.VideosFragmentBinding;

import java.util.List;


public class VideosFragment extends Fragment {

    private VideosListAdapter videosListAdapter;
    private VideosFragmentBinding binding;
    public static VideosFragment newInstance() {
        return new VideosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = VideosFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        initRecycle();

        loadVideosList();

        return root;
    }
    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewVideos;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        videosListAdapter = new VideosListAdapter(this.getLifecycle());
        recyclerView.setAdapter((videosListAdapter));
    }

    private void loadVideosList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Videos> videosList = db.videosDao().getAllVideos();
        videosListAdapter.setVideosList(videosList);
    }

}