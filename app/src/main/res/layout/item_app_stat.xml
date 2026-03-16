<?xml version="1.0" encoding="utf-8"?>
<androidx.cardview.widget.CardView
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginHorizontal="16dp"
    android:layout_marginTop="10dp"
    app:cardCornerRadius="12dp"
    app:cardElevation="2dp"
    app:cardBackgroundColor="@color/color_surface">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="16dp">

        <!-- App Row -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:gravity="center_vertical">

            <ImageView
                android:id="@+id/iv_app_icon"
                android:layout_width="40dp"
                android:layout_height="40dp"
                android:src="@drawable/ic_app_default" />

            <LinearLayout
                android:layout_width="0dp"
                android:layout_weight="1"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:layout_marginStart="12dp">

                <TextView
                    android:id="@+id/tv_app_name"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="15sp"
                    android:textStyle="bold"
                    android:textColor="@color/color_on_surface" />

                <TextView
                    android:id="@+id/tv_package"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="11sp"
                    android:textColor="@color/color_on_surface_variant"
                    android:maxLines="1"
                    android:ellipsize="end" />

            </LinearLayout>

            <TextView
                android:id="@+id/tv_count"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="16sp"
                android:textStyle="bold"
                android:textColor="@color/color_primary" />

        </LinearLayout>

        <!-- Progress Bar -->
        <ProgressBar
            android:id="@+id/progress_bar"
            style="@style/Widget.AppCompat.ProgressBar.Horizontal"
            android:layout_width="match_parent"
            android:layout_height="6dp"
            android:layout_marginTop="10dp"
            android:progressTint="@color/color_primary"
            android:progressBackgroundTint="@color/color_divider"
            android:max="100"
            android:progress="50" />

    </LinearLayout>

</androidx.cardview.widget.CardView>
