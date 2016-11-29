package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a47276138y.cartas_magic.databinding.ListaCartasRowBinding;

import java.util.List;

/**
 * Created by Pau on 20/10/16.
 */

public class CartasAdapter extends ArrayAdapter<Carta> {

    public CartasAdapter(Context context, int resource, List<Carta> objects){
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Carta carta = getItem(position);
        Log.w("XXXX", carta.toString());

        ListaCartasRowBinding binding=null;

        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            binding = DataBindingUtil.inflate(inflater, R.layout.lista_cartas_row, parent, false);
        }else{
            binding = DataBindingUtil.getBinding(convertView);
        }

        binding.nameCard.setText(carta.getName());
        binding.typeCard.setText(carta.getTipus());
        Glide.with(getContext()).load(carta.getImgURL()).into(binding.imgCard);
        binding.colorCard.setText(carta.getColor());

        if(carta.getColor().equals("null")) {
            binding.colorCard.setText(carta.getColor().substring(2, carta.getColor().length()-2));
        }
        binding.rarityCard.setText(carta.getRarity());


        return binding.getRoot();

    }
}
