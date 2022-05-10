package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.profile;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.example.uts_if6_10119242_nadyanurulawaliyah.MainActivity;
import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.FragmentProfileBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.ui.music.SongsFragment;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TabLayout tabLayout = binding.profileLayout;
        selectedTab(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                selectedTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        FloatingActionButton fab = binding.buttoninfo;
        fab.setOnClickListener(view -> {
            final Dialog dialog = new Dialog(binding.getRoot().getContext());
            dialog.setContentView(R.layout.about_fragment);
            dialog.setTitle("About");
            dialog.show();
        });
        return root;
    }
    private void selectedTab(int position) {
        Fragment tabFragment;
        if(position == 1){
            tabFragment = new ContactFragment();
        } else if(position == 2) {
            tabFragment = new FindmeFragment();
        } else {
            tabFragment = new DetailProfileFragment();
        }

        FragmentManager fm = getChildFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.profile_linear, tabFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
