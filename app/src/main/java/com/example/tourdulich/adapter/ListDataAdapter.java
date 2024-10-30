package com.example.tourdulich.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.tourdulich.R;
import com.example.tourdulich.model.ListData;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder>{

    public static final int TYPE_TOURFAVORITE = 1;
    public static final int TYPE_TOUR = 2;
    public static final int TYPE_TOUR_HEADER = 3;

    private List<ListData> mListData;
    private Context mContext;

    public void setData(List<ListData> listData, Context context){
        this.mListData = listData;
        this.mContext = context;
        notifyDataSetChanged();
    }

    // Hàm lấy ra type muốn hiển thị
    @Override
    public int getItemViewType(int position) {
        return mListData.get(position).getType();
    }

    @NonNull
    @Override
    public ListDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_data, parent, false);
        return new ListDataViewHolder(view);
    }

    // Hàm phân biệt khi nào xử dụng type nàp
    @Override
    public void onBindViewHolder(@NonNull ListDataViewHolder holder, int position) {
        ListData listData = mListData.get(position);
        if(listData == null){
            return;
        }
        if(TYPE_TOURFAVORITE == holder.getItemViewType()){
            // Nếu adapter đã được gán thì không gán lại
            if(holder.rcvItem.getAdapter() == null) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
                holder.rcvItem.setLayoutManager(linearLayoutManager);
                holder.rcvItem.setFocusable(false);

                TourFavoriteAdapter tourFavoriteAdapter = new TourFavoriteAdapter();
                tourFavoriteAdapter.setData(listData.getListTourFavorite());
                holder.rcvItem.setAdapter(tourFavoriteAdapter);
            }
        } else if(TYPE_TOUR == holder.getItemViewType()){
            if(holder.rcvItem.getAdapter() == null) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
                holder.rcvItem.setLayoutManager(linearLayoutManager);
                holder.rcvItem.setFocusable(false);

                TourAdapter tourAdapter = new TourAdapter();
                tourAdapter.setData(listData.getListTour());
                holder.rcvItem.setAdapter(tourAdapter);
            }
        } else if(TYPE_TOUR_HEADER == holder.getItemViewType()){
            if(holder.rcvItem.getAdapter() == null){
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
                holder.rcvItem.setLayoutManager(linearLayoutManager);
                holder.rcvItem.setFocusable(false);

                TourHeaderAdapter tourHeaderAdapter = new TourHeaderAdapter();
                tourHeaderAdapter.setData(listData.getListTourHeader());
                holder.rcvItem.setAdapter(tourHeaderAdapter);
            }
        }
    }

    @Override
    public int getItemCount() {
        if(mListData != null){
            return mListData.size();
        }
        return 0;
    }

    public class ListDataViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView rcvItem;

        public ListDataViewHolder(@NonNull View itemView) {
            super(itemView);
            rcvItem = itemView.findViewById(R.id.rcv_item);
        }
    }



}
