package com.example.tourdulich;

import android.app.Dialog;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tourdulich.fragment.InformationFragment;
import com.example.tourdulich.fragment.ScheduleFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class TourDetailActivity extends AppCompatActivity {
    Button btn_infor, btn_schedule;
    ImageView img_back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tour_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if (savedInstanceState == null) { // Chỉ thêm fragment mặc định nếu chưa có fragment nào
            replaceFragment(new InformationFragment());
        }

        img_back = findViewById(R.id.img_back);
        btn_infor = findViewById(R.id.btn_infor);
        btn_schedule = findViewById(R.id.btn_schedule);

        btn_infor.setOnClickListener(v -> replaceFragment(new InformationFragment()));
        btn_schedule.setOnClickListener(v -> replaceFragment(new ScheduleFragment()));

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment); // R.id.fragment_container là ID của view để chứa fragment
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}