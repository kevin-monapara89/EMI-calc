package com.kevin.emicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amount , amtint, peri;
    TextView toemi, toint, topay;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    amount = findViewById(R.id.amount);
    amtint = findViewById(R.id.amtint);
    peri = findViewById(R.id.peri);
    button = findViewById(R.id.button);
    toemi = findViewById(R.id.toemi);
    toint = findViewById(R.id.toint);
    topay = findViewById(R.id.topay);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int amt = Integer.parseInt(amount.getText().toString());
            double rest = Double.parseDouble(amtint.getText().toString());
            int mon = Integer.parseInt(peri.getText().toString());

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

    }
}