package com.gola.myappstt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recview;
    //TextView tb;
    myadapter adapter;
     ArrayList<model> datalist;
     String data;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // tb=findViewById(R.id.tbb);
        Intent intent=getIntent();
        data=intent.getStringExtra("dataname");

        //tb.setText(" "+data);


        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        datalist=new ArrayList<>();
          adapter=new myadapter(datalist);
          recview.setAdapter(adapter);


        /*Intent intent=getIntent();
        data=intent.getStringExtra("dataname");*/

        db=FirebaseFirestore.getInstance();

        db.collection(data).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();

                for (DocumentSnapshot d:list)
                {
                  model obj=d.toObject(model.class);
                  datalist.add(obj);
                }
                adapter.notifyDataSetChanged();
            }

        });


    }
}