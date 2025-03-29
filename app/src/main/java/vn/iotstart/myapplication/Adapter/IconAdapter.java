package vn.iotstart.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

import vn.iotstart.myapplication.Model.IconModel;
import vn.iotstart.myapplication.R;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconViewHolder> {
    private Context context;
    private List<IconModel> iconList;

    public IconAdapter(Context context, List<IconModel> iconList) {
        this.context = context;
        this.iconList = iconList;
    }

    @NonNull
    @Override
    public IconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_icon_promotion, parent, false);
        return new IconViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconViewHolder holder, int position) {
        IconModel iconModel = iconList.get(position);
        holder.imageView.setImageResource(iconModel.getImgId());
        holder.textView.setText(iconModel.getDesc()); // Gán tên hình
    }

    @Override
    public int getItemCount() {
        return iconList.size();
    }

    public static class IconViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public IconViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImgIcon);
            textView = itemView.findViewById(R.id.tvIcon);
        }
    }
    public void setListener(List<IconModel> filteredList) {
        this.iconList = filteredList;
        notifyDataSetChanged(); // Cập nhật RecyclerView
    }

}
