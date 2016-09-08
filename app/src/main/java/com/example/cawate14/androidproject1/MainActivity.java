package com.example.cawate14.androidproject1;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_IBASE = 10;
    private static final int DEFAULT_OBASE = 16;

    private EditText input = null;
    private EditText input_base = null;
    private EditText output_base = null;
    private TextView output = null;

    private BaseConverter baseConverter = null;

    private boolean inputok;
    private boolean ibaseok;
    private boolean obaseok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        input_base = (EditText)findViewById(R.id.input_base);
        output_base = (EditText)findViewById(R.id.output_base);
        output = (TextView)findViewById(R.id.output);

        // Default values for base converter
        baseConverter = new BaseConverter("0", DEFAULT_IBASE, DEFAULT_OBASE);

        inputok = true;
        ibaseok = true;
        obaseok = true;

        input.setText("");
        output.setText("0");

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                // Parse the input string
                if(baseConverter.setInput(editable.toString())) {
                    inputok = true;
                    // Set input field to valid color
                    input.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.valid));
                    if(ibaseok && obaseok) {
                        // Set output field to valid color
                        output.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.valid));
                        // Update output field
                        output.setText(baseConverter.getOutput());
                    }
                } else {
                    inputok = false;
                    // Set input and output fields to error color
                    input.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.error));
                    output.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.error));
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        });

        input_base.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                // Parse the input_base string
                if(baseConverter.setIBase(editable.toString())){
                    ibaseok = true;
                    // Set input_base field to valid color
                    input_base.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.valid));
                    if(inputok && obaseok) {
                        // Set output field to valid color
                        output.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.valid));
                        // Update output field
                        output.setText(baseConverter.getOutput());
                    }
                    input.setText(input.getText().toString());
                } else {
                    ibaseok = false;
                    // Set input_base and output fields to error color
                    input_base.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.error));
                    output.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.error));
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        });

        output_base.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                // Parse the output_base string
                if(baseConverter.setOBase(editable.toString())){
                    obaseok = true;
                    // Set output_base field to valid color
                    output_base.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.valid));
                    if(inputok && ibaseok) {
                        // Set output field to valid color
                        output.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.valid));
                        // Update output field
                        output.setText(baseConverter.getOutput());
                    }
                } else {
                    obaseok = false;
                    // Set output_base and output fields to error color
                    output_base.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.error));
                    output.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.error));
                }
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
        });

        // Set default base values, triggering the above callbacks
        input_base.setText(Integer.toString(DEFAULT_IBASE));
        output_base.setText(Integer.toString(DEFAULT_OBASE));
    }
}
