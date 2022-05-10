package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily;

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
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Activities;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.AppDatabase;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.ActivityFragmentBinding;

import java.util.List;
import java.util.concurrent.Executors;


public class ActivityFragment extends Fragment {

    private ActivityListAdapter activityListAdapter;
    Button button;
    private ActivityFragmentBinding binding;
    public static ActivityFragment newInstance() {
        return new ActivityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ActivityFragmentBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

        initRecycle();

        loadActivitiesList();

        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        Handler handler = new Handler(Looper.getMainLooper());

        FloatingActionButton fabButton = binding.clearTable;
        fabButton.setOnClickListener(view -> Executors.newSingleThreadExecutor().execute(() ->
        {
            db.activitiesDao().deleteAllActivities();
            db.activitiesDao().insert(Activities.isiAktifitas());
            handler.post(this::loadActivitiesList);
        }));


        return root;
    }
    private void initRecycle() {
        RecyclerView recyclerView = binding.recycleviewActivity;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        activityListAdapter = new ActivityListAdapter(binding.getRoot().getContext());
        recyclerView.setAdapter((activityListAdapter));
    }

    private void loadActivitiesList() {
        AppDatabase db =AppDatabase.getDbInstance((binding.getRoot().getContext()));
        List<Activities> activitiesList = db.activitiesDao().getAllActivities();
        activityListAdapter.setActivitiesList(activitiesList);
    }


}