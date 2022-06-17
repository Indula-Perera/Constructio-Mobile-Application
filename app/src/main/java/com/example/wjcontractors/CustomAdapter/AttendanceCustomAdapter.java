package com.example.wjcontractors.CustomAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wjcontractors.MarkAttendance;
import com.example.wjcontractors.R;
import com.example.wjcontractors.UpdateMasonry;

import java.util.ArrayList;

public class AttendanceCustomAdapter extends RecyclerView.Adapter<AttendanceCustomAdapter.MasonryViewHolder>{
    Context context;
    Activity activity;
    ArrayList m_id, m_name;



    public AttendanceCustomAdapter(Activity activity, Context context, ArrayList m_id, ArrayList m_name){

        this.activity = activity;
        this.context = context;
        this.m_id = m_id;
        this.m_name = m_name;


    }
    @NonNull
    @Override
    public MasonryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.att_row,parent, false);
        return new AttendanceCustomAdapter.MasonryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MasonryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.m_id_txt.setText(String.valueOf(m_id.get(position)));
        holder.m_name_txt.setText(String.valueOf(m_name.get(position)));
        holder.masonry_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MarkAttendance.class);
                intent.putExtra("id",String.valueOf(m_id.get(position)));
                intent.putExtra("name",String.valueOf(m_name.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    public int getItemCount() {
        return m_id.size();
    }

    public class MasonryViewHolder extends RecyclerView.ViewHolder{
        TextView m_id_txt, m_name_txt;
        LinearLayout masonry_row;
        public MasonryViewHolder(@NonNull View itemView) {
            super(itemView);
            m_id_txt = itemView.findViewById(R.id.m_id_txt);
            m_name_txt = itemView.findViewById(R.id.m_name_txt);
            masonry_row = itemView.findViewById(R.id.masonry_row);
        }
    }
}
