package com.example.wjcontractors.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wjcontractors.R;

import java.util.ArrayList;

public class CSiteCustomAdapter extends RecyclerView.Adapter<CSiteCustomAdapter.CSiteMyViewHolder> {

   private Context context;
   private ArrayList c_site_id, c_site_name, c_site_location, c_site_supervisor;

    public CSiteCustomAdapter(Context context, ArrayList c_site_id, ArrayList c_site_name, ArrayList c_site_location, ArrayList c_site_supervisor){
        this.context = context;
        this.c_site_id = c_site_id;
        this.c_site_name = c_site_name;
        this.c_site_location = c_site_location;
        this.c_site_supervisor=c_site_supervisor;

    }
    @NonNull
    @Override
    public CSiteMyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.c_site_row, parent, false);
        return new CSiteMyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CSiteMyViewHolder holder, int position) {

        holder.c_site_id_txt.setText(String.valueOf(c_site_id.get(position)));
        holder.c_site_name_txt.setText(String.valueOf(c_site_name.get(position)));
        holder.c_site_location_txt.setText(String.valueOf(c_site_location.get(position)));
        holder.c_site_supervisor_txt.setText(String.valueOf(c_site_supervisor.get(position)));


    }

    @Override
    public int getItemCount() {
        return c_site_id.size();
    }

    public class CSiteMyViewHolder extends RecyclerView.ViewHolder {

        TextView c_site_id_txt, c_site_name_txt, c_site_location_txt, c_site_supervisor_txt;


        public CSiteMyViewHolder(@NonNull View itemView) {
            super(itemView);
            c_site_id_txt = itemView.findViewById(R.id.m_id_txt);
            c_site_name_txt = itemView.findViewById(R.id.m_name_txt);
            c_site_location_txt = itemView.findViewById(R.id.m_nic_txt);
            c_site_supervisor_txt = itemView.findViewById(R.id.c_site_supervisor_txt);




        }
    }
}
