package vn.iotstart.myapplication.ActivityBT3;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import vn.iotstart.myapplication.Adapter.ImagesViewPagerAdapterBai2;
import vn.iotstart.myapplication.Model.Images;
import vn.iotstart.myapplication.R;

public class CircleIndicatorActivityCau2 extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private List<Images> imagesList;
    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_indicatorbai2);

        // Ánh xạ View
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        // Lấy danh sách ảnh
        imagesList = getListImages();
        ImagesViewPagerAdapterBai2 adapter = new ImagesViewPagerAdapterBai2(imagesList);
        viewPager.setAdapter(adapter);

        // Liên kết ViewPager với Indicator
        circleIndicator.setViewPager(viewPager);

        // Auto-run slider
        runnable = new Runnable() {
            @Override
            public void run() {
                int nextSlide = viewPager.getCurrentItem() + 1;
                if (nextSlide >= imagesList.size()) {
                    nextSlide = 0;
                }
                viewPager.setCurrentItem(nextSlide, true);
                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        // Lắng nghe sự kiện khi chuyển trang
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
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

    private List<Images> getListImages() {
        List<Images> list = new ArrayList<>();
        list.add(new Images(R.drawable.quangcao));
        list.add(new Images(R.drawable.coffee));
        list.add(new Images(R.drawable.companypizza));
        list.add(new Images(R.drawable.themoingon));
        return list;
    }
}
