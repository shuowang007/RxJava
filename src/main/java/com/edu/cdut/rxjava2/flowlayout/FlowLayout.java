package com.edu.cdut.rxjava2.flowlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {

    private static final String TAG = "FlowLayout";
    private int mH = 16;
    private int mW = 16;


    /**
     * new FlowLayout
     * @param context
     */
    public FlowLayout(Context context) {
        super(context);
    }

    /**
     * 自定义layout--xml
     * @param context
     * @param attrs
     */
    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 自定义主题
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        List<View> listView = new ArrayList();
        int lineWidthUsed = 0;
        int lineHeight = 0;
        //度量孩子
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            LayoutParams childP = childView.getLayoutParams();
            int childWidthMeasureSpac = getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), childP.width);
            int childHeightMeasureSpac = getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), childP.height);

            childView.measure(childWidthMeasureSpac, childHeightMeasureSpac);

            int childMeasureWidth = childView.getMeasuredWidth();
            int childMeasureHeight = childView.getMeasuredHeight();

            listView.add(childView);
            lineWidthUsed = lineWidthUsed + childMeasureWidth + mH;
            lineHeight = Math.max(lineHeight, childMeasureHeight);
        }
        //度量自己

    }

    /**
     * 必须实现 onLayout
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
