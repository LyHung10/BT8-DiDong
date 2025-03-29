package vn.iotstart.myapplication.ActivityBT2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinePagerIndicatorDecoration extends RecyclerView.ItemDecoration {
    private final int indicatorHeight = 16;  // Chiều cao của indicator
    private final float indicatorStrokeWidth = 8f;
    private final float indicatorItemLength = 16f;
    private final float indicatorItemPadding = 8f;

    private final Paint paintInactive = new Paint();
    private final Paint paintActive = new Paint();

    public LinePagerIndicatorDecoration(Context context) {
        paintInactive.setStrokeWidth(indicatorStrokeWidth);
        paintInactive.setStyle(Paint.Style.STROKE);
        paintInactive.setColor(0x66FFFFFF); // Màu của indicator không được chọn

        paintActive.setStrokeWidth(indicatorStrokeWidth);
        paintActive.setStyle(Paint.Style.FILL);
        paintActive.setColor(0xFFFFFFFF); // Màu của indicator được chọn
    }

    @Override
    public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int itemCount = parent.getAdapter().getItemCount();
        if (itemCount == 0) return;

        float totalLength = indicatorItemLength * itemCount;
        float paddingBetweenItems = Math.max(0, itemCount - 1) * indicatorItemPadding;
        float indicatorTotalWidth = totalLength + paddingBetweenItems;
        float startX = (parent.getWidth() - indicatorTotalWidth) / 2f;
        float posY = parent.getHeight() - indicatorHeight;

        drawInactiveIndicators(canvas, startX, posY, itemCount);

        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        View activeView = layoutManager.getChildAt(0);
        if (activeView == null) return;

        int activePosition = parent.getChildAdapterPosition(activeView);
        if (activePosition == RecyclerView.NO_POSITION) return;

        drawActiveIndicator(canvas, startX, posY, activePosition);
    }

    private void drawInactiveIndicators(Canvas canvas, float startX, float posY, int itemCount) {
        float itemWidth = indicatorItemLength + indicatorItemPadding;
        float x = startX;

        for (int i = 0; i < itemCount; i++) {
            canvas.drawLine(x, posY, x + indicatorItemLength, posY, paintInactive);
            x += itemWidth;
        }
    }

    private void drawActiveIndicator(Canvas canvas, float startX, float posY, int highlightPosition) {
        float itemWidth = indicatorItemLength + indicatorItemPadding;
        float highlightStart = startX + itemWidth * highlightPosition;
        canvas.drawLine(highlightStart, posY, highlightStart + indicatorItemLength, posY, paintActive);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = indicatorHeight;
    }
}
