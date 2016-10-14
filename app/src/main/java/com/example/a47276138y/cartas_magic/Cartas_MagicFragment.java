package com.example.a47276138y.cartas_magic;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class Cartas_MagicFragment extends Fragment {



    public Cartas_MagicFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cartas__magic, container, false);

        ListView listaCartas = (ListView) view.findViewById(R.id.listaCartas);

        return view;
    }
}
