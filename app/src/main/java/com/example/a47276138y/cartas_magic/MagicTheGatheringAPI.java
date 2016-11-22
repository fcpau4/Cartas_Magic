package com.example.a47276138y.cartas_magic;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

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

            JSONObject info = new JSONObject(jsonResponse);
            JSONArray jsonCartes = info.getJSONArray("cards");


            for (int i = 0; i < jsonCartes.length() ; i++) {

                JSONObject jsonCarta =  jsonCartes.getJSONObject(i);


                Carta c = new Carta();

                c.setName(jsonCarta.getString("name"));
                if(jsonCarta.has("type")) {
                    c.setTipus(jsonCarta.getString("type"));
                }

                c.setImgURL(jsonCarta.getString("imageUrl"));

                if(jsonCarta.has("colors")){

                    String total_colors="";
                    JSONArray color = jsonCarta.getJSONArray("colors");

                    for (int j = 0; j < color.length(); j++) {

                        total_colors += color.get(j).toString() + ",";
                    }

                    c.setColor(total_colors.substring(0, total_colors.length()-1));

                }else{
                    c.setColor("");
                }


                if(jsonCarta.has("rarity")) {
                    c.setRarity(jsonCarta.getString("rarity"));
                }

                cartes.add(c);
            }
            return cartes;
        }



        private ArrayList<Carta> doCall(String url) throws IOException {
            String JsonResponse = HttpUtils.get(url);
            try {
                return jsonProcess(JsonResponse);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


        public ArrayList<Carta> getCartes() throws IOException {
            Uri builturi = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
            String url = builturi.toString();
            Log.d("getCartes()", url);
            return doCall(url);
        }



        public ArrayList<Carta>getCardsByColor() throws IOException {
            Uri builturi = Uri.parse(BASE_URL)
                .buildUpon()
                .appendQueryParameter("colors", "White")
                .build();
            String url = builturi.toString();
            Log.d("getCardsByColor", url);
            return doCall(url);
        }



        public ArrayList<Carta>getCardsByRarity() throws IOException {
            Uri builturi = Uri.parse(BASE_URL)
                .buildUpon()
                .appendQueryParameter("rarity", "Common")
                .build();
            String url = builturi.toString();
            Log.d("getCardsByRarity", url);
            return doCall(url);
        }

}
