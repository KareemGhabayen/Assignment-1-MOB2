package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    private Fragment2Binding binding;

    private OnFragment2DataListener listener;

    public interface OnFragment2DataListener {
        void onDataSent(String name);
    }

    public Fragment2() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2DataListener) {
            listener = (OnFragment2DataListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragment2DataListener");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void sendDataToActivity() {
        if (binding != null) {
            String name = binding.editTextName.getText().toString();
            if (listener != null) {
                listener.onDataSent(name);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}