package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtCoefA, edtCoefB, edtCoefC;
    Button btnSolve, btnDel;
    TextView twRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        addListenerOnButtonClick();

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String a = bundle.getString("a");
            String b = bundle.getString("b");
            String c = bundle.getString("c");
            String res = bundle.getString("res");

            edtCoefA.setText(a);
            edtCoefB.setText(b);
            edtCoefC.setText(c);
            twRes.setText(res);
        }
    }

    private void addListenerOnButtonClick() {
        btnSolve.setOnClickListener(view -> {
            String a = edtCoefA.getText().toString();
            String b = edtCoefB.getText().toString();
            String c = edtCoefC.getText().toString();

            if (a.isEmpty() || b.isEmpty() || c.isEmpty()) {
                Toast.makeText(this, "Hệ số không được để trống!", Toast.LENGTH_SHORT).show();
                return;
            }

            ArrayList<String> data = new ArrayList<>();

            data.add(a);
            data.add(b);
            data.add(c);

            Intent intent = new Intent(
                    getApplicationContext(),
                    SecondActivity.class
            );

            intent.putStringArrayListExtra("data", data);
            startActivity(intent);
        });

        btnDel.setOnClickListener(view -> {
            edtCoefA.setText(null);
            edtCoefB.setText(null);
            edtCoefC.setText(null);
            twRes.setText(null);

            Toast.makeText(this, "Xoá dữ liệu thành công!", Toast.LENGTH_SHORT).show();
        });
    }

    private void mapping() {
        edtCoefA = findViewById(R.id.edt_a);
        edtCoefB = findViewById(R.id.edt_b);
        edtCoefC = findViewById(R.id.edt_c);
        btnSolve = findViewById(R.id.btn_solve);
        btnDel = findViewById(R.id.btn_del);
        twRes = findViewById(R.id.tw_result);
    }
}