package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        TextView carta_tipos = (TextView) convertView.findViewById(R.id.types);

        name_carta.setText(carta.getName());
        carta_tipos.setText(carta.getTipos());

        return convertView;
    }
}
