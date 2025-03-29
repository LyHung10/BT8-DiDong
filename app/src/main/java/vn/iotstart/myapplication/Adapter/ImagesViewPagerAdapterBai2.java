package vn.iotstart.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

import vn.iotstart.myapplication.Model.Images;
import vn.iotstart.myapplication.R;

public class ImagesViewPagerAdapterBai2 extends PagerAdapter {
    private List<Images> imagesList;

    public ImagesViewPagerAdapterBai2(List<Images> imagesList) {
        this.imagesList = imagesList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_images, container, false);
        ImageView imageView = view.findViewById(R.id.imgView);

        Images images = imagesList.get(position);
        imageView.setImageResource(images.getImagesId()); // Gán hình ảnh từ danh sách

        // Thêm view vào ViewPager
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return (imagesList != null) ? imagesList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
