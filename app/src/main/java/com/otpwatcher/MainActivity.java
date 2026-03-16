package com.otpwatcher;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.otpwatcher.adapter.OTPEventAdapter;
import com.otpwatcher.model.OTPEvent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<OTPEvent> sample = new ArrayList<>();
        sample.add(new OTPEvent("1", "Bank", "Your code is 123456", "123456", System.currentTimeMillis(), "com.example", "Demo App"));
        recyclerView.setAdapter(new OTPEventAdapter(sample));
    }
}
