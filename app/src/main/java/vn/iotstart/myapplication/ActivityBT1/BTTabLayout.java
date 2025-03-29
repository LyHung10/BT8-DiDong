package vn.iotstart.myapplication.ActivityBT1;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import vn.iotstart.myapplication.Adapter.ViewPager2Adapter;
import vn.iotstart.myapplication.R;
import vn.iotstart.myapplication.databinding.ActivityTabLayoutBinding;

public class BTTabLayout extends AppCompatActivity {
    private ActivityTabLayoutBinding binding;
    private ViewPager2Adapter viewPager2Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập Toolbar
        setSupportActionBar(binding.toolBar);

        // Khởi tạo Adapter cho ViewPager2
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager2Adapter = new ViewPager2Adapter(fragmentManager, getLifecycle());
        binding.viewPager2.setAdapter(viewPager2Adapter);

        // Liên kết TabLayout và ViewPager2 bằng TabLayoutMediator
        new TabLayoutMediator(binding.tabLayout, binding.viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Xác nhận");
                            break;
                        case 1:
                            tab.setText("Lấy hàng");
                            break;
                        case 2:
                            tab.setText("Đang giao");
                            break;
                        case 3:
                            tab.setText("Đánh giá");
                            break;
                        case 4:
                            tab.setText("Hủy");
                            break;
                    }
                }).attach();
    }

    // Hàm thay đổi icon của FloatingActionButton khi đổi Tab
    private void changeFabIcon(final int index) {
        if (binding.fabAction != null) {
            binding.fabAction.hide();
            new Handler().postDelayed(() -> {
                switch (index) {
                    case 0:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.baseline_chat_24));
                        break;
                    case 1:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.baseline_camera_enhance_24));
                        break;
                    case 2:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.baseline_call_24));
                        break;
                }
                binding.fabAction.show();
            }, 500); // Giảm delay để phản hồi nhanh hơn
        }
    }

    // Xử lý menu trong Toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu) {
            Toast.makeText(this, "Bạn đang chọn search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuGroup) {
            Toast.makeText(this, "Bạn đang chọn New group", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuBroadcast) {
            Toast.makeText(this, "Bạn đang chọn New Broadcast", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuMessage) {
            Toast.makeText(this, "Bạn đang chọn Started Messages", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuSetting) {
            Toast.makeText(this, "Bạn đang chọn Setting", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
