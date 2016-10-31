package com.example.student.doyeon;
import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout rl = new RelativeLayout(this);
        final ImageView image;
        // RelativeLayout width, height 설정
        for (int i = 0; i <= 5; i++) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT,
                     ViewGroup.LayoutParams.MATCH_PARENT);

            // RelativeLayout에 width, height 설정 적용
            rl.setLayoutParams(params);
            image = new ImageView(this);
            image.setId(i);
            image.setImageResource(R.drawable.hi);
        }
        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                image.setImageResource(0);
            }
        });
        // RelativeLayout에 차일드 View 추가
        rl.addView(image);
        // Acitivty화면에 보일 View를 연결해 준다.
        setContentView(rl);
    }
}