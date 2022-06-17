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

import com.example.wjcontractors.CalculateSalaryType;
import com.example.wjcontractors.R;

import java.util.ArrayList;

public class SalaryCustomAdapter extends RecyclerView.Adapter<SalaryCustomAdapter.SalaryViewMYViewHolder>{

    private Context context;
    private Activity activity;
    private ArrayList masonry_id, masonry_name,masonry_attendance;
    //Animation translate_anim;

    public SalaryCustomAdapter(Context context, Activity activity, ArrayList masonry_id, ArrayList masonry_name, ArrayList masonry_attendance) {
        this.context = context;
        this.activity = activity;
        this.masonry_id = masonry_id;
        this.masonry_name = masonry_name;
        this.masonry_attendance = masonry_attendance;
    }

    @NonNull
    @Override
    public SalaryViewMYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.salary_row, parent, false);
        return new SalaryViewMYViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SalaryViewMYViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.masonry_id_txt.setText(String.valueOf(masonry_id.get(position)));
        holder.masonry_name_txt.setText(String.valueOf(masonry_name.get(position)));
        holder.masonry_attendance_txt.setText(String.valueOf(masonry_attendance.get(position)));
        //holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {
           //     Intent intent = new Intent(context, CalculateSalaryType.class);
           //     intent.putExtra("id", String.valueOf(masonry_id.get(position)));
           //     intent.putExtra("name", String.valueOf(masonry_name.get(position)));
            //    intent.putExtra("attendance", String.valueOf(masonry_attendance.get(position)));
           //     activity.startActivityForResult(intent,1);
          //  }
       // });
    }

    @Override
    public int getItemCount() {
        return masonry_id.size();
    }

    public class SalaryViewMYViewHolder extends RecyclerView.ViewHolder {
        TextView masonry_id_txt, masonry_name_txt,masonry_attendance_txt;
        LinearLayout mainLayout;
        public SalaryViewMYViewHolder(@NonNull View itemView) {
            super(itemView);
            masonry_id_txt = itemView.findViewById(R.id.m_id_txt);
            masonry_name_txt = itemView.findViewById(R.id.m_name_txt);
            masonry_attendance_txt = itemView.findViewById(R.id.m_Att_txt);
            mainLayout = itemView.findViewById(R.id.mainlayout);
        }
    }
}
