package com.tutwebhub.gurjas_portfolio.citytourguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by gurjas on 01-07-2017.
 */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

    private OnItemClickListener onItemClickListener;
    private GestureDetector mGestureDetector;

    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
        public void onLongItemClick(View view, int position);
    }

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final OnItemClickListener listener)
    {
        onItemClickListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if(childView != null && onItemClickListener != null)
                {
                    onItemClickListener.onLongItemClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent e) {
        View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && onItemClickListener != null && mGestureDetector.onTouchEvent(e))
        {
            onItemClickListener.onItemClick(childView, recyclerView.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
