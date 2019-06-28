package com.example.nadiafirlyg.rumahcocok;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText un, pw;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        un = (EditText) findViewById(R.id.user_edit_text);
        pw = (EditText) findViewById(R.id.pass_edit_text);
        Button btn = (Button) findViewById(R.id.login_button);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = un.getText().toString().trim();
        String password = pw.getText().toString().trim();
        boolean kosongkah = false;
        if (v.getId() == R.id.login_button) {
            if (TextUtils.isEmpty(username)) {
                kosongkah = true;
                un.setError("Username Tak Boleh Kosong");
            }

            if (TextUtils.isEmpty(password)) {
                kosongkah = true;
                pw.setError("Password Tak Boleh Kosong");
            }
        }
        if (username.equals("admin") && password.equals("pass")) {
            Toast.makeText(getApplicationContext(), "Login Successed", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, HomeActivity.class);
            startActivity(i);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage ("Your Username or Password is Wrong, Please Try Again").setNegativeButton("Retry",null).create().show();
        }
    }
}
