package com.gola.myappstt;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<model> datalist;

    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.name.setText(datalist.get(position).getName());
        holder.desc.setText(datalist.get(position).getEmail());
        holder.det.setText(datalist.get(position).getDetl());
        //Glide.with(load.img.getContext()).load(model.getPurl()).into(holder.img);
        Glide.with(holder.img.getContext()).load(datalist.get(position).getPurl()).into(holder.img);
        //Glide.with( mContext).load(datalist.get(position).getPurl()).into(holder.img);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(datalist.get(position).getEmail())));

               holder.desc.getContext().startActivity(intent);
            }});
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(datalist.get(position).getEmail())));

                    holder.desc.getContext().startActivity(intent);
                }
        });











        /*holder.desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent=new Intent(holder.desc.go)
                gotoUrl("https://chat.whatsapp.com/invite/4PJkNq3vDyp1jbsjBIG7Di");
                //("https://chat.whatsapp.com/invite/4PJkNq3vDyp1jbsjBIG7Di");
         intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));*/
    }



    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
          TextView name,desc,det;
          ImageView img;

          public myviewholder(@NonNull View itemView){
              super(itemView);
              name=itemView.findViewById(R.id.name);
              desc=itemView.findViewById(R.id.desc);
              det=itemView.findViewById(R.id.det);
              img=itemView.findViewById(R.id.img);


          }
    }

}
