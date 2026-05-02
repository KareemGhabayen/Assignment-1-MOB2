package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Fragment2.OnFragment2DataListener {

    private ActivityMainBinding binding;
    private int currentFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new Fragment1())
                .commit();

        binding.buttonContinue.setOnClickListener(view -> {
            if (currentFragment == 1) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Fragment2(), "FRAG2")
                        .addToBackStack(null)
                        .commit();
                currentFragment = 2;
            } else if (currentFragment == 2) {
                Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentByTag("FRAG2");
                if (fragment2 != null) {
                    fragment2.sendDataToActivity();
                }
            }
        });
    }

    @Override
    public void onDataSent(String name) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter name!", Toast.LENGTH_SHORT).show();
        } else {
            Fragment3 fragment3 = Fragment3.newInstance(name);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment3)
                    .addToBackStack(null)
                    .commit();

            currentFragment = 3;
            binding.buttonContinue.setVisibility(android.view.View.GONE);
        }
    }
    private void navigateToFragment3(String userName) {

        Toast.makeText(this, "Welcome " + userName + ", moving to Step 3", Toast.LENGTH_SHORT).show();
    }
}