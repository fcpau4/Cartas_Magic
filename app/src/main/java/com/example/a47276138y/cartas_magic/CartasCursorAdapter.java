package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.a47276138y.cartas_magic.databinding.ListaCartasRowBinding;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

/**
 * Created by Arfera on 02/12/2016.
 */

public class CartasCursorAdapter extends CupboardCursorAdapter<Carta> {

    public CartasCursorAdapter(Context context, Class<Carta> entityClass) {
        super(context, entityClass);
    }


    @Override
    public View newView(Context context, Carta model, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ListaCartasRowBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.lista_cartas_row, parent, false);
                return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Carta model) {
        ListaCartasRowBinding binding = DataBindingUtil.getBinding(view);
                binding.nameCard.setText(model.getName());
                binding.typeCard.setText(model.getTipus());
                binding.colorCard.setText(model.getColor());
                binding.rarityCard.setText(model.getRarity());
                Glide.with(context).load(model.getImgURL()).into(binding.imgCard);
    }
}
