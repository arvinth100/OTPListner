package com.otpwatcher.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class OTPEvent {
    private final String id;
    private final String sender;
    private final String messageSnippet;
    private final String otpCode;
    private final long timestamp;
    private final String packageName;
    private final String appName;

    public OTPEvent(String id, String sender, String messageSnippet,
                    String otpCode, long timestamp, String packageName, String appName) {
        this.id = id;
        this.sender = sender;
        this.messageSnippet = messageSnippet;
        this.otpCode = otpCode;
        this.timestamp = timestamp;
        this.packageName = packageName;
        this.appName = appName;
    }

    public String getId() { return id; }
    public String getSender() { return sender; }
    public String getMessageSnippet() { return messageSnippet; }
    public String getOtpCode() { return otpCode; }
    public long getTimestamp() { return timestamp; }
    public String getPackageName() { return packageName; }
    public String getAppName() { return appName; }

    public String getFormattedTime() {
        return new SimpleDateFormat("MMM dd, HH:mm:ss", Locale.getDefault()).format(new Date(timestamp));
    }
}
