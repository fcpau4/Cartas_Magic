package com.example.a47276138y.cartas_magic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.alexvasilkov.events.Events;
import com.example.a47276138y.cartas_magic.databinding.FragmentCartasMagicBinding;
import java.io.IOException;
import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;


/**
 * A placeholder fragment containing a simple view.
 */
public class Cartas_MagicFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private CartasCursorAdapter adapter;
    private ProgressDialog dialog;

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


        FragmentCartasMagicBinding  binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_cartas__magic, container, false);

        View view = binding.getRoot();

        adapter = new CartasCursorAdapter(getContext(), Carta.class);

        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Loading...");

        binding.listaCartas.setAdapter(adapter);

        binding.listaCartas.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {

                    Carta c = (Carta) adapterView.getItemAtPosition(i);

                    if(!isTablet()){

                        Intent intent = new Intent(getContext(), DetailActivity.class);
                        intent.putExtra("carta", c);

                        startActivity(intent);

                    }else{
                        Events.create("card-selected").param(c).post();
                    }
            }
        });

        getLoaderManager().initLoader(0, null, this);

        return view;
    }



    @Events.Subscribe("start-downloading-data")
    void preRefresh(){
        dialog.show();
    }



    @Events.Subscribe("finish-downloading-data")
    void afterRefresh(){
        dialog.dismiss();
    }




    boolean isTablet(){
        return getResources().getBoolean(R.bool.tablet);
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
        Events.register(this);
        refresh();
    }


    private void refresh() {
        RefreshDataTask task = new RefreshDataTask(getActivity().getApplicationContext());
        task.execute();
    }




    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return DataManager.getCursorLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }


}


