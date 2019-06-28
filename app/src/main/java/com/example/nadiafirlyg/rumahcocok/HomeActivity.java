package com.example.nadiafirlyg.rumahcocok;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity  implements View.OnClickListener{

    private Button pesanEmail;
    private Button pesanPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        pesanEmail = (Button) findViewById(R.id.btn_pesan_email);
        pesanEmail.setOnClickListener(this);

        pesanPhone = (Button) findViewById(R.id.btn_pesan_phone);
        pesanPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pesan_email:
                Intent moveIntent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_pesan_phone:
                String phoneNumber = "08123456789";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}