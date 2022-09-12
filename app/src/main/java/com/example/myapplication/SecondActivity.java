package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<String> data = getIntent().getStringArrayListExtra("data");

        double a = Double.parseDouble(data.get(0));
        double b = Double.parseDouble(data.get(1));
        double c = Double.parseDouble(data.get(2));

        String res = solve(a, b, c);

        Intent intent = new Intent(
                getApplicationContext(),
                MainActivity.class
        );

        Bundle bundle = new Bundle();

        bundle.putString("a", String.valueOf(a));
        bundle.putString("b", String.valueOf(b));
        bundle.putString("c", String.valueOf(c));
        bundle.putString("res", res);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    private String solve(double a, double b, double c) {
        if (a == 0) {
            return "Phương trình có nghiệm x = " + (-c / b);
        }

        double delta = b * b - 4 * a * c;
        double x1 = 0.0, x2 = 0.0;

        if (delta == 0) {
            return "Phương trình có nghiệm kép: x1 = x2 = " + (-b / (2 * a));
        } else if (delta < 0) {
            return "Phương trình vô nghiệm.";
        } else {
            x1 = ((-b) + Math.sqrt(delta)) / (2 * a);
            x2 = ((-b) - Math.sqrt(delta)) / (2 * a);
        }

        return "Phương trình có 2 nghiệm phân biệt:\nx1 = " + x1 + "\nx2 = " + x2;
    }
}
