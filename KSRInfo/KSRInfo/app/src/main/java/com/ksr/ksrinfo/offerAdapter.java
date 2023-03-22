package com.ksr.ksrinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class offerAdapter extends FirebaseRecyclerAdapter<offerlist,offerAdapter.myviewholder>
{
    public offerAdapter(@NonNull FirebaseRecyclerOptions<offerlist> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull offerlist model)
    {
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.phone.setText(model.getPhone());
        Glide.with(holder.img.getContext()).load(model.getPhoto()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.offeritem,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name,address,phone;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img1);
            name=(TextView)itemView.findViewById(R.id.nametext);
            address=(TextView)itemView.findViewById(R.id.coursetext);
            phone=(TextView)itemView.findViewById(R.id.emailtext);
        }
    }
}
