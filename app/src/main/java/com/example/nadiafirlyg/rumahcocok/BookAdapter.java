package com.example.nadiafirlyg.rumahcocok;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Pembuatan kelas Adapter, adapter digunakan sebagai penghubung antar 2 medium yang berbeda
 * CakeAdapter akan menghubungkan data dengan view supaya dapat sinkron
 * data diambil dari model yang telah terbuat tadi pada kelas Cake,
 * kelas Cake akan menyimpan data secara sementara selama program berjalan
 */

public class BookAdapter extends ArrayAdapter<Book> {

    // konstruktor untuk pertama kali
    public BookAdapter(Activity context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    //getView merupakan method turunan dari ArrayAdapter fungsinya ngambil view.
    public View getView(int position, View convertView, ViewGroup parent){

        // variable convertView akan membaca view yang akan diisi, nanti pake ListView
        View listItemView = convertView;

        //jika listnya kosong, bakal keisi sama list_item.xml
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // dibawah ini ngambil data dari kelas Cake tadi berdasarkan posisi dari ArrayList.
        Book currentBook = getItem(position);

        // udah tau inimah
        TextView bookNameTextView = (TextView)listItemView.findViewById(R.id.book_name_text_view);
        bookNameTextView.setText(currentBook.getBookName());

//        TextView umurTextView = (TextView)listItemView.findViewById(R.id.umur);
//        umurTextView.setText(currentCake.getUmur());

        // karena price itu int, harus diconvert dulu
        TextView priceTextView = (TextView)listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText(Integer.toString(currentBook.getBookPrice()));

        //ini sama tapi biar gambarnya keluar pake method setVisibility
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);
        imageView.setImageResource(currentBook.getmImageResouce());
        imageView.setVisibility(View.VISIBLE);


        return listItemView;
    }
}
