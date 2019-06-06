package com.example.jitendra.medisafe.Tab_Navi_Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jitendra.medisafe.MoreActivitys.AddDiary;
import com.example.jitendra.medisafe.MoreActivitys.Appoinments;
import com.example.jitendra.medisafe.MoreActivitys.Diary;
import com.example.jitendra.medisafe.R;
import com.example.jitendra.medisafe.MoreActivitys.Measurment;


public class More extends Fragment {
    ListView morelist;
    int[] name={R.string.measurement,R.string.diary,R.string.refills,R.string.appointment,
            R.string.doctor,R.string.report,R.string.settings,R.string.help,};
    int image[]={R.drawable.heart,R.drawable.diary,R.drawable.refills,R.drawable.appo,
            R.drawable.doctor,R.drawable.report,R.drawable.settings,R.drawable.help,};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_more, container, false);

        morelist=(ListView)view.findViewById(R.id.morelist);
        CustomMoreAdapter customMoreAdapter=new CustomMoreAdapter();
        morelist.setAdapter(customMoreAdapter);

        morelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent intent=new Intent(getContext(),Measurment.class);
                    startActivity(intent);
                }
                else if (position==1)
                {
                    Intent intent=new Intent(getContext(), Diary.class);
                    startActivity(intent);
                }

                else if (position==3)
                {
                    Intent intent=new Intent(getContext(), Appoinments.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    class  CustomMoreAdapter extends BaseAdapter
    {

        @Override
        public int getCount() {
            return image.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            View mview=getLayoutInflater().inflate(R.layout.morelistdesign,null);
            ImageView imageView=(ImageView)mview.findViewById(R.id.morelistimage);
            TextView textView=(TextView)mview.findViewById(R.id.morelisttext);
            LinearLayout linearLayout=(LinearLayout)mview.findViewById(R.id.liner1);
            imageView.setImageResource(image[i]);
            textView.setText(name[i]);

            /*linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (i==0)
                    {
                        Intent intent=new Intent(getContext(),Measurment.class);
                        startActivity(intent);
                    }
                    if (i==1)
                    {
                        Intent intent=new Intent(getContext(), AddDiary.class);
                        startActivity(intent);
                    }


                }
            });*/

            return mview;
        }
    }
}
