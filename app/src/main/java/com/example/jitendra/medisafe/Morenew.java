package com.example.jitendra.medisafe;

import android.content.Context;
import android.graphics.Movie;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jitendra.medisafe.Tab_Navi_Fragment.More;

import java.util.ArrayList;
import java.util.List;


public class Morenew extends Fragment {
    RecyclerView recyclerView;
    private List<MoreData> moreData = new ArrayList<>();
    MoreAdapter moreAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_morenew, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.morerecycler);

        moreAdapter = new MoreAdapter(moreData);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moreAdapter);

        moredata();


        return view;
    }
    private void moredata() {
        MoreData more = new MoreData("jitu");
        moreData.add(more);

       MoreData dataa=new MoreData("lsr");
       moreData.add(dataa);



        moreAdapter.notifyDataSetChanged();
    }
    public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.MyViewHolder> {

        private List<MoreData> moreData;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView name;
            ImageView imageView;

            public MyViewHolder(View view) {
                super(view);
                name = (TextView) view.findViewById(R.id.morelisttext);
                imageView=(ImageView)view.findViewById(R.id.morelistimage);
            }
        }


        public MoreAdapter(List<MoreData> moreData) {
            this.moreData = moreData;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.morelistdesign, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MoreData movie = moreData.get(position);
            holder.name.setText(movie.getTitle());
            holder.imageView.setImageResource(movie.getImage());
        }

        @Override
        public int getItemCount() {
            return moreData.size();
            
            //gitlab Comment 
        }
    }
    }
