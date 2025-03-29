package vn.iotstart.myapplication.ActivityBT3;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.iotstart.myapplication.Adapter.ImagesViewPagerAdapterBai3;
import vn.iotstart.myapplication.Model.ImagesSlider;
import vn.iotstart.myapplication.Model.MessageModel;
import vn.iotstart.myapplication.R;
import vn.iotstart.myapplication.Retrofit.ApiClient;
import vn.iotstart.myapplication.Retrofit.ApiService;

public class CircleIndicatorActivityBai3 extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private ImagesViewPagerAdapterBai3 adapter;
    private List<ImagesSlider> imagesList = new ArrayList<>();
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicatorbai2);

        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        adapter = new ImagesViewPagerAdapterBai3(this, imagesList);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);

        // Gọi API để lấy danh sách ảnh
        fetchImagesFromAPI();

        // Auto slide ảnh
        runnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem == imagesList.size() - 1) {
                    viewPager.setCurrentItem(0);
                } else {
                    viewPager.setCurrentItem(currentItem + 1);
                }
                handler.postDelayed(this, 3000);
            }
        };
    }

    private void fetchImagesFromAPI() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        apiService.LoadImageSlider(1).enqueue(new Callback<MessageModel>() {
            @Override
            public void onResponse(Call<MessageModel> call, Response<MessageModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().isSuccess()) {
                        imagesList.clear();
                        imagesList.addAll(response.body().getResult());
                        adapter.notifyDataSetChanged();
                        handler.postDelayed(runnable, 3000);
                    } else {
                        Toast.makeText(CircleIndicatorActivityBai3.this, "Không có dữ liệu!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MessageModel> call, Throwable t) {
                Log.e("API_ERROR", t.getMessage());
                Toast.makeText(CircleIndicatorActivityBai3.this, "Lỗi kết nối API!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }
}

