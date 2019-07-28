package com.example.tugasuts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Mahasiswa> mahasiswaList;
    private RecyclerView recyclerView;
    private MahasiswaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rcv_mahasiswa);
        MahasiswaData();
        mAdapter = new MahasiswaAdapter(mahasiswaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener (new RecyclerTouchListener(getApplicationContext(), recyclerView, new
                RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Mahasiswa mhs = mahasiswaList.get(position);
                        Toast.makeText(getApplicationContext(), mhs.getNama() + "is selected!", Toast.LENGTH_SHORT).show();
                        Intent detail_mahasiswa = new Intent(MainActivity.this, detailmahasiswa.class);
                        detail_mahasiswa.putExtra("nim", mahasiswaList.get(position).getNim());
                        detail_mahasiswa.putExtra("nama", mahasiswaList.get(position).getNama());
                        detail_mahasiswa.putExtra("nohp", mahasiswaList.get(position).getNohp());
                        startActivity(detail_mahasiswa);
                    }

                    @Override
                    public void onLongClick(View view, int position) {
                    }
                }));
    }
    private void MahasiswaData() {
        mahasiswaList = new ArrayList<>();
        mahasiswaList.add(new Mahasiswa("Nova Indri Puspita", "311610782", "087830731597"));
        mahasiswaList.add(new Mahasiswa("Uswatun Hasanah", "311610563", "081312603261"));
        mahasiswaList.add(new Mahasiswa("Oko Irfan", "31160493", "081297351781"));
        mahasiswaList.add(new Mahasiswa("Lavi", "311610613", "085759549267"));
    }
}