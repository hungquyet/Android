package com.example.tourdulich;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.adapter.ListDataAdapter;
import com.example.tourdulich.model.ListData;
import com.example.tourdulich.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class BookedTourActivity extends AppCompatActivity {
    private RecyclerView rcv_booking;
    private ListDataAdapter listDataAdapter;
    private ImageView img_exit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booked_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        img_exit = findViewById(R.id.img_exit);
        rcv_booking = findViewById(R.id.rcv_bookedTour);
        listDataAdapter = new ListDataAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_booking.setLayoutManager(linearLayoutManager);

        img_exit.setOnClickListener(view -> finish());

        listDataAdapter.setData(getListDatas(), this);
        rcv_booking.setAdapter(listDataAdapter);
    }

    private List<ListData> getListDatas() {
        List<ListData> listData = new ArrayList<>();

        List<Tour> listTour = new ArrayList<>();
        listTour.add(new Tour(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ", "Đã thanh toán"));
        listTour.add(new Tour(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ","Đang xử lý"));
        listTour.add(new Tour(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ", "Đã thanh toán"));
        listTour.add(new Tour(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ","Đang xử lý"));
        listTour.add(new Tour(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ","Đang xử lý"));
        listTour.add(new Tour(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ","Đang xử lý"));


        listData.add(new ListData(ListDataAdapter.TYPE_TOUR_BOOKING, listTour));

        return listData;
    }
}