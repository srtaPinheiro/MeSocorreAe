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
import modelDominio.Servico;

public class ElogioAdapter extends RecyclerView.Adapter<ElogioAdapter.MyViewHolder> {
    private List<Servico> listaServicos;
    private ElogioOnClickListener elogioOnClickListener;

    public ElogioAdapter(List<Servico> listaServicos, ElogioOnClickListener autonomoOnClickListener) {
        this.listaServicos = listaServicos;
        this.elogioOnClickListener = elogioOnClickListener;
    }

    @Override
    public ElogioAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.elogio_item_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ElogioAdapter.MyViewHolder holder, final int position) {
        Servico servico = listaServicos.get(position);

        if (servico.getCliente().getFoto() != null) {
            Bitmap bitmapImage = BitmapFactory.decodeByteArray(servico.getCliente().getFoto(), 0, servico.getCliente().getFoto().length);
            holder.ivElogioFoto.setImageBitmap(bitmapImage);
        }

        holder.tvElogioElogio.setText(servico.getAvaliacao());
        holder.tvElogioNome.setText(servico.getCliente().getNome());
        holder.tvElogioNota.setText(servico.getNota() + "/5");

        /*if (elogioOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    elogioOnClickListener.onClickElogio(holder.itemView,position);
                }
            });
        }*/
    }

    @Override
    public int getItemCount() {
        return listaServicos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvElogioNome, tvElogioNota, tvElogioElogio;
        ImageView ivElogioFoto;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvElogioElogio = itemView.findViewById(R.id.tvElogioElogio);
            tvElogioNome = itemView.findViewById(R.id.tvElogioNome);
            tvElogioNota = itemView.findViewById(R.id.tvElogioNota);
            ivElogioFoto = itemView.findViewById(R.id.ivElogioFoto);
        }
    }

    public interface ElogioOnClickListener {
        public void onClickElogio(View view, int position);
    }

}
