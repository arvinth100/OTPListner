<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@color/background">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/primary"
        android:title="OTP Watcher"
        android:titleTextColor="@android:color/white"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="16dp">

        <!-- Status Card -->
        <androidx.cardview.widget.CardView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="12dp"
            app:cardCornerRadius="12dp"
            app:cardElevation="4dp">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="16dp">

                <TextView
                    android:id="@+id/tvStatus"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="Checking permissions…"
                    android:textSize="16sp"
                    android:textStyle="bold"/>

                <TextView
                    android:id="@+id/tvCount"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="4dp"
                    android:text="Total: 0  •  Suspicious: 0"
                    android:textSize="13sp"
                    android:textColor="#666666"/>

                <com.google.android.material.chip.ChipGroup
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="10dp">

                    <com.google.android.material.chip.Chip
                        android:id="@+id/chipSms"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="SMS"/>

                    <com.google.android.material.chip.Chip
                        android:id="@+id/chipUsage"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Usage Stats"/>

                    <com.google.android.material.chip.Chip
                        android:id="@+id/chipNotif"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="Notifications"/>
                </com.google.android.material.chip.ChipGroup>

                <Button
                    android:id="@+id/btnGrantUsage"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:text="Grant Usage Stats Permission"
                    android:backgroundTint="@color/primary"
                    android:visibility="gone"/>

                <Button
                    android:id="@+id/btnGrantNotif"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="4dp"
                    android:text="Grant Notification Listener Permission"
                    android:backgroundTint="@color/orange"
                    android:visibility="gone"/>

            </LinearLayout>
        </androidx.cardview.widget.CardView>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="OTP Access Log"
            android:textSize="15sp"
            android:textStyle="bold"
            android:layout_marginBottom="8dp"
            android:textColor="#333333"/>

        <TextView
            android:id="@+id/tvEmpty"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:gravity="center"
            android:padding="32dp"
            android:text="No OTP activity detected yet.\n\nSend yourself a test OTP to see monitoring in action."
            android:textColor="#999999"
            android:textSize="14sp"/>

        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recyclerView"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"/>

        <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/fab"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="end"
            android:layout_marginTop="8dp"
            android:contentDescription="Clear logs"
            android:src="@android:drawable/ic_menu_delete"
            app:backgroundTint="@color/primary"/>

    </LinearLayout>
</LinearLayout>
