package com.example.tourdulich.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourdulich.AllTourActivity;
import com.example.tourdulich.AllTourFavoriteActivity;
import com.example.tourdulich.BookedTourActivity;
import com.example.tourdulich.R;
import com.example.tourdulich.SearchTourActivity;
import com.example.tourdulich.UpdateInfoActivity;
import com.example.tourdulich.model.ListData;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ListDataViewHolder>{

    public static final int TYPE_TOURFAVORITE = 1;
    public static final int TYPE_TOUR = 2;
    public static final int TYPE_TOUR_HEADER = 3;
    public static final int TYPE_TV_SEARCH = 4;
    public static final int TYPE_TV_TOURFAVORITE = 5;
    public static final int TYPE_TV_TOUR = 6;
    public static final int TYPE_CV_INFO = 7;
    public static final int TYPE_CV_IMAGE = 8;
    public static final int TYPE_CV_TVUPDATEINFO = 9;
    public static final int TYPE_CV_TVBOOKING = 10;
    public static final int TYPE_TOUR_BOOKING = 11;

    private List<ListData> mListData;
    private Context mContext;
    private View view;

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
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_data, parent, false);
//        return new ListDataViewHolder(view);
        if (viewType == TYPE_TV_SEARCH) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edt_search, parent, false);
            TextView tv_searchTour = view.findViewById(R.id.tv_searchTour);
            tv_searchTour.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, SearchTourActivity.class);
                mContext.startActivity(intent);
            });
        } else if (viewType == TYPE_TV_TOUR) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv, parent, false);
            TextView tv_title = view.findViewById(R.id.tv_title);
            TextView tv_allTour = view.findViewById(R.id.tv_allTour);
            tv_title.setText("Tuor khởi hành tại Phú Yên");
            tv_allTour.setPaintFlags(tv_allTour.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            tv_allTour.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, AllTourActivity.class);
                mContext.startActivity(intent);
            });
        }else if (viewType == TYPE_TV_TOURFAVORITE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv, parent, false);
            TextView tv_title = view.findViewById(R.id.tv_title);
            TextView tv_allTour = view.findViewById(R.id.tv_allTour);
            tv_title.setText("Tuor được ưa chuộng");
            tv_allTour.setPaintFlags(tv_allTour.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

            tv_allTour.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, AllTourFavoriteActivity.class);
                mContext.startActivity(intent);
            });
        } else if (viewType == TYPE_CV_TVUPDATEINFO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv_tv, parent, false);
            TextView tv_itemProfile = view.findViewById(R.id.tv_itemProfile);
            ImageView img_next = view.findViewById(R.id.img_next);
            tv_itemProfile.setText("Thay đổi thông tin");

            img_next.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, UpdateInfoActivity.class);
                mContext.startActivity(intent);
            });
        } else if (viewType == TYPE_CV_TVBOOKING) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv_tv, parent, false);
            TextView tv_itemProfile = view.findViewById(R.id.tv_itemProfile);
            ImageView img_next = view.findViewById(R.id.img_next);
            tv_itemProfile.setText("Booking");

            img_next.setOnClickListener(v -> {
                Intent intent = new Intent(mContext, BookedTourActivity.class);
                mContext.startActivity(intent);
            });
        } else if (viewType == TYPE_CV_INFO) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv_information, parent, false);
            Button btn_bookTour = view.findViewById(R.id.btn_bookTour);

            btn_bookTour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mContext, R.style.RoundedBottomSheetDialog);
                    bottomSheetDialog.setContentView(R.layout.dialog_booking);
                    bottomSheetDialog.show();
                }
            });
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_data, parent, false);
        }
        return new ListDataViewHolder(view);
    }

    // Hàm phân biệt khi nào xử dụng type nào
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

                TourFavoriteAdapter tourFavoriteAdapter = new TourFavoriteAdapter(mContext);
                tourFavoriteAdapter.setData(listData.getListTour());
                holder.rcvItem.setAdapter(tourFavoriteAdapter);

            }
        } else if(TYPE_TOUR == holder.getItemViewType()) {
            if (holder.rcvItem.getAdapter() == null) {
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

                TourImageAdapter tourHeaderAdapter = new TourImageAdapter();
                tourHeaderAdapter.setData(listData.getListTour());
                holder.rcvItem.setAdapter(tourHeaderAdapter);

                // Thiết lập auto scroll cho TYPE_TOUR_HEADER
                final Handler handler = new Handler(Looper.getMainLooper());
                final int delay = 2000; // Chuyển sang item tiếp theo mỗi 3 giây
                final Runnable runnable = new Runnable() {
                    int currentPosition = 0;

                    @Override
                    public void run() {
                        if (currentPosition >= tourHeaderAdapter.getItemCount()) {
                            currentPosition = 0;
                        }
                        holder.rcvItem.smoothScrollToPosition(currentPosition++);
                        handler.postDelayed(this, delay);
                    }
                };
                handler.postDelayed(runnable, delay);
            }
        } else if(TYPE_CV_IMAGE == holder.getItemViewType()){
            if(holder.rcvItem.getAdapter() == null){
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
                holder.rcvItem.setLayoutManager(linearLayoutManager);
                holder.rcvItem.setFocusable(false);

                TourDetailImageAdapter tourDetailImageAdapter = new TourDetailImageAdapter();
                tourDetailImageAdapter.setData(listData.getListTour());
                holder.rcvItem.setAdapter(tourDetailImageAdapter);
            }
        } else if(TYPE_TOUR_BOOKING == holder.getItemViewType()){
            if(holder.rcvItem.getAdapter() == null){
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
                holder.rcvItem.setLayoutManager(linearLayoutManager);
                holder.rcvItem.setFocusable(false);

                TourBookingAdapter tourBookingAdapter = new TourBookingAdapter();
                tourBookingAdapter.setData(listData.getListTour());
                holder.rcvItem.setAdapter(tourBookingAdapter);
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
