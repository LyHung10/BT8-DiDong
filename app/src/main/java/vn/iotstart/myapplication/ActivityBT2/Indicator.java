package vn.iotstart.myapplication.ActivityBT2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iotstart.myapplication.Adapter.IconAdapter;
import vn.iotstart.myapplication.Model.IconModel;
import vn.iotstart.myapplication.R;

public class Indicator extends AppCompatActivity {
    private RecyclerView rcIcon;
    private List<IconModel> arrayList;
    private IconAdapter iconAdapter;
    private SearchView searchView;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_indicator);

            rcIcon = findViewById(R.id.rcIcon);
            searchView = findViewById(R.id.searchView);
            searchView.clearFocus();

            // Thêm dữ liệu vào danh sách
            arrayList = new ArrayList<>();
            arrayList.add(new IconModel(R.drawable.baseline_broken_image_24, "Icon 1"));
            arrayList.add(new IconModel(R.drawable.baseline_call_24, "Icon 2"));
            arrayList.add(new IconModel(R.drawable.baseline_camera_enhance_24, "Icon 3"));
            arrayList.add(new IconModel(R.drawable.baseline_call_24, "Icon 4"));
            arrayList.add(new IconModel(R.drawable.ic_launcher_background, "Icon 5"));
            arrayList.add(new IconModel(R.drawable.baseline_broken_image_24, "Icon 6"));
            arrayList.add(new IconModel(R.drawable.baseline_broken_image_24, "Icon 1"));
            arrayList.add(new IconModel(R.drawable.baseline_call_24, "Icon 2"));
            arrayList.add(new IconModel(R.drawable.baseline_camera_enhance_24, "Icon 3"));
            arrayList.add(new IconModel(R.drawable.baseline_call_24, "Icon 4"));
            arrayList.add(new IconModel(R.drawable.ic_launcher_background, "Icon 5"));
            arrayList.add(new IconModel(R.drawable.baseline_broken_image_24, "Icon 6"));
            arrayList.add(new IconModel(R.drawable.baseline_broken_image_24, "Icon 1"));
            arrayList.add(new IconModel(R.drawable.baseline_call_24, "Icon 2"));
            arrayList.add(new IconModel(R.drawable.baseline_camera_enhance_24, "Icon 3"));
            arrayList.add(new IconModel(R.drawable.baseline_call_24, "Icon 4"));
            arrayList.add(new IconModel(R.drawable.ic_launcher_background, "Icon 5"));
            arrayList.add(new IconModel(R.drawable.baseline_broken_image_24, "Icon 6"));

            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 10, GridLayoutManager.HORIZONTAL, false);
            rcIcon.setLayoutManager(gridLayoutManager);

            iconAdapter = new IconAdapter(this, arrayList);
            rcIcon.setAdapter(iconAdapter);

            rcIcon.addItemDecoration(new LinePagerIndicatorDecoration(this));
        // Xử lý tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterListener(newText);
                return true;
            }
        });
    }
    private void filterListener(String text) {
        List<IconModel> list = new ArrayList<>();
        for (IconModel iconModel : arrayList) {
            if (iconModel.getDesc().toLowerCase().contains(text.toLowerCase())) {
                list.add(iconModel);
            }
        }
        if (list.isEmpty()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        } else {
            iconAdapter.setListener(list);
        }
    }
    }