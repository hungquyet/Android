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

public class TourManagerAdapter extends RecyclerView.Adapter<TourManagerAdapter.TourManagerViewHolder> {
    private Context mContext;
    private List<Tour> mListTour;

    public TourManagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Tour> list){
        mListTour = list;
        // Load dữ liệu vào adapter
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourManagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourManagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourManagerViewHolder holder, int position) {
        Tour tour = mListTour.get(position);
        if(tour == null){
            return;
        }

        holder.imgTour.setImageResource(tour.getResourceImage());
        holder.tvName.setText(tour.getName());
        holder.tvDescription.setText(tour.getDescription());
        holder.tvPrice.setText(tour.getPrice());
    }

    @Override
    public int getItemCount() {
        if(mListTour != null){
            return mListTour.size();
        }
        return 0;
    }

    public class TourManagerViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgTour;
        private TextView tvName;
        private TextView tvDescription;
        private TextView tvPrice;

        public TourManagerViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTour = itemView.findViewById(R.id.img_tour);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
