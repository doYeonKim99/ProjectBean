package com.example.student.doyeon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Student on 2016-10-29.
 */

public class TouchEventView extends View {
    private int x;
    private int y;
    private String str = "없음";
    BitmapDrawable d;
    Bitmap img,b;

    DisplayMetrics displayMetrics = new DisplayMetrics();

    int width = displayMetrics.widthPixels;// 가로
    int height = displayMetrics.heightPixels;// 세로

    public TouchEventView(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {

          img=BitmapFactory.decodeResource(getResources(), R.drawable.img); //jpg 이미지를 비트맵으로 받아오기

        canvas.drawBitmap(img,x,y,null); //그리기  인자값 각각 비트맵, left, right, paint
        //canvas.drawBitmap(b, x, y, null);
        Paint p = new Paint();
        p.setTextSize(20);
        p.setColor(Color.BLACK);
        canvas.drawText("이벤트좌표 x:" + x + "Y:" + y, 0, 20, p);
        canvas.drawText("이벤트액션 :" + str, 0, 40, p);
    }

    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            str = "Action_Down";
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            str = "Action_Move";
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            str = "Action_up";

            img.recycle();
            img = null;
        }
        invalidate();

    return true;
    }
}
