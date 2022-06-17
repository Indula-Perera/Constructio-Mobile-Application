package com.example.wjcontractors.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wjcontractors.R;

import java.util.ArrayList;

public class SupervisorViewCustomAdaptor extends RecyclerView.Adapter<SupervisorViewCustomAdaptor.SupervisorViewHolder>{
    private Context context;
    Activity activity;
    private ArrayList supervisor_id, supervisor_name, supervisor_email, supervisor_password, supervisor_c_password;

    public SupervisorViewCustomAdaptor(Activity activity, Context context, ArrayList supervisor_id, ArrayList supervisor_name, ArrayList supervisor_email, ArrayList supervisor_password, ArrayList supervisor_c_password){

        this.activity = activity;
        this.context = context;
        this.supervisor_id = supervisor_id;
        this.supervisor_name = supervisor_name;
        this.supervisor_email = supervisor_email;
        this.supervisor_password = supervisor_password;
        this.supervisor_c_password = supervisor_c_password;

    }
    @NonNull
    @Override
    public SupervisorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.supervisor_row,parent,false);
        return new SupervisorViewCustomAdaptor.SupervisorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SupervisorViewHolder holder, int position) {
        holder.supervisor_id_txt.setText(String.valueOf(supervisor_id.get(position)));
        holder.supervisor_name_txt.setText(String.valueOf(supervisor_name.get(position)));
        holder.supervisor_email_txt.setText(String.valueOf(supervisor_email.get(position)));
        holder.supervisor_pass_txt.setText(String.valueOf(supervisor_password.get(position)));
        holder.supervisor_c_pass_txt.setText(String.valueOf(supervisor_c_password.get(position)));
    }

    @Override
    public int getItemCount() {
        return supervisor_id.size();
    }

    public class SupervisorViewHolder extends RecyclerView.ViewHolder{
        TextView supervisor_id_txt, supervisor_name_txt, supervisor_email_txt, supervisor_pass_txt, supervisor_c_pass_txt;
        LinearLayout supervisor_row;
        public SupervisorViewHolder(@NonNull View itemView) {
            super(itemView);
            supervisor_id_txt = itemView.findViewById(R.id.supervisor_id_txt);
            supervisor_name_txt = itemView.findViewById(R.id.supervisor_name_txt);
            supervisor_email_txt = itemView.findViewById(R.id.supervisor_email_txt);
            supervisor_pass_txt = itemView.findViewById(R.id.supervisor_pass_txt);
            supervisor_c_pass_txt = itemView.findViewById(R.id.supervisor_c_pass_txt);
            supervisor_row = itemView.findViewById(R.id.supervisor_row);
        }
    }
}