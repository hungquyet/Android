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

import java.util.List;

public class TourBookingAdapter extends RecyclerView.Adapter<TourBookingAdapter.TourViewHolder>{
    private Context mContext;
    private List<Tour> mListTour;

    public TourBookingAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public TourBookingAdapter() {
    }
    public void setData(List<Tour> list){
        this.mListTour = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour_booking, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = mListTour.get(position);
        if(tour == null){
            return;
        }

        holder.imgTour.setImageResource(tour.getResourceImage());
        holder.tvName.setText(tour.getName());
        holder.tvDescription.setText(tour.getDescription());
        holder.tvPrice.setText(tour.getPrice());
        holder.tvStatus.setText(tour.getStatus());
    }

    @Override
    public int getItemCount() {
        if(mListTour != null){
            return mListTour.size();
        }
        return 0;
    }

    public class TourViewHolder extends RecyclerView.ViewHolder{
        // Khai báo các thành phần có trong layout item
        private ImageView imgTour;
        private TextView tvName;
        private TextView tvDescription;
        private TextView tvPrice;
        private TextView tvStatus;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTour = itemView.findViewById(R.id.img_tour);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvStatus = itemView.findViewById(R.id.tv_status);

        }
    }
}
