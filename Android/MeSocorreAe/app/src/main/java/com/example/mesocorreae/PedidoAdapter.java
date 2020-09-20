package com.example.mesocorreae;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import factory.Funcoes;
import modelDominio.Servico;

// cria cards para cada posição do array list

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.MyViewHolder> {
    private List<Servico> listaServicos;
    private PedidoAdapter.ServicoOnClickListener servicoOnClickListener;

    public PedidoAdapter(List<Servico> listaServicos, PedidoAdapter.ServicoOnClickListener servicoOnClickListener) {
        this.listaServicos = listaServicos;
        this.servicoOnClickListener = servicoOnClickListener;
    }

    @Override
    public PedidoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pedido_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PedidoAdapter.MyViewHolder holder, final int position) {

        Servico meuServico = listaServicos.get(position);
        if (meuServico.getAutonomo().getFoto() != null) {
            Bitmap bitmapImage = BitmapFactory.decodeByteArray(meuServico.getAutonomo().getFoto(), 0, meuServico.getAutonomo().getFoto().length);
            holder.ivPedidoListRowFoto.setImageBitmap(bitmapImage);
        }

        holder.tvPedidoListRowNome.setText(meuServico.getAutonomo().getNome());
        holder.tvPedidoListRowStatus.setText(meuServico.getSituacaoLiteral());

        switch (meuServico.getSituacao()) {
            case 'A': {
                holder.llPedidoListRowFundo.setBackgroundColor(Color.parseColor("#e5ffd5"));
                break;
            }
            case 'E': {
                holder.llPedidoListRowFundo.setBackgroundColor(Color.parseColor("#d5f6ff"));
                break;
            }
            case 'N': {
                holder.llPedidoListRowFundo.setBackgroundColor(Color.parseColor("#ffd5d5"));
                break;
            }
            case 'C': {
                holder.llPedidoListRowFundo.setBackgroundColor(Color.parseColor("#fff6d5"));
                break;
            }
        }

        String data = Funcoes.dateSqlToNormal(meuServico.getDataHoraQua().substring(0, 10));
        String hora = meuServico.getDataHoraQua().substring(11, 16);

        holder.tvPedidoListRowQuando.setText(data + " " + hora);

        if (servicoOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    servicoOnClickListener.onClickServico(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaServicos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPedidoListRowFoto;
        TextView tvPedidoListRowNome, tvPedidoListRowStatus, tvPedidoListRowQuando;
        LinearLayout llPedidoListRowFundo;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivPedidoListRowFoto = itemView.findViewById(R.id.ivPedidoListRowFoto);
            tvPedidoListRowNome = itemView.findViewById(R.id.tvPedidoListRowNome);
            tvPedidoListRowStatus = itemView.findViewById(R.id.tvPedidoListRowStatus);
            tvPedidoListRowQuando = itemView.findViewById(R.id.tvPedidoListRowQuando);
            llPedidoListRowFundo = itemView.findViewById(R.id.llPedidoListRowFundo);
        }
    }

    public interface ServicoOnClickListener {
        public void onClickServico(View view, int position);
    }

}
