package com.example.alarmapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Locale;

public class AddAlarmActivity extends AppCompatActivity {

    private Button saveAlarm;
    private TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_alarm);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            saveAlarm = findViewById(R.id.saveAlarmButton);
            timeView = findViewById(R.id.timeTextView);
            timeView.setOnClickListener(v1 -> {
                TimePickerDialog.OnTimeSetListener timePickerDialog = (view, hourOfDay, minute) -> {
                    String formatedTime = String.format(Locale.getDefault(), "%02d:%02d",
                            hourOfDay,minute);
                    timeView.setText(formatedTime);                    };
                Calendar cal = Calendar.getInstance();
                int initialHour = cal.get(Calendar.HOUR_OF_DAY);
                int initialMin = cal.get(Calendar.MINUTE);
                TimePickerDialog timePicker = new TimePickerDialog(
                        AddAlarmActivity.this,
                        timePickerDialog,
                        initialHour,
                        initialMin,
                        false
                );

                timePicker.show();

            });


            return insets;
        });
    }
}
