package com.kevin.emicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amount , amtint, months;
    TextView toemi, toint, topay;
    Button button, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    amount = (EditText) findViewById(R.id.amount);
    amtint = (EditText) findViewById(R.id.amtint);
    months = (EditText) findViewById(R.id.months);
    button = findViewById(R.id.button);
    toemi = findViewById(R.id.toemi);
    toint = findViewById(R.id.toint);
    topay = findViewById(R.id.topay);
    reset = findViewById(R.id.reset);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int amt = Integer.parseInt(amount.getText().toString());
            double rest = Double.parseDouble(amtint.getText().toString());
            int mon = Integer.parseInt(months.getText().toString());

            double r = rest/(12*100);
            double cal1 = 1;
            for (int i = 0; i<mon; i++){
                cal1 *= (1+r);
            }

            double ans = amt * r * (cal1/(cal1-1));
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            toemi.setText("Monthly EMI = "+df.format(ans));
            double total = ans*mon;
            topay.setText("Total Amount = "+df.format(total));
            double amtint = total-amt;
            toint.setText("Total Intrest = "+df.format(amtint));

        }
    });
    reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            amount.setText(" ");
            amtint.setText(" ");
            months.setText(" ");
        }
    });


    }
}