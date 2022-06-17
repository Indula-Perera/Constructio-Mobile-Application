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

import com.example.wjcontractors.MdeleteAct;
import com.example.wjcontractors.R;
import com.example.wjcontractors.UpdateMasonry;

import java.util.ArrayList;

public class MasonryDeleteCusomAdapter extends RecyclerView.Adapter<MasonryDeleteCusomAdapter.MasonryDeleteHolder> {
    Context context;
    Activity activity;
    ArrayList m_id, m_name, m_address, m_nic, m_age, ms_name;



    public MasonryDeleteCusomAdapter(Activity activity, Context context, ArrayList m_id, ArrayList m_name, ArrayList m_address, ArrayList m_nic, ArrayList m_age, ArrayList ms_name){

        this.activity = activity;
        this.context = context;
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_address = m_address;
        this.m_nic = m_nic;
        this.m_age = m_age;
        this.ms_name = ms_name;

    }
    @NonNull
    @Override
    public MasonryDeleteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.masonry_row,parent, false);
        return new MasonryDeleteCusomAdapter.MasonryDeleteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MasonryDeleteHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.m_id_txt.setText(String.valueOf(m_id.get(position)));
        holder.m_name_txt.setText(String.valueOf(m_name.get(position)));
        holder.m_address_txt.setText(String.valueOf(m_address.get(position)));
        holder.m_nic_txt.setText(String.valueOf(m_nic.get(position)));
        holder.m_age_txt.setText(String.valueOf(m_age.get(position)));
        holder.ms_name_txt.setText(String.valueOf(ms_name.get(position)));
        holder.masonry_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MdeleteAct.class);
                intent.putExtra("id",String.valueOf(m_id.get(position)));
                intent.putExtra("name",String.valueOf(m_name.get(position)));
                intent.putExtra("address",String.valueOf(m_address.get(position)));
                intent.putExtra("nic",String.valueOf(m_nic.get(position)));
                intent.putExtra("age",String.valueOf(m_age.get(position)));
                intent.putExtra("msname",String.valueOf(ms_name.get(position)));
                activity.startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    public int getItemCount() {
        return m_id.size();
    }

    public class MasonryDeleteHolder extends RecyclerView.ViewHolder{
        TextView m_id_txt, m_name_txt, m_nic_txt, m_age_txt, m_address_txt, ms_name_txt;
        LinearLayout masonry_row;
        public MasonryDeleteHolder(@NonNull View itemView) {
            super(itemView);
            m_id_txt = itemView.findViewById(R.id.m_id_txt);
            m_name_txt = itemView.findViewById(R.id.m_name_txt);
            m_address_txt = itemView.findViewById(R.id.m_address_txt);
            m_nic_txt = itemView.findViewById(R.id.m_nic_txt);
            m_age_txt = itemView.findViewById(R.id.m_age_txt);
            ms_name_txt = itemView.findViewById(R.id.ms_name_txt);
            masonry_row = itemView.findViewById(R.id.masonry_row);
        }
    }
}
