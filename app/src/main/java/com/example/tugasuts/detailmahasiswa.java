package com.example.tugasuts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class detailmahasiswa extends AppCompatActivity {
private TextView txtnim, txtnama, txtnohp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmahasiswa);
        txtnim=(TextView) findViewById(R.id.id_nimdetail);
        txtnama=(TextView) findViewById(R.id.namadetail);
        txtnohp=(TextView) findViewById(R.id.nohpdetail);

        Show_Detail_Mahasiswa();
    }
    private void  Show_Detail_Mahasiswa()
    {
        txtnim.setText(getIntent().getStringExtra("nim").toString());
        txtnama.setText(getIntent().getStringExtra("nama").toString());
        txtnohp.setText(getIntent().getStringExtra("nohp").toString());
    }
}
