package com.example.tourdulich.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.example.tourdulich.R;
import com.example.tourdulich.adapter.ListDataAdapter;
import com.example.tourdulich.adapter.TourFavoriteAdapter;
import com.example.tourdulich.model.ListData;
import com.example.tourdulich.model.Tour;
import com.example.tourdulich.model.TourFavorite;
import com.example.tourdulich.model.TourHeader;

public class HomeFragment extends Fragment {

    private View mView;
    private RecyclerView rcvTour;
    private ListDataAdapter listDataAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        // Bắt sự kiện cho trang Home
        rcvTour = mView.findViewById(R.id.rcv_tour);
        listDataAdapter = new ListDataAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        rcvTour.setLayoutManager(linearLayoutManager);


        listDataAdapter.setData(getListDatas(), requireContext());
        rcvTour.setAdapter(listDataAdapter);

        return mView;
    }

    private List<ListData> getListDatas() {
        List<ListData> listData = new ArrayList<>();

        List<TourFavorite> listTourFavorite = new ArrayList<>();
        listTourFavorite.add(new TourFavorite(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ"));
        listTourFavorite.add(new TourFavorite(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ"));
        listTourFavorite.add(new TourFavorite(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ"));
        listTourFavorite.add(new TourFavorite(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ"));
        listTourFavorite.add(new TourFavorite(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ"));
        listTourFavorite.add(new TourFavorite(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ"));

        List<Tour> listTour = new ArrayList<>();
        listTour.add(new Tour(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ"));
        listTour.add(new Tour(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ"));
        listTour.add(new Tour(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ"));
        listTour.add(new Tour(R.drawable.nghinhphong, "Tour 1", "2 ngày 1 đêm", "300.000đ"));
        listTour.add(new Tour(R.drawable.nghinhphong2, "Tour 2", "2 ngày 1 đêm", "300.000đ"));
        listTour.add(new Tour(R.drawable.wallpaper, "Tour 3", "2 ngày 1 đêm", "300.000đ"));

        List<TourHeader> listTourHeader = new ArrayList<>();
        listTourHeader.add(new TourHeader(R.drawable.nghinhphong));
        listTourHeader.add(new TourHeader(R.drawable.nghinhphong2));
        listTourHeader.add(new TourHeader(R.drawable.wallpaper));
        listTourHeader.add(new TourHeader(R.drawable.nghinhphong));
        listTourHeader.add(new TourHeader(R.drawable.nghinhphong2));
        listTourHeader.add(new TourHeader(R.drawable.wallpaper));

        listData.add(new ListData(ListDataAdapter.TYPE_TOUR_HEADER, null, null, listTourHeader));
        listData.add(new ListData(ListDataAdapter.TYPE_EDT_SEARCH, null, null, null));
        listData.add(new ListData(ListDataAdapter.TYPE_TV, null, null, null));
        listData.add(new ListData(ListDataAdapter.TYPE_TOUR, null, listTour, null));
        listData.add(new ListData(ListDataAdapter.TYPE_TOURFAVORITE, listTourFavorite, null, null));
        listData.add(new ListData(ListDataAdapter.TYPE_TOUR, null, listTour, null));

        return listData;
    }


}
