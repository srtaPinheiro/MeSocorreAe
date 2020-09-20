package com.example.mesocorreae;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import modelDominio.Categoria;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.MyViewHolder> {
    private List<Categoria> listaCategorias;
    private CategoriaOnClickListener categoriaOnClickListener;

    public CategoriaAdapter(List<Categoria> listaCategorias, CategoriaOnClickListener categoriaOnClickListener) {
        this.listaCategorias = listaCategorias;
        this.categoriaOnClickListener = categoriaOnClickListener;
    }

    @Override
    public CategoriaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categoria_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CategoriaAdapter.MyViewHolder holder, final int position) {
        Categoria categoria = listaCategorias.get(position);
        holder.tvCategoriaNome.setText(categoria.getNome());

        if (categoriaOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categoriaOnClickListener.onClickCategoria(holder.itemView,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return listaCategorias.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoriaNome;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvCategoriaNome = itemView.findViewById(R.id.tvCategoriaNome);
        }
    }

    public interface CategoriaOnClickListener {
        public void onClickCategoria(View view, int position);
    }

}
