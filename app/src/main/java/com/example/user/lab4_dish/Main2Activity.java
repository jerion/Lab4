package com.example.user.lab4_dish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    String drink_id;
    String sweet;
    String ice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText drink_n = (EditText) findViewById(R.id.drink_n);
        RadioGroup sweet_g = (RadioGroup) findViewById(R.id.sweet_g);
        RadioGroup ice_g = (RadioGroup) findViewById(R.id.ice_g);
        Button finish_b = (Button) findViewById(R.id.finish_b);

        sweet_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.sweet_0:
                        sweet = "無糖";
                        break;
                    case  R.id.sweet_1:
                        sweet = "半糖";
                        break;
                    case R.id.sweet_2:
                        sweet = "少糖";
                        break;
                    case R.id.sweet_3:
                        sweet = "全糖";
                        break;
                }
            }
        });

        ice_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ice_0:
                        ice = "去冰";
                        break;
                    case R.id.ice_1:
                        ice = "少冰";
                        break;
                    case R.id.ice_2:
                        ice = "正常冰";
                        break;
                }
            }
        });

        finish_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink_id = drink_n.getText().toString();

                Intent i = new Intent();
                Bundle b = new Bundle();

                b.putString("drink", drink_id);
                b.putString("sweet", sweet);
                b.putString("ice", ice);

                i.putExtras(b);
                setResult(101, i);
                finish();
            }
        });
    }
}
