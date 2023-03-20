package com.iracingui.ui.input;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.icu.text.UFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.iracingui.R;
import androidx.fragment.app.Fragment;

import java.util.Locale;


public class InputScreenFragment extends Fragment {

    public InputScreenFragment() {

    }
    Button timeButton1;
    int hour, minute;
    Button timeButton2;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.input_layout, container, false);

        TextView textView1 = view.findViewById(R.id.textView1);
        TextView textView2 = view.findViewById(R.id.textView2);
        TextView textView3 = view.findViewById(R.id.textView3);
        EditText editText3 = view.findViewById(R.id.editText3);
        TextView textView4 = view.findViewById(R.id.textView4);
        EditText editText4 = view.findViewById(R.id.editText4);
        TextView textView5 = view.findViewById(R.id.textView5);
        EditText editText5 = view.findViewById(R.id.editText5);
        TextView textView6 = view.findViewById(R.id.textView6);
        EditText editText6 = view.findViewById(R.id.editText6);
        timeButton1 = view.findViewById(R.id.timeButton1);
        timeButton2 = view.findViewById(R.id.timeButton2);


        // initial text for the TextViews
        textView1.setText("Race Length");
        textView2.setText("AVG. Lap Time");
        textView3.setText("Fuel MAX");
        textView4.setText("Fuel per Lap");
        textView5.setText("Pit Stop Delta");
        textView6.setText("Number of dipshits signed up");

        return view;
    }

    public void popTimePicker (View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;

                timeButton1.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));
            }
        };

        int style = AlertDialog.THEME_HOLO_DARK;

        TimePickerDialog timePickerDialog = new TimePickerDialog(requireActivity().getApplicationContext(), onTimeSetListener, hour, minute, true);


        timePickerDialog.setTitle("Set Tile");
        timePickerDialog.show();
    }

}
