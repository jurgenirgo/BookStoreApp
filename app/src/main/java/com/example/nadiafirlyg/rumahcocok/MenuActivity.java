package com.example.nadiafirlyg.rumahcocok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        // ArrayList buat nampung nilai kelompok

        final ArrayList<Book> books = new ArrayList<>();

        //Berikut nilai yang dibuat untuk mengisi konstruktor
        //ArrayList berfungsi untuk menampung macam-macam type rumah yang sebelumnya sudah diinisialisasi
        books.add(new Book("CREATE YOUR OWN ANDROID APP", R.drawable.a1, 54800,"Nadia Firly Gunawan"));
        books.add(new Book("LETS BUILD YOUR ANDROID APP", R.drawable.a2, 48700,"Alfa Setya P"));
        books.add(new Book("MUDAH BERBISNIS DNGN ANDROID", R.drawable.a3, 56700,"Yuda Yudhanto"));
        books.add(new Book("ANDROID DALAM 5 MENIT", R.drawable.a4, 48900,"Hanif Irsyad"));
        books.add(new Book("PEMROGRAMAN ANDROID DALAM SEHARI", R.drawable.a5, 54800,"Tim ESM"));
        books.add(new Book("APLIKASI ANDROID DGN THUNKABLE", R.drawable.a6, 54800,"Ani Ismayani"));


        //Bertujuan untuk menghubungkan data dangan View
        adapter = new BookAdapter(this, books);

        //berikut ini adalah View yang nantinya diberikan adapter
        ListView orderListView = (ListView) findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);
        // agar dapat di klik perlistView
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // OnItemClickListener > biar setiap item di listView bisa di click, sama kaya OnClickListener
            // tp ini peritem bisa diclick
            //ada beberapa parameter di method onItemClick, bisa dicari satu satu
            // mau ngejelasin aja, gue pake yang parameter position, buat ngambil item berdasarkan index dari atas listView
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ketika salah satu item diclick pasti method ini ke trigger
                // logikanya itu setiap item diclick maka akan muncul kelas CakeDetailActivity dengan data yang berbeda beda
                // sesuai dengan listViewnya
                Intent i = new Intent(MenuActivity.this, BookDetailActivity.class);

                // fungsinya sama kaya yang di cake, buat ngambil nilai Cake berdasarkan posisinya yang dipilih
                Book currentBook = books.get(position);

                // abaikan
                Log.e("BOOK NAME",currentBook.getBookName());

                // put extra digunain buat ngirim nilai antar activity
                // ada 2 parameter,"name" itu nama uniknya, currentCake.balbalba() itu buat nilainya
                i.putExtra("name", currentBook.getBookName());
                i.putExtra("image", currentBook.getmImageResouce());
                i.putExtra("price", currentBook.getBookPrice());
                i.putExtra("type",currentBook.getType());

                // kalo udah diset semuanya langsugn start activity
                startActivity(i);
            }
        });


    }
}

