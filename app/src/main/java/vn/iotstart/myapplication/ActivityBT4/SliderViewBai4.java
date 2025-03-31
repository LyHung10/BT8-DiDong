package vn.iotstart.myapplication.ActivityBT4;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.library.foysaltech.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.library.foysaltech.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import vn.iotstart.myapplication.Adapter.SliderAdapterBai4;
import vn.iotstart.myapplication.R;

public class SliderViewBai4 extends AppCompatActivity {

    private SliderView sliderView;
    private ArrayList<Integer> arrayList;
    private SliderAdapterBai4 sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_view_bai4);

        sliderView = findViewById(R.id.imageSlider);
        arrayList = new ArrayList<>();

        arrayList.add(R.drawable.bg );
        arrayList.add(R.drawable.coffee);
        arrayList.add(R.drawable.companypizza);
        arrayList.add(R.drawable.quangcao);

        sliderAdapter = new SliderAdapterBai4(getApplicationContext(), arrayList);
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.white));
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(3);
    }
}