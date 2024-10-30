package com.example.tourdulich.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.R;
import com.example.tourdulich.model.Tour;
import com.example.tourdulich.model.TourFavorite;

import java.util.List;

public class TourFavoriteAdapter extends RecyclerView.Adapter<TourFavoriteAdapter.TourViewHolder>{

    private List<TourFavorite> mListTourFavorite;


    public void setData(List<TourFavorite> list){
        this.mListTourFavorite = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour_favorite, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        TourFavorite tourFavorite = mListTourFavorite.get(position);
        if(tourFavorite == null){
            return;
        }

        holder.imgTourFavorite.setImageResource(tourFavorite.getResourceImage());
        holder.tvTourFavoriteName.setText(tourFavorite.getName());
        holder.tvTourFavoriteDescription.setText(tourFavorite.getDescription());
        holder.tvTourFavoritePrice.setText(tourFavorite.getPrice());
    }

    @Override
    public int getItemCount() {
        if(mListTourFavorite != null) {
            return mListTourFavorite.size();
        }
        return 0;
    }

    public class TourViewHolder extends RecyclerView.ViewHolder{
        // Khai báo những thành phần view có trong file item_tour
        private ImageView imgTourFavorite;
        private TextView tvTourFavoriteName;
        private TextView tvTourFavoriteDescription;
        private TextView tvTourFavoritePrice;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTourFavorite = itemView.findViewById(R.id.img_tour_favorite);
            tvTourFavoriteName = itemView.findViewById(R.id.tv_tour_favorite_name);
            tvTourFavoriteDescription = itemView.findViewById(R.id.tv_tour_favorite_description);
            tvTourFavoritePrice = itemView.findViewById(R.id.tv_tour_favorite_price);
        }
    }
}
