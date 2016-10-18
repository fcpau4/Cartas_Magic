package com.example.a47276138y.cartas_magic;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 47276138y on 17/10/16.
 */

public class MagicTheGatheringAPI{

        private final String BASE_URL = "https://api.magicthegathering.io/v1/cards";

        public ArrayList<Carta> jsonProcess(String jsonResponse) throws JSONException {

            ArrayList<Carta> cartes = new ArrayList<>();

            JSONObject info = new JSONObject();
            JSONArray jsonCartes = info.getJSONArray("cards");

            for (int i = 0; i < jsonCartes.length() ; i++) {
                JSONObject jsonCarta =  jsonCartes.getJSONObject(i);

                Carta c = new Carta();
                c.setName(jsonCarta.getString("name"));
                c.setRarity(jsonCarta.getString("rarity"));
                c.setTipos(jsonCarta.getString("type"));
                c.setNumeroCarta(jsonCarta.getString("number"));
                c.setPoder(jsonCarta.getString("power"));

                cartes.add(c);


            }

            return cartes;

        }


        public String getCartes(){

            Uri builturi = Uri.parse(BASE_URL)
                    .buildUpon()
                    //.appendPath("cards")
                    .build();
            String url = builturi.toString();

            try {

                String JsonResponse = HttpUtils.get(url);
                return JsonResponse;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }




}
