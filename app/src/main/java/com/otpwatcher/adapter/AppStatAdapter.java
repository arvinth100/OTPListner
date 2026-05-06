package com.otpwatcher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otpwatcher.R;
import com.otpwatcher.model.AppStat;

import java.util.List;

public class AppStatAdapter extends RecyclerView.Adapter<AppStatAdapter.ViewHolder> {
    private final List<AppStat> items;

    public AppStatAdapter(List<AppStat> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_stat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppStat stat = items.get(position);
        holder.tvAppName.setText(stat.getAppName());
        holder.tvPackage.setText(stat.getPackageName());
        holder.tvCount.setText(String.valueOf(stat.getOtpCount()));
        holder.progressBar.setProgress(Math.min(100, stat.getOtpCount()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAppName;
        TextView tvPackage;
        TextView tvCount;
        android.widget.ProgressBar progressBar;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAppName = itemView.findViewById(R.id.tv_app_name);
            tvPackage = itemView.findViewById(R.id.tv_package);
            tvCount = itemView.findViewById(R.id.tv_count);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }
    }
}
