package com.example.myapplication;

import android.os.Bundle;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBar);

        VolumControlView view = (VolumControlView) findViewById(R.id.volume);
        view.setKnobListener(new VolumControlView.KnobListener(){
            @Override
            public void onChanged(double angle){
                float rating = ratingbar.getRating();
                if (angle > 0 && rating < 7.0)
                    //오른쪽으로 회전
                    ratingbar.setRating(rating+1.0f);
                else if (rating > 0.0)
                    //왼쪽으로 회전
                    ratingbar.setRating(rating-1.0f);
            }
        });
    }
}