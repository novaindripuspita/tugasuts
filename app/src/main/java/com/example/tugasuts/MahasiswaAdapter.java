package com.example.tugasuts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    private ArrayList<Mahasiswa> dataList;
    public MahasiswaAdapter(ArrayList<Mahasiswa> dataList){
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MahasiswaAdapter.MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mahasiswa_list_item, parent, false);
        return  new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaAdapter.MahasiswaViewHolder holder, int position) {
        holder.txtNama.setText("Nama :"+dataList.get(position).getNama());
        holder.txtNpm.setText("Nim :"+dataList.get(position).getNim());
        holder.txtNohp.setText("No Handphone :"+dataList.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return (dataList != null)?dataList.size() : 0;
    }
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNpm, txtNohp;

        public MahasiswaViewHolder(View itemView){
            super(itemView);
            txtNama=(TextView) itemView.findViewById(R.id.nama);
            txtNpm=(TextView) itemView.findViewById(R.id.nim);
            txtNohp=(TextView) itemView.findViewById(R.id.nohp);
        }
    }
}
