package com.dicoding.picodiploma.barvolume;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dicoding.picodiploma.barvolume.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    //dengan metode findviewbyid
   /* private EditText edtWidth;
    private EditText edtLength;
    private EditText edtHeight;
    private Button btnCalculate;
    private TextView tvResult;*/

    private static final String STATE_RESULT =  "state result";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCalculate.setOnClickListener(this);


        //dengan metode findviewbyid
        /*edtWidth = findViewById(R.id.edt_width);
        edtLength = findViewById(R.id.edt_length);
        edtHeight = findViewById(R.id.edt_height);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);*/

        //btnCalculate.setOnClickListener(this);

        if (savedInstanceState !=null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            binding.tvResult.setText(result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, binding.tvResult.getText().toString());

    }

    @Override
    public void onClick(View v) {

        if (v == binding.btnCalculate) {
            String inputLength = binding.edtHeight.getText().toString().trim();
            String inputWidth = binding.edtWidth.getText().toString().trim();
            String inputHeight = binding.edtHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                binding.edtHeight.setError("Field tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                binding.edtLength.setError("Field tidak boleh kosong");
            }
            if ((TextUtils.isEmpty(inputWidth))) {
                isEmptyFields = true;
                binding.edtWidth.setError("Field tidak boleh kosong");
            }

            if (!isEmptyFields) {
                double volume = Double.valueOf(inputLength) * Double.valueOf(inputWidth) * Double.valueOf(inputHeight);
                binding.tvResult.setText(String.valueOf(volume));
            }
        }


    }
}