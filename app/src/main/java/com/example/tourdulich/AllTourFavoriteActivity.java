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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.adapter.ListDataAdapter;
import com.example.tourdulich.adapter.TourFavoriteAdapter;
import com.example.tourdulich.model.ListData;
import com.example.tourdulich.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class AllTourFavoriteActivity extends AppCompatActivity {
    RecyclerView rcv_allTourFavorite;
    TourFavoriteAdapter mTourFavoriteAdapter;
    ImageView img_exitAllTourFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_tour_favorite);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        img_exitAllTourFavorite = findViewById(R.id.img_exitAllTourFavorite);
        rcv_allTourFavorite = findViewById(R.id.rcv_allTourFavorite);
        mTourFavoriteAdapter = new TourFavoriteAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        rcv_allTourFavorite.setLayoutManager(gridLayoutManager);

        mTourFavoriteAdapter.setData(getListTourFavorite());
        rcv_allTourFavorite.setAdapter(mTourFavoriteAdapter);

        img_exitAllTourFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllTourFavoriteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Tour> getListTourFavorite(){
        List<Tour> listTourFavorite = new ArrayList<>();
        listTourFavorite.add(new Tour(R.drawable.nghinhphong, "Tour 1", "300.000đ"));
        listTourFavorite.add(new Tour(R.drawable.nghinhphong2, "Tour 2" , "300.000đ"));
        listTourFavorite.add(new Tour(R.drawable.wallpaper, "Tour 3", "300.000đ"));
        listTourFavorite.add(new Tour(R.drawable.nghinhphong, "Tour 1" , "300.000đ"));
        listTourFavorite.add(new Tour(R.drawable.nghinhphong2, "Tour 2" , "300.000đ"));
        listTourFavorite.add(new Tour(R.drawable.wallpaper, "Tour 3", "300.000đ"));

        return listTourFavorite;
    }
}