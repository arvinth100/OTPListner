package com.otpwatcher;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.otpwatcher.adapter.OTPEventAdapter;
import com.otpwatcher.model.OTPEvent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<OTPEvent> sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvStatus = findViewById(R.id.tvStatus);
        TextView tvCount = findViewById(R.id.tvCount);
        TextView tvEmpty = findViewById(R.id.tvEmpty);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fab = findViewById(R.id.fab);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sample = createSampleData();
        recyclerView.setAdapter(new OTPEventAdapter(sample));

        tvStatus.setText("Monitoring is active");
        tvCount.setText("Total: " + sample.size() + "  •  Suspicious: 1");
        tvEmpty.setVisibility(sample.isEmpty() ? View.VISIBLE : View.GONE);

        fab.setOnClickListener(v -> {
            sample.clear();
            recyclerView.getAdapter().notifyDataSetChanged();
            tvCount.setText("Total: 0  •  Suspicious: 0");
            tvEmpty.setVisibility(View.VISIBLE);
        });
    }

    private List<OTPEvent> createSampleData() {
        List<OTPEvent> items = new ArrayList<>();
        long now = System.currentTimeMillis();
        items.add(new OTPEvent("1", "Bank", "Your OTP is 123456. Valid for 2 minutes.", "123456", now, "com.bank.app", "Secure Bank"));
        items.add(new OTPEvent("2", "UPI", "Use code 875421 to complete payment", "875421", now - 120000, "com.upi.wallet", "UPI Wallet"));
        return items;
    }
}
