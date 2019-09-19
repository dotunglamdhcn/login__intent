package com.codinginflow.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    TextView txtDHCN;
    TextView txtNganhHoc;
    TextView edtName;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        Intent intent = getIntent();
        LoginDTO loginDTO = (LoginDTO) intent.getSerializableExtra("loginDTO");
        edtName.setText(loginDTO.getUserName());
        processEvent();
    }

    private void processEvent() {
        txtDHCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.haui.edu.vn/vn"));
                startActivity(i1);
            }
        });

        txtNganhHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fee.haui.edu.vn/vn"));
                startActivity(i1);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void init() {
        edtName = findViewById(R.id.edtName);
        txtDHCN = findViewById(R.id.txtDHCN);
        txtNganhHoc = findViewById(R.id.txtNganhHoc);
        btnFinish = findViewById(R.id.btnFinish);
    }
}
