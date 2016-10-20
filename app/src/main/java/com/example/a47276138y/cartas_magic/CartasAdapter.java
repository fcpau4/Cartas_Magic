package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Pau on 20/10/16.
 */

public class CartasAdapter extends ArrayAdapter<Carta> {

    public CartasAdapter(Context context, int resource, List<Carta> objects){
        super(context, resource, objects);
    }
}
