package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.profile;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.ContactFragmentBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.FragmentMusicBinding;
import com.example.uts_if6_10119242_nadyanurulawaliyah.databinding.FragmentProfileBinding;

public class ContactFragment extends Fragment {
    private ContactFragmentBinding binding;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ContactFragmentBinding .inflate(inflater, container, false);
        TextView waText = binding.textwa;
        waText.setOnClickListener(view -> {
            String url = "https://api.whatsapp.com/send?phone=+6285775341447";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        TextView igText = binding.textig;
        igText.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://instagram.com/_u/nadyanurulawaliyah10");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/nadyanurulawaliyah10")));
            }
        });

        return binding.getRoot();
    }


}