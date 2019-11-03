package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_year;
    private EditText editText_month;
    private EditText editText_day;
    private EditText editText_hour;
    private EditText editText_minutes;
    private EditText editText_second;
    private Button button;
    private TextView Data_text;
    private TextView Time_text;
    private TextView LeapY_text;
    int year,month,day,hour,minutes,second=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_year = findViewById(R.id.editText_year);
        editText_month = findViewById(R.id.editText_month);
        editText_day = findViewById(R.id.editText_day);
        editText_hour = findViewById(R.id.editText_hour);
        editText_minutes = findViewById(R.id.editText_minutes);
        editText_second = findViewById(R.id.editText_second);
        button = findViewById(R.id.button);
        Data_text = findViewById(R.id.DATE_text);
        Time_text = findViewById(R.id.TIME_text);
        LeapY_text = findViewById(R.id.LeapYear_text);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(editText_year.getText().toString().matches("")
                        || editText_month.getText().toString().matches("")
                        || editText_day.getText().toString().matches("")
                        ||editText_hour.getText().toString().matches("")
                        ||editText_minutes.getText().toString().matches("")
                        ||editText_second.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不要空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    year = Integer.parseInt(editText_year.getText().toString());
                    month = Integer.parseInt(editText_month.getText().toString());
                    day = Integer.parseInt(editText_day.getText().toString());
                    hour = Integer.parseInt(editText_hour.getText().toString());
                    minutes = Integer.parseInt(editText_minutes.getText().toString());
                    second = Integer.parseInt(editText_second.getText().toString());
                   // Min += (Sec/60);
                   // Sec %= 60;
                   // Hr += (Min/60);
                   // Min %= 60;
                   // D += (Hr/24) ;
                   // Hr %= 24;


                    if(year%4!=0)
                        LeapY_text.setText(getString(R.string.N_LY_Text));
                    else if(year%100!=0)
                        LeapY_text.setText(getString(R.string.Y_LY_Text));
                    else if(year%400!=0)
                        LeapY_text.setText(getString(R.string.N_LY_Text));
                    else
                        LeapY_text.setText(getString(R.string.Y_LY_Text));

                    Data_text.setText(year+"/"+month+"/"+day);
                    Time_text.setText(hour+":"+minutes+":"+second);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);



                }
            }
        });


    }
}
