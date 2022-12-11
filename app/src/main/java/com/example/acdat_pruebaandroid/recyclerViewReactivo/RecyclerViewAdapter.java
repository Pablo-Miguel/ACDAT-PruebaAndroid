package com.example.acdat_pruebaandroid.recyclerViewReactivo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.acdat_pruebaandroid.R;
import com.example.acdat_pruebaandroid.databinding.RecyclerViewItemBinding;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<Persona> listaPersonas;
    private View.OnClickListener listener;
    private Integer position = null;

    public RecyclerViewAdapter(ArrayList<Persona> listaPizzas) {
        this.listaPersonas = listaPizzas;
    }

    public void addPersona(Persona persona){
        this.listaPersonas.add(persona);
        notifyItemInserted(this.listaPersonas.indexOf(persona));
    }

    public void removePersona(Persona persona) {
        int position = this.listaPersonas.indexOf(persona);

        if(position != -1) {
            this.listaPersonas.remove(persona);
            notifyItemRemoved(position);
        }
    }

    public Persona getPersona(Integer index){
        return this.listaPersonas.get(index);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewItemBinding binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        binding.getRoot().setOnClickListener(this);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(listaPersonas.get(position));

        this.position = position;

        if(this.position != null){
            holder.getBtnEliminar().setOnClickListener(this);
        }

        this.position = null;

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnEliminar){
            removePersona(getPersona(0));
        }
        else if (this.listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerViewItemBinding binding;
        public ViewHolder(RecyclerViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Persona persona){
            binding.txtPersona.setText(persona.getNombre());
        }

        public Button getBtnEliminar(){
            return binding.btnEliminar;
        }

    }
}
