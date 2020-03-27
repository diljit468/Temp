package com.tempratureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonConvert;
    private EditText edFer, edCel;
    Double a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setUp();
    }

    private void initView() {
        buttonConvert = findViewById(R.id.buttonConvert);
        edFer = findViewById(R.id.edFer);
        edCel = findViewById(R.id.edCel);

    }

    private void setUp() {
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();
            }
        });
    }

    private void Validate() {

        if (edCel.getText().toString().isEmpty() && edFer.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!edCel.getText().toString().isEmpty()) {
            a = Double.parseDouble(String.valueOf(edCel.getText()));
            Double b = a * 9 / 5 + 32;
            String r = String.valueOf(b);
            edFer.setText(r);
            Toast.makeText(MainActivity.this, r + "°F", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!edFer.getText().toString().isEmpty()) {
            a = Double.parseDouble(String.valueOf(edFer.getText()));
            Double b = a - 32;
            Double c = b * 5 / 9;
            String r = String.valueOf(c);
            edCel.setText(r);
            Toast.makeText(MainActivity.this, r + "°C", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
