package com.example.testplaceholder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout includeItem1 , includeItem2;
    Placeholder placeholder;
    ConstraintLayout constraintLayout;
    private Boolean check = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        includeItem1 = findViewById(R.id.include_item_1);
        includeItem2 = findViewById(R.id.include_item_2);
        placeholder = findViewById(R.id.place_holder);
        constraintLayout = findViewById(R.id.constraint_layout);

        includeItem1.setVisibility(View.INVISIBLE);
        includeItem2.setVisibility(View.INVISIBLE);

        findViewById(R.id.bt_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(constraintLayout);
                if(check==false){
                    placeholder.setContentId(R.id.include_item_1);
                    Log.e("abc",check.toString());

                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_anim);
                    includeItem1.startAnimation(animation);

                    Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_anim1);
                    includeItem2.startAnimation(animation1);

                    check = true;

                }else{
                    placeholder.setContentId(R.id.include_item_2);
                    Log.e("abc",check.toString());;

                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_anim);
                    includeItem2.startAnimation(animation);

                    Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_anim1);
                    includeItem1.startAnimation(animation1);

                    check = false;

                }
            }
        });
    }
}