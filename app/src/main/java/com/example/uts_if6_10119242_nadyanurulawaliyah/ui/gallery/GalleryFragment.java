package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.gallery;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.uts_if6_10119242_nadyanurulawaliyah.MainActivity;
import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Activities;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.AppDatabase;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Friend;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Gallery;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.FragmentGalleryBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily.FriendsFragment;
import com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily.FriendsListAdapter;

import java.util.List;
import java.util.concurrent.Executors;


public class GalleryFragment extends Fragment {

    private GalleryListAdapter galleryListAdapter;
    private FragmentGalleryBinding binding;
    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initRecycle();

        loadGalleryList();



        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        FloatingActionButton fabButton = binding.clearTable;
        fabButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.galleryDao().deleteAllGallery();
            db.galleryDao().insert(Gallery.isiFoto());
            handler.post(this::loadGalleryList);
        }));
        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewGallery;
        recyclerView.setLayoutManager(new GridLayoutManager(binding.getRoot().getContext(),
                2));

        galleryListAdapter = new GalleryListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((galleryListAdapter));
    }

    private void loadGalleryList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Gallery> galleryList = db.galleryDao().getAllGallery();
        galleryListAdapter.setGalleryList(galleryList);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}