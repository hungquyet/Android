package com.example.tourdulich.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.R;
import com.example.tourdulich.adapter.ListDataAdapter;
import com.example.tourdulich.model.ListData;
import com.example.tourdulich.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class InformationFragment extends Fragment {
    private View mView;
    private RecyclerView rcv_information;
    private ListDataAdapter listDataAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_infomation, container, false);
        // Bắt sự kiện cho trang Home

        rcv_information = mView.findViewById(R.id.rcv_information);
        listDataAdapter = new ListDataAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        rcv_information.setLayoutManager(linearLayoutManager);


        listDataAdapter.setData(getListDatas(), requireContext());
        rcv_information.setAdapter(listDataAdapter);

        return mView;
    }

    private List<ListData> getListDatas() {
        List<ListData> list = new ArrayList<>();

        List<Tour> listImage = new ArrayList<>();
        listImage.add(new Tour(R.drawable.nghinhphong));
        listImage.add(new Tour(R.drawable.nghinhphong2));
        listImage.add(new Tour(R.drawable.wallpaper));
        listImage.add(new Tour(R.drawable.nghinhphong));
        listImage.add(new Tour(R.drawable.nghinhphong2));
        listImage.add(new Tour(R.drawable.wallpaper));

        list.add(new ListData(ListDataAdapter.TYPE_CV_INFO, null));
        list.add(new ListData(ListDataAdapter.TYPE_CV_IMAGE, listImage));
        return list;

    }


}
