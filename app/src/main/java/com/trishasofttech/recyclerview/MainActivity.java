package com.trishasofttech.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*declare recyclerview*/
    RecyclerView recyclerView;
    /*to attach the data into arraylist*/
    List<Data> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*typecast or intialize the recyclerview from xml*/
        recyclerView = findViewById(R.id.recyclerview);
        /*to fixed the recyclerview item size*/
        recyclerView.setHasFixedSize(true);
        /*to make linear design e.g youtube*/
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        /*to make the grid design e.g gallery*/
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        MyAdapter myAdapter = new MyAdapter();
        /*to attach the adapter with recyclerview*/
        recyclerView.setAdapter(myAdapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<MeraHolder> {

        public MyAdapter()

        {
            list.add(new Data(R.mipmap.ic_launcher, "Rachit"));
            list.add(new Data(R.mipmap.ic_launcher, "Keshav"));
            list.add(new Data(R.mipmap.ic_launcher, "Viru sir"));
            list.add(new Data(R.mipmap.ic_launcher, "Pawan"));
            list.add(new Data(R.mipmap.ic_launcher, "Rawam"));
            list.add(new Data(R.mipmap.ic_launcher, "chaman"));
            list.add(new Data(R.mipmap.ic_launcher, "naman"));
            list.add(new Data(R.mipmap.ic_launcher, "daman"));
            list.add(new Data(R.mipmap.ic_launcher, "hasan"));
            list.add(new Data(R.mipmap.ic_launcher, "tasan"));
            list.add(new Data(R.mipmap.ic_launcher, "kasan"));

        }
        @NonNull
        @Override
        public MeraHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            MeraHolder meraHolder = new MeraHolder(v);
            return meraHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MeraHolder holder, int position) {
            /*to display the data into recyclerview item*/
            Data data = list.get(position);
            /*to attach the data into holder*/
            holder.tv.setText(data.getName());
            holder.iv.setImageResource(data.getImage());
        }

        @Override
        public int getItemCount() {
            /*to retrun the data size*/
            return list.size();
        }
    }

    /*declare and intizalize the design xml widgets*/
    private class MeraHolder extends RecyclerView.ViewHolder{
        /*declare item xml widgets here*/
        TextView tv;
        ImageView iv;
        public MeraHolder(@NonNull View pawan) {
            super(pawan);
            tv = pawan.findViewById(R.id.tv);
            iv = pawan.findViewById(R.id.iv);
        }
    }
}