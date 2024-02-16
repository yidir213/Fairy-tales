package com.example.projecttp.outils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;


public class CustomScrollView extends ScrollView {

    public interface OnScrollEndListener {
        void onScrollEnd();
        void onScrollUp();
    }

    private OnScrollEndListener onScrollEndListener;
    private int previousScrollPosition = 0;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setOnScrollEndListener(OnScrollEndListener listener) {
        onScrollEndListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (!canScrollVertically(1) && t > previousScrollPosition) {
            if (onScrollEndListener != null) {
                onScrollEndListener.onScrollEnd();
            }
        } else{

                onScrollEndListener.onScrollUp();
            }
        }

    }


//else if (t < previousScrollPosition) {
//
//        if (onScrollEndListener != null) {
//        onScrollEndListener.onScrollUp();
//        }
//        }