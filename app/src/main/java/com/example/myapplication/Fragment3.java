package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.Fragment3Binding;

public class Fragment3 extends Fragment {

    private Fragment3Binding binding;
    private static final String ARG_NAME = "user_name";
    private String name;

    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = Fragment3Binding.inflate(inflater, container, false);

        binding.tvWelcomeName.setText("Hello, " + name + "!");

        binding.cbConfirm.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.btnFinish.setEnabled(true);
                binding.btnFinish.setText("Finish");
            } else {
                binding.btnFinish.setEnabled(false);
                binding.btnFinish.setText("Continue");
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}