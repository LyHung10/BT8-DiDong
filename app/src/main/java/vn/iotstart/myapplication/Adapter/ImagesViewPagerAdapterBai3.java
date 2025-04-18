package vn.iotstart.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.iotstart.myapplication.Model.ImagesSlider;
import vn.iotstart.myapplication.R;

public class ImagesViewPagerAdapterBai3 extends PagerAdapter {
    private Context context;
    private List<ImagesSlider> imagesList;

    public ImagesViewPagerAdapterBai3(Context context, List<ImagesSlider> imagesList) {
        this.context = context;
        this.imagesList = imagesList;
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image_sliderbai3, container, false);
        ImageView imageView = view.findViewById(R.id.image_slider);

        Glide.with(context).load(imagesList.get(position).getAvatar()).into(imageView);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
