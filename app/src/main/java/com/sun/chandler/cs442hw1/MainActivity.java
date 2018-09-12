package com.sun.chandler.cs442hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private RadioButton F2C;
    private RadioButton C2F;
    private Button convert;
    private TextView output;
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Bind var's to the screen widgets
        input = (EditText) findViewById(R.id.InputField);
        F2C = (RadioButton) findViewById(R.id.F2C);
        C2F = (RadioButton) findViewById(R.id.C2F);
        convert = (Button) findViewById(R.id.ConvertButton);
        output = (TextView) findViewById(R.id.OutputField);
        log = (TextView) findViewById(R.id.HistoryLog);
        if (F2C.isChecked()){
            F2CClicked(F2C);
        }
        else if (C2F.isChecked()){
            C2FClicked(C2F);
        };

    }
    public void F2CClicked(View v) {
        String selectionText = ((RadioButton) v).getText().toString();
        Toast.makeText(this, "You Selected " + selectionText, Toast.LENGTH_SHORT).show();
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                float InTemp = Float.parseFloat(text);
                float OutTemp = (InTemp-32)*5/9;
                String InTemp2Decimal = String.format("%.1f", InTemp);
                String OutTemp2Decimal = String.format("%.1f", OutTemp);
                if (!text.trim().isEmpty())
                    output.setText(OutTemp2Decimal);
                    String oldlog = log.getText().toString();
                    log.setText("F to C : "+InTemp2Decimal+"->"+OutTemp2Decimal+"\n"+oldlog);
            }
        });

    }

    public void C2FClicked(View v) {
        String selectionText = ((RadioButton) v).getText().toString();
        Toast.makeText(this, "You Selected " + selectionText, Toast.LENGTH_SHORT).show();
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                double InTemp = Double.parseDouble(text);
                double OutTemp = (InTemp*9.0/5.0)+32.0;
                String InTemp2Decimal = String.format("%.1f", InTemp);
                String OutTemp2Decimal = String.format("%.1f", OutTemp);
                if (!text.trim().isEmpty())
                    output.setText(OutTemp2Decimal);
                    String oldlog = log.getText().toString();
                    log.setText("C to F : "+InTemp2Decimal+"->"+OutTemp2Decimal+"\n"+oldlog);
            }
        });
    }
}
