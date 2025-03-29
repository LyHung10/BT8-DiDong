package vn.iotstart.myapplication.ActivityBT3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import vn.iotstart.myapplication.R;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ViewFlipperActivityCau1 extends AppCompatActivity {
    ViewFlipper viewFlipperMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        viewFlipperMain = findViewById(R.id.viewFlipperMain);
        ActionViewFlipperMain();
    }

    private void ActionViewFlipperMain() {
        int[] images = {R.drawable.quangcao, R.drawable.coffee, R.drawable.companypizza};
        for (int image : images) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(image);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperMain.addView(imageView);
        }


        viewFlipperMain.setFlipInterval(3000);
        viewFlipperMain.setAutoStart(true);

        // Thiết lập animation cho ViewFlipper
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipperMain.setInAnimation(slide_in);
        viewFlipperMain.setOutAnimation(slide_out);
    }
}
