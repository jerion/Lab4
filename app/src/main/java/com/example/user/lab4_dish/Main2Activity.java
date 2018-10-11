package com.example.user.lab4_dish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {

    String sugu = "NULL";
    String icic = "NULL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        EditText drink_t = (EditText) findViewById(R.id.drink_t);
        RadioGroup sug = (RadioGroup) findViewById(R.id.sug);
        RadioGroup iceg = (RadioGroup) findViewById(R.id.iceg);
        Button seet = (Button)findViewById(R.id.seet);

        sug.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.n_sug:
                        sugu = "無糖";
                        break;
                    case R.id.s_sug:
                        sugu = "微糖";
                        break;
                    case R.id.h_sug:
                        sugu = "半糖";
                        break;
                    case R.id.l_sug:
                        sugu = "少糖";
                        break;
                    case R.id.f_sug:
                        sugu = "全糖";
                        break;
                }
            }
        });

        iceg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.s_ice:
                        icic = "微冰";
                        break;
                    case R.id.h_ice:
                        icic = "少冰";
                        break;
                    case R.id.f_ice:
                        icic = "正常冰";
                        break;
                }
            }
        });

        seet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drink_t = (EditText)findViewById(R.id.drink_t);
                String temp = drink.getText().toString();

                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("s_l",sugu);
                b.putString("d_l",drink_t);
                b.putString("i_l",iceg);
                i.putExtras(b);
                setResult(0,i);
                finish();
            }
        });
    }
}
