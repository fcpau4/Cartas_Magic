package com.example.a47276138y.cartas_magic;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class Cartas_MagicFragment extends Fragment {

    private ArrayAdapter<String> adapter;

    public Cartas_MagicFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cartas__magic, container, false);

        ListView listaCartas = (ListView) view.findViewById(R.id.listaCartas);

        String[] data = {"carta1", "carta2", "carta3", "carta4"};
        ArrayList<String> dataList = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lista_cartas_row,
                R.id.carta,
                dataList
        );

        listaCartas.setAdapter(adapter);

        return view;
    }
}
