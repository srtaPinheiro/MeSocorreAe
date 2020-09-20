package com.example.mesocorreae;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import modelDominio.Autonomo;

public class AutonomoAdapter extends RecyclerView.Adapter<AutonomoAdapter.MyViewHolder> {
    private List<Autonomo> listaAutonomos;
    private AutonomoOnClickListener autonomoOnClickListener;

    public AutonomoAdapter(List<Autonomo> listaAutonomos, AutonomoOnClickListener autonomoOnClickListener) {
        this.listaAutonomos = listaAutonomos;
        this.autonomoOnClickListener = autonomoOnClickListener;
    }

    @Override
    public AutonomoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.autonomo_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AutonomoAdapter.MyViewHolder holder, final int position) {
        Autonomo autonomo = listaAutonomos.get(position);

        if (listaAutonomos.get(position).getFoto() != null) {
            Bitmap bitmapImage = BitmapFactory.decodeByteArray(listaAutonomos.get(position).getFoto(), 0, listaAutonomos.get(position).getFoto().length);
            holder.ivAutonomoFoto.setImageBitmap(bitmapImage);
        }
        holder.tvAutonomoNome.setText(autonomo.getNome());
        holder.tvAutonomoNota.setText(String.valueOf(autonomo.getAvaliacao()));

        if (autonomoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    autonomoOnClickListener.onClickAutonomo(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaAutonomos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvAutonomoNome, tvAutonomoNota;
        ImageView ivAutonomoFoto;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvAutonomoNome = itemView.findViewById(R.id.tvAutonomoNome);
            tvAutonomoNota = itemView.findViewById(R.id.tvAutonomoNota);
            ivAutonomoFoto = itemView.findViewById(R.id.ivAutonomoFoto);
        }
    }

    public interface AutonomoOnClickListener {
        public void onClickAutonomo(View view, int position);
    }

}
