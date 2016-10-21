package com.example.a47276138y.cartas_magic;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class Cartas_MagicFragment extends Fragment {


    public ArrayList<Carta> dataList;
    private ArrayAdapter<Carta> adapter;



    public Cartas_MagicFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_cartas__magic, container, false);

        ListView listaCartas = (ListView) view.findViewById(R.id.listaCartas);

        String[] data = {"carta1", "carta2", "carta3", "carta4"};
        dataList = new ArrayList<>();

        adapter = new CartasAdapter(
                getContext(),
                R.layout.lista_cartas_row,
                dataList
        );
        listaCartas.setAdapter(adapter);

        return view;
    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cartas__magic, menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.action_refresh){
            refresh();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public void onStart() {
        super.onStart();
        refresh();
    }




    private void refresh() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }



    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Carta>>{

        @Override
        protected ArrayList<Carta> doInBackground(Void... voids) {
            MagicTheGatheringAPI api = new MagicTheGatheringAPI();
            ArrayList<Carta> result= new ArrayList<>() ;
            try {
                Log.d("doInBackground()", "comes in");
                result = api.getCartes();
                Log.d("doInBackground()", "length result: "+ result.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
            }

        @Override
        protected void onPostExecute(ArrayList<Carta> cartes) {
            super.onPostExecute(cartes);
            adapter.clear();
            for (Carta carta : cartes) {
                adapter.add(carta);
            }
        }
    }

}
