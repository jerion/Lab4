package com.example.user.lab4_dish;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button selec_b = (Button) findViewById(R.id.selec_b);

        selec_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,Main2Activity.class);
                startActivityForResult(i, 0);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 0){
            if (resultCode == 101){
                Bundle b = data.getExtras();

                String drink = b.getString("drink");
                String sweet = b.getString("sweet");
                String ice = b.getString("ice");

                TextView drink_f = (TextView) findViewById(R.id.drink);
                TextView sweet_f = (TextView) findViewById(R.id.sweet);
                TextView ice_f = (TextView) findViewById(R.id.ice);

                drink_f.setText(drink);
                sweet_f.setText(sweet);
                ice_f.setText(ice);
            }
        }
    }
}
