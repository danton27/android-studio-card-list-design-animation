package com.pens.card_list_ui_design;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout primaryitem;
    Button btn_continue, btn_cancel;
    Animation fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primaryitem = (LinearLayout) findViewById(R.id.primaryitem);
        btn_continue = (Button) findViewById(R.id.btn_continue);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        fade = AnimationUtils.loadAnimation(this, R.anim.fade);

        btn_continue.setAlpha(0);
        btn_cancel.setAlpha(0);

        primaryitem.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                primaryitem.setBackground(getDrawable(R.drawable.bg_item_selected));
                btn_continue.setAlpha(1);
                btn_cancel.setAlpha(1);
                btn_continue.startAnimation(fade);

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                primaryitem.setBackground(getDrawable(R.drawable.bg_item));
                btn_continue.setAlpha(0);
                btn_cancel.setAlpha(0);
            }
        });
    }


}
