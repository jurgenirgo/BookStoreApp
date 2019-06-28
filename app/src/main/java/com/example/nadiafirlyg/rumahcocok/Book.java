package com.example.nadiafirlyg.rumahcocok;

/**
 * Created by NADIA FIRLY G on 1/15/2018.
 */

public class Book {
    final private int NO_IMAGE = -1;

    //nama kue
    private String bookName;

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    //resource gambar, inisialisasi no image -1 berarti tidak ada gambar
    private int mImageResouce = NO_IMAGE;

    //harga kue
    private int bookPrice;

    // mau nambahin ini tapi mager wkwkwkwk
    private String bookDescription;



    // konstruktor kelas, dibuat untuk inisialisasi pertama kali
    public Book(String bookName, int mImageResouce, int bookPrice, String type){
        this.bookName = bookName;
        this.mImageResouce = mImageResouce;
        this.bookPrice = bookPrice;
        this.type = type;
    }

    // method untuk mengambil nama makanan
    public String getBookName(){
        return bookName;
    }
    public String getType() {
        return type;
    }

    // method untuk mengambil resource gambar
    public int getmImageResouce(){
        return mImageResouce;
    }

    // method untuk mengambil harga makanan
    public int getBookPrice(){
        return bookPrice;
    }

    // lupakan :( ........
    public String getBookDescription(){
        return bookDescription;
    }
}

