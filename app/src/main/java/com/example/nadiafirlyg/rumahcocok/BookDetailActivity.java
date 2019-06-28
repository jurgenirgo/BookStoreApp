package com.example.nadiafirlyg.rumahcocok;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {


    private int item = 0;

    TextView sumTextView;
    TextView priceTotalTextView;

    private int price = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);


        //Source untuk perhitungan dalam halaman detail
        String name = getIntent().getStringExtra("name");
        String typs = getIntent().getStringExtra("type");

        int image;
        image = getIntent().getIntExtra("image", -1);

        price = getIntent().getIntExtra("price", -1);

        Log.e("SECOND ACTIVITY", name);

        // udah deh tinggal diset semua komopnennya
        TextView nameTextView = (TextView) findViewById(R.id.book_name_text_view);
        nameTextView.setText(name);
        TextView type = (TextView) findViewById(R.id.type);
        type.setText(typs);

        ImageView imageView = (ImageView) findViewById(R.id.book_image);
        imageView.setImageResource(image);
        imageView.setVisibility(View.VISIBLE);

        TextView priceTextView = (TextView)findViewById(R.id.price_detail_text_view);
        priceTextView.setText(Integer.toString(price));

        sumTextView = (TextView)findViewById(R.id.sum_text_view);

        priceTotalTextView = (TextView)findViewById(R.id.price_total_text_view);


        Button incrementButton = (Button)findViewById(R.id.increment_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();

            }
        });

        Button decrementButton = (Button)findViewById(R.id.decrement_button);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });


        Button pesan = (Button)findViewById(R.id.order_button);
        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BookDetailActivity.this);
                builder.setMessage ("Terima Kasih! \nBuku Anda telah dipisahkan di Toko Buku Member Anda.").setNegativeButton("OK",null).create().show();
            }
        });

    }

    private void increment(){
        item++;
        sumTextView.setText(Integer.toString(item));
        priceTotalTextView.setText(Integer.toString(sumOfProduct(price)));
    }

    private void decrement(){
        if(item >0 ){
            item--;
        }
        sumTextView.setText(Integer.toString(item));
        priceTotalTextView.setText(Integer.toString(sumOfProduct(price)));
    }

    private int sumOfProduct(int price){
        return item * price;
    }
}
