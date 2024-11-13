package com.example.tourdulich.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.tourdulich.BookedTourActivity;
import com.example.tourdulich.R;
import com.example.tourdulich.UpdateInfoActivity;

public class ProfileFragment extends Fragment {

    private View mView;
    private ConstraintLayout csl_updateInfo, csl_bookedTour;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        // Bắt sự kiện cho trang Contact

        csl_updateInfo = mView.findViewById(R.id.csl_updateInfo);
        csl_bookedTour = mView.findViewById(R.id.csl_bookedTour);

        csl_bookedTour.setOnClickListener(v -> openBookedTourActivity());
        csl_updateInfo.setOnClickListener(v -> openUpdateInfoActivity());
        return mView;
    }

    private void openBookedTourActivity() {
        Intent intent = new Intent(getActivity(), BookedTourActivity.class);
        startActivity(intent);
    }

    private void openUpdateInfoActivity() {
        Intent intent = new Intent(getActivity(), UpdateInfoActivity.class);
        startActivity(intent);
    }

}
