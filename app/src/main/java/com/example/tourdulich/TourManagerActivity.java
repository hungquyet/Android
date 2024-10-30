package com.example.tourdulich;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.adapter.TourAdapter;
import com.example.tourdulich.adapter.TourManagerAdapter;
import com.example.tourdulich.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class TourManagerActivity extends AppCompatActivity {
    RecyclerView rcv_tourManager;
    TourManagerAdapter tourManagerAdapter;
    ImageView img_exitTourManager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tour_manager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        img_exitTourManager = findViewById(R.id.img_exitTourManager);

        rcv_tourManager = findViewById(R.id.rcv_tourManager);
        tourManagerAdapter = new TourManagerAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcv_tourManager.setLayoutManager(linearLayoutManager);

        tourManagerAdapter.setData(getListTour());
        rcv_tourManager.setAdapter(tourManagerAdapter);

        img_exitTourManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourManagerActivity.this, AdminActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private List<Tour> getListTour(){
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