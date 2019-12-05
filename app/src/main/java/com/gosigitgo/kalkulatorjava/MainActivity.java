package com.gosigitgo.kalkulatorjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput1,edtInput2;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInput1 = findViewById(R.id.edt_input1);
        edtInput2 = findViewById(R.id.edt_input2);
        tvHasil = findViewById(R.id.tv_hasil);
    }

    public void actionTambah(View view) {
        actionHitung("+");

    }

    public void actionKurang(View view) {
        actionHitung("-");
    }

    public void actionKali(View view) {
        actionHitung("*");
    }

    public void actionBagi(View view) {
        actionHitung("/");
    }
    private void actionHitung(String operator){

        //ambil inputan dari user
        String input1 = edtInput1.getText().toString();
        String input2 = edtInput2.getText().toString();

        //lakukan validasi
        if (TextUtils.isEmpty(input1)){
            edtInput1.setError("Tidak Boleh Kosong");
        }else if (TextUtils.isEmpty(input2)){
            edtInput2.setError("Tidak Boleh Kosong");
        }else{
            //convert ke double agar bisa dikalkulasikan
            double dbinput1 = Double.parseDouble(input1);
            double dbinput2 = Double.parseDouble(input2);
            double hasil = 0;

            //kalkulasikan berdasarkan parameter
            switch (operator){
                case "+": hasil = dbinput1+dbinput2;
                break;
            }switch (operator){
                case "-": hasil = dbinput1-dbinput2;
                break;
            }switch (operator){
                case "*": hasil = dbinput1*dbinput2;
                break;
            }switch (operator){
                case "/": hasil = dbinput1/dbinput2;
                break;
            }
            //hilangkan koma
            DecimalFormat df =new DecimalFormat("0.###");

            //tampilkan hasil dari textview
            tvHasil.setText(String.valueOf(hasil));
        }
    }
}
