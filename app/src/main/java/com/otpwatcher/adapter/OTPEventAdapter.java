package com.otpwatcher.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otpwatcher.R;
import com.otpwatcher.model.OTPEvent;

import java.util.List;
import java.util.Locale;

public class OTPEventAdapter extends RecyclerView.Adapter<OTPEventAdapter.ViewHolder> {
    private final List<OTPEvent> items;

    public OTPEventAdapter(List<OTPEvent> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_otp_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OTPEvent event = items.get(position);
        holder.tvAppName.setText(event.getAppName());
        holder.tvPackage.setText(event.getPackageName());
        holder.tvSnippet.setText(event.getMessageSnippet());
        holder.tvTime.setText(event.getFormattedTime());
        holder.tvMethod.setText("SMS");

        boolean suspicious = event.getMessageSnippet() != null
                && event.getMessageSnippet().toLowerCase(Locale.ROOT).contains("payment");
        holder.ivWarning.setVisibility(suspicious ? View.VISIBLE : View.GONE);
        holder.tvSuspicious.setVisibility(suspicious ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAppName;
        TextView tvPackage;
        TextView tvSnippet;
        TextView tvTime;
        TextView tvMethod;
        TextView tvSuspicious;
        ImageView ivWarning;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAppName = itemView.findViewById(R.id.tvAppName);
            tvPackage = itemView.findViewById(R.id.tvPackage);
            tvSnippet = itemView.findViewById(R.id.tvSnippet);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvMethod = itemView.findViewById(R.id.tvMethod);
            tvSuspicious = itemView.findViewById(R.id.tvSuspicious);
            ivWarning = itemView.findViewById(R.id.ivWarning);
        }
    }
}
