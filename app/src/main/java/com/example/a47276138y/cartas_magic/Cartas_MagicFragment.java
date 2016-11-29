package com.example.a47276138y.cartas_magic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.a47276138y.cartas_magic.databinding.FragmentCartasMagicBinding;
import com.example.a47276138y.cartas_magic.databinding.FragmentDetailBinding;
import java.io.IOException;
import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;


/**
 * A placeholder fragment containing a simple view.
 */
public class Cartas_MagicFragment extends Fragment {


    public ArrayList<Carta> dataList;
    public CartasAdapter adapter;
    public FragmentCartasMagicBinding binding;


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


        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_cartas__magic, container, false);

        View view = binding.getRoot();

        dataList = new ArrayList<>();

        adapter = new CartasAdapter(
                getContext(),
                R.layout.lista_cartas_row,
                dataList
        );


        binding.listaCartas.setAdapter(adapter);

        binding.listaCartas.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                Carta c = (Carta) adapterView.getItemAtPosition(i);

                    Intent intent = new Intent(getContext(), DetailActivity.class);

                    intent.putExtra("carta", c);

                    startActivity(intent);
            }
        });

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

        if(id==R.id.action_settings){
            Intent i = new Intent(getContext(), SettingsActivity.class);
            startActivity(i);
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



    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList>{

        @Override
        protected ArrayList<Carta> doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            String rarity = preferences.getString("rarity_list", "Mythic Rare");
            String color = preferences.getString("color_list", "White");

            ArrayList<Carta> result= new ArrayList<>() ;
            try {

                result = MagicTheGatheringAPI.getCardsByPreferences(color, rarity);

                if(result==null){
                    result = MagicTheGatheringAPI.getCartes();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            /*UriHelper helper = UriHelper.with(MagicTheGatheringContentProvider.AUTHORITY);
            Uri movieUri = helper.getUri(Carta.class);
            cupboard().withContext(getContext()).put(movieUri, Carta.class, result);*/

            DataManager.deleteMovies(getContext());
            DataManager.saveCards(result, getContext());

            return null;
        }



    }

}


