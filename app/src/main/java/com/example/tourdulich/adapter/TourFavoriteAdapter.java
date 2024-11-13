package com.example.tourdulich.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourdulich.R;
import com.example.tourdulich.TourDetailActivity;
import com.example.tourdulich.model.Tour;

import java.util.List;

public class TourFavoriteAdapter extends RecyclerView.Adapter<TourFavoriteAdapter.TourFavoriteViewHolder>{

    private List<Tour> mListTourFavorite;
    private Context mContext;

    public TourFavoriteAdapter(Context mContext) {
        this.mContext = mContext;
    }



    public void setData(List<Tour> list){
        this.mListTourFavorite = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourFavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour_favorite, parent, false);
        return new TourFavoriteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourFavoriteViewHolder holder, int position) {
        Tour tourFavorite = mListTourFavorite.get(position);
        if (tourFavorite == null) {
            return;
        }

        holder.imgTourFavorite.setImageResource(tourFavorite.getResourceImage());
        holder.tvTourFavoriteName.setText(tourFavorite.getName());
        holder.tvTourFavoritePrice.setText(tourFavorite.getPrice());

        holder.tv_bookNow.setOnClickListener(view -> {
            Intent intent = new Intent(mContext, TourDetailActivity.class);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        if(mListTourFavorite != null) {
            return mListTourFavorite.size();
        }
        return 0;
    }

    public class TourFavoriteViewHolder extends RecyclerView.ViewHolder{
        // Khai báo những thành phần view có trong file item_tour
        private TextView tvTourFavoriteName;
        private TextView tvTourFavoritePrice;
        private ImageView imgTourFavorite;
        private TextView tv_bookNow;

        public TourFavoriteViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTourFavorite = itemView.findViewById(R.id.img_tour_favorite);
            tvTourFavoriteName = itemView.findViewById(R.id.tv_tour_favorite_name);
            tvTourFavoritePrice = itemView.findViewById(R.id.tv_tour_favorite_price);
            tv_bookNow = itemView.findViewById(R.id.tv_bookNow);
        }
    }
}
