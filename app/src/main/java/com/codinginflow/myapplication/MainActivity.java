package com.codinginflow.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    final String PASS_APP = "lam@123";
    final String NAME_APP = "tunglam";
    EditText edtName;
    EditText edtPass;
    Button btnLogin;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        processEvent();
    }

    private void init() {
        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
    }

    private void processEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDTO loginDTO = new LoginDTO();
                loginDTO.setUserName(edtName.getText().toString());
                String pass = edtPass.getText().toString();
                String name = edtName.getText().toString();
                if(pass.equals(PASS_APP) && name.equals(NAME_APP)){
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("loginDTO", loginDTO);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Username hoặc pass sai, nhập lại : -  ",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
