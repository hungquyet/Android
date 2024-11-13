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

public class TourDetailImageAdapter extends RecyclerView.Adapter<TourDetailImageAdapter.TourDetailImageViewHolder>{

    private List<Tour> mListTourImage;

    public void setData(List<Tour> list){
        this.mListTourImage = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourDetailImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv_image, parent, false);
        return new TourDetailImageAdapter.TourDetailImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourDetailImageViewHolder holder, int position) {
        Tour tourDetailImage = mListTourImage.get(position);
        if(tourDetailImage == null){
            return;
        }

        holder.img_tour_detail.setImageResource(tourDetailImage.getResourceImage());
    }

    @Override
    public int getItemCount() {
        if(mListTourImage != null){
            return mListTourImage.size();
        }
        return 0;
    }

    public class TourDetailImageViewHolder extends RecyclerView.ViewHolder{
        // Khai báo các thành phần có trong layout item
        private ImageView img_tour_detail;

        public TourDetailImageViewHolder(@NonNull View itemView) {
            super(itemView);

            img_tour_detail = itemView.findViewById(R.id.img_tour_detail);

        }
    }

}
