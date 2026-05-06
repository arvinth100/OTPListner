# 🔐 OTP Watcher — Android App

Monitor which apps are accessing your SMS OTP (One-Time Password) messages.

## Features

- **Real-time OTP Detection** — intercepts incoming SMS messages and identifies OTPs using smart pattern matching
- **App Tracking** — logs which app/package triggered SMS access
- **OTP Log** — full timestamped history of all OTP events with sender, code, and message snippet
- **App Stats** — ranked list of all apps that have accessed OTPs, with access counts
- **Foreground Service** — persistent monitoring via a low-priority notification even when the app is in the background
- **Boot Persistence** — monitoring restarts automatically after device reboot
- **Clear History** — wipe all stored OTP records

---

## Project Structure

```
OTPWatcher/
├── app/src/main/
│   ├── AndroidManifest.xml
│   ├── java/com/otpwatcher/
│   │   ├── MainActivity.java              ← Main UI (tabs: log + stats)
│   │   ├── adapter/
│   │   │   ├── OTPEventAdapter.java       ← RecyclerView for OTP log
│   │   │   └── AppStatAdapter.java        ← RecyclerView for app stats
│   │   ├── model/
│   │   │   ├── OTPEvent.java              ← OTP event data model
│   │   │   └── AppStat.java               ← Per-app aggregate model
│   │   ├── receiver/
│   │   │   ├── SmsReceiver.java           ← BroadcastReceiver for SMS_RECEIVED
│   │   │   └── BootReceiver.java          ← Auto-start on boot
│   │   ├── service/
│   │   │   └── OTPMonitorService.java     ← Foreground service
│   │   └── utils/
│   │       ├── OTPDetector.java           ← OTP detection + extraction logic
│   │       └── OTPDatabase.java           ← SharedPreferences-based storage
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml
│       │   ├── item_otp_event.xml
│       │   └── item_app_stat.xml
│       └── values/
│           ├── colors.xml
│           ├── strings.xml
│           └── themes.xml
```

---

## Setup Instructions

### Requirements
- Android Studio Hedgehog (2023.1.1) or newer
- Android SDK 26+ (Android 8.0 Oreo)
- Java 8

### Steps

1. **Open in Android Studio**
   - File → Open → select the `OTPWatcher` folder

2. **Sync Gradle**
   - Click "Sync Now" when prompted

3. **Add launcher icons** (required before build)
   - Right-click `res` → New → Image Asset
   - Create `ic_launcher` and `ic_launcher_round`
   - Or copy any existing icons into `res/mipmap-*` folders

4. **Build & Run**
   - Connect a physical Android device (SMS doesn't work on emulator)
   - Run → Run 'app'

5. **Grant Permissions**
   - On first launch, tap "Grant Permission"
   - Allow **Receive SMS** and **Read SMS**
   - Allow **Notifications** (Android 13+)

---

## How It Works

### OTP Detection
`OTPDetector.java` uses multiple regex patterns to:
- Detect if an SMS contains an OTP keyword ("otp", "verification code", "passcode", etc.)
- Extract the numeric OTP code (4–8 digits)

### App Tracking
When an SMS is received, the `SmsReceiver` captures:
- The calling package name (from `intent.getStringExtra("calling_package")`)
- Resolves the human-readable app name via `PackageManager`

### Storage
All events are stored in `SharedPreferences` as JSON. No internet permission required — fully offline.

---

## Permissions Explained

| Permission | Why |
|---|---|
| `RECEIVE_SMS` | To intercept incoming OTP messages |
| `READ_SMS` | To read SMS content |
| `QUERY_ALL_PACKAGES` | To resolve app names from package names |
| `FOREGROUND_SERVICE` | To run persistent background monitoring |
| `RECEIVE_BOOT_COMPLETED` | To restart monitoring after reboot |
| `POST_NOTIFICATIONS` | To show the persistent monitoring notification |

**No internet permission** — your OTPs never leave the device.

---

## Privacy Notice

This app **never** sends any data to external servers. All OTP data is stored locally in the app's private storage and can be cleared at any time.
