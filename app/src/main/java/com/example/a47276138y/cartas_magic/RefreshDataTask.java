package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.alexvasilkov.events.Event;
import com.alexvasilkov.events.Events;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Arfera on 09/12/2016.
 */

public class RefreshDataTask extends AsyncTask<Void, Void, Void> {

    private Context context;

    RefreshDataTask(Context context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Events.post("start-downloading-data");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
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


        DataManager.deleteCards(context);
        DataManager.saveCards(result, context);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Events.post("finish-downloading-data");
    }
}
