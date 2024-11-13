package com.example.tourdulich.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.R;
import com.example.tourdulich.model.Tour;

import java.util.List;

public class TourImageAdapter extends RecyclerView.Adapter<TourImageAdapter.TourHeaderViewHolder>{

    private List<Tour> mListTourHeader;

    public void setData(List<Tour> list){
        this.mListTourHeader = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourHeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour_header, parent, false);
        return new TourImageAdapter.TourHeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourHeaderViewHolder holder, int position) {
        Tour tourImage = mListTourHeader.get(position);
        if(tourImage == null){
            return;
        }

        holder.imgTour.setImageResource(tourImage.getResourceImage());
    }

    @Override
    public int getItemCount() {
        if(mListTourHeader != null){
            return mListTourHeader.size();
        }
        return 0;
    }

    public class TourHeaderViewHolder extends RecyclerView.ViewHolder{
        // Khai báo các thành phần có trong layout item
        private ImageView imgTour;

        public TourHeaderViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTour = itemView.findViewById(R.id.img_tour_header);

        }
    }

}
