package com.example.tourdulich;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.adapter.TourAdapter;
import com.example.tourdulich.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class AllTourActivity extends AppCompatActivity {
    RecyclerView rcv_allTour;
    TourAdapter tourAdapter;
    ImageView img_exitAllTour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        img_exitAllTour = findViewById(R.id.img_exitAllTour);
        rcv_allTour = findViewById(R.id.rcv_allTour);
        tourAdapter = new TourAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv_allTour.setLayoutManager(linearLayoutManager);

        tourAdapter.setData(getListTour());
        rcv_allTour.setAdapter(tourAdapter);

        img_exitAllTour.setOnClickListener(view -> finish());
    }

    private List<Tour> getListTour() {
        List<Tour> list = new ArrayList<>();

        list.add(new Tour(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ"));
        list.add(new Tour(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ"));
        list.add(new Tour(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ"));
        list.add(new Tour(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ"));
        list.add(new Tour(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ"));
        list.add(new Tour(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ"));

        return list;
    }
}