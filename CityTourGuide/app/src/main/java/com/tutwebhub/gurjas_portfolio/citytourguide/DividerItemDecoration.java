package com.tutwebhub.gurjas_portfolio.citytourguide;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by gurjas on 01-07-2017.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    // private variables
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    /*
     recycler view update supports both HORIZONTAL as well as VERTICAL
     orientations. for HORIZONTAL value = 0, VERTICAL value = 1
     */
    // horizontal and vertical listing
    private static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    private static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable drawableDivider;

    private int mOrientation;

    public DividerItemDecoration(Context context, int orientation) {
        final TypedArray array = context.obtainStyledAttributes(ATTRS);
        drawableDivider = array.getDrawable(0);
        array.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation)
    {
        if(orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST)
        {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST)
        {
            drawVertical(c, parent);
        }
        else {
            drawHorizontal(c, parent);
        }
    }

    public void drawVertical(Canvas c, RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i<childCount; i++)
        {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + drawableDivider.getIntrinsicHeight();
            drawableDivider.setBounds(left, top, right, bottom);
            drawableDivider.draw(c);
        }
    }

    public void drawHorizontal(Canvas c, RecyclerView parent)
    {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();
        for (int i=0; i<childCount; i++)
        {
            final View childView = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) childView.getLayoutParams();
            final int left = childView.getRight() + params.rightMargin;
            final int right = left + drawableDivider.getIntrinsicHeight();
            drawableDivider.setBounds(left, top, right, bottom);
            drawableDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST)
        {
            outRect.set(0, 0, 0, drawableDivider.getIntrinsicHeight());
        }
        else
            outRect.set(0, 0, drawableDivider.getIntrinsicWidth(), 0);
    }
}
