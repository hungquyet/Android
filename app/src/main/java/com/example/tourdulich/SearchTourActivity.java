package com.example.tourdulich;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SearchTourActivity extends AppCompatActivity {
    private ImageView img_exit;
    private EditText edt_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Drawable searchIcon = getResources().getDrawable(R.drawable.search);
        Drawable clearIcon = getResources().getDrawable(R.drawable.clear);

        img_exit = findViewById(R.id.img_exit);
        edt_search = findViewById(R.id.edt_search);

        img_exit.setOnClickListener(view -> finish());

        // Đặt kích thước cho các icon (ví dụ: 24x24dp)
        int iconSize = (int) getResources().getDimension(R.dimen.icon_size);
        searchIcon.setBounds(0, 0, iconSize, iconSize);
        clearIcon.setBounds(0, 0, iconSize, iconSize);

        // Đặt icon mặc định là searchIcon ở bên phải khi chưa có focus
        edt_search.setCompoundDrawables(null, null, searchIcon, null);

        // Sử dụng OnFocusChangeListener và TextWatcher để thay đổi icon
        edt_search.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                edt_search.setCompoundDrawables(null, null, clearIcon, null);
            } else {
                if (edt_search.getText().toString().isEmpty()) {
                    edt_search.setCompoundDrawables(null, null, searchIcon, null);
                }
            }
        });

        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()) {
                    edt_search.setCompoundDrawables(null, null, searchIcon, null);
                } else {
                    edt_search.setCompoundDrawables(null, null, clearIcon, null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        // Xử lý sự kiện khi nhấn vào icon clear để xóa nội dung
        edt_search.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                Drawable clearIconDrawable = edt_search.getCompoundDrawables()[2];
                if (clearIconDrawable != null && event.getRawX() >= (edt_search.getRight() - clearIconDrawable.getBounds().width() - edt_search.getPaddingEnd())) {
                    edt_search.getText().clear();
                    return true;
                }
            }
            return false;
        });
    }
}
