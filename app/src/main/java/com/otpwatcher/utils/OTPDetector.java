package com.otpwatcher.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class OTPDetector {
    private static final Pattern OTP_PATTERN = Pattern.compile("\\b(\\d{4,8})\\b");

    private OTPDetector() {}

    public static String extractOtp(String text) {
        if (text == null) return "";
        Matcher matcher = OTP_PATTERN.matcher(text);
        return matcher.find() ? matcher.group(1) : "";
    }
}
