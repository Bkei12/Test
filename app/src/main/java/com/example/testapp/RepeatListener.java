package com.example.testapp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;


class RepeatListener implements OnTouchListener {

    private Handler handler = new Handler();
    private View downView;
    private int initialInterval;
    private int normalInterval;
    private OnClickListener clickListener;
    private Runnable handlerRunnable;


    public RepeatListener(int initialInterval, int normalInterval, OnClickListener clickListener) {
        if (clickListener == null) {
            throw new IllegalArgumentException("null runnable");
        }

        if (initialInterval < 0 || normalInterval < 0) {
            throw new IllegalArgumentException("negative interval");
        }

        this.initialInterval = initialInterval;
        this.normalInterval = normalInterval;
        this.clickListener = clickListener;

        this.handlerRunnable = () -> {
            this.handler.postDelayed(this.handlerRunnable, this.normalInterval);
            this.clickListener.onClick(this.downView);
        };
    }

    public RepeatListener(int normalInterval, OnClickListener clickListener) {
        this.normalInterval = normalInterval;
        this.clickListener = clickListener;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                handler.removeCallbacks(handlerRunnable);
                handler.postDelayed(handlerRunnable, initialInterval);
                downView = view;
                downView.setPressed(true);
                clickListener.onClick(view);
                return true;
            }

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                handler.removeCallbacks(handlerRunnable);
                downView.setPressed(false);
                downView = null;
                return true;
            }
        }

        return false;
    }
}