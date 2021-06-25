package com.gola.myappstt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity2 extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    TextView bt,bt2,bt3,bt4,bt5,bt6,bt7,bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.add_circl));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.information));

        bnv_Main.show(1,true);
        replace(new homeFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new homeFragment());
                        break;

                    case 2:
                        replace(new Add_grp_Fragment());
                        break;

                    case 3:
                        replace(new info_Fragment());
                        break;
                }

                return null;
            }
        });
        //bottomNavigation = findViewById(R.id.btn_nv);
        //bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        //bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.top));
        /*bt=  findViewById(R.id.entr_btn);
        bt2= findViewById(R.id.quote);
        bt3= findViewById(R.id.chtn);
        bt4= findViewById(R.id.gme);
        bt5= findViewById(R.id.shp);
        bt6= findViewById(R.id.stdy);
        bt7= findViewById(R.id.ofr);
        bt8= findViewById(R.id.nws);
       bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt.getText().toString();
               // tb1.setText(data);
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);


            }});

                bt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String data = bt2.getText().toString();
                        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                        intent.putExtra("dataname", data);
                        startActivity(intent);
                    }
                });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt3.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt4.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt5.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt6.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt7.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = bt8.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("dataname", data);
                startActivity(intent);
            }
        });*/
            }

            private void replace(Fragment fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, fragment);
                transaction.commit();

            }
        }

