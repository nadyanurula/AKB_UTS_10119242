package com.example.uts_if6_10119242_nadyanurulawaliyah.ui.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uts_if6_10119242_nadyanurulawaliyah.R;
import com.example.uts_if6_10119242_nadyanurulawaliyah.database.Activities;

import java.util.List;
import java.util.ResourceBundle;

public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ActivityViewHolder>  {
    private final Context context;
    private List<Activities> activitiesList;

    public ActivityListAdapter(Context context){ this.context =context;}
    @SuppressLint("NotifyDataSetChanged")
    public void setActivitiesList(List<Activities> list){
        this.activitiesList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ActivityListAdapter.ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_activities_rows,parent,false);
        return new ActivityListAdapter.ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityListAdapter.ActivityViewHolder holder, int position) {
        holder.kegiatan.setText((this.activitiesList.get(position).kegiatan));
        holder.imagename.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.activitiesList.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return this.activitiesList.size();
    }
    public class ActivityViewHolder extends RecyclerView.ViewHolder{
        TextView kegiatan;
        ImageView imagename;
        public ActivityViewHolder (@NonNull View itemView) {
            super(itemView);
            kegiatan = itemView.findViewById(R.id.activity_recycle_activityname);
            imagename =itemView.findViewById(R.id.activity_recycle_image);
        }
    }
    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }
}
