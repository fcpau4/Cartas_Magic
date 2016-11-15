package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lista_cartas_row, parent, false);
        }

        TextView name_carta = (TextView) convertView.findViewById(R.id.name);
        TextView carta_tipos = (TextView) convertView.findViewById(R.id.type);
        TextView carta_rarity = (TextView) convertView.findViewById(R.id.rarity);
        TextView carta_color = (TextView) convertView.findViewById(R.id.color);
        ImageView card_img = (ImageView) convertView.findViewById(R.id.img);



        name_carta.setText(carta.getName());
        carta_tipos.setText(carta.getTipus());
        Glide.with(getContext()).load(carta.getImgURL()).into(card_img);
        carta_color.setText(carta.getColor().substring(2, (carta.getColor().length()) - 2));
        carta_rarity.setText(carta.getRarity());



        return convertView;

    }
}
