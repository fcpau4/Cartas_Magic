package com.example.a47276138y.cartas_magic;

import android.net.Uri;

import java.io.IOException;

/**
 * Created by 47276138y on 17/10/16.
 */

public class MagicTheGatheringAPI{

        private final String BASE_URL = "https://api.magicthegathering.io/v1/";


        private String getCartes(){
            Uri builturi = Uri.parse(BASE_URL)
                    .buildUpon()
                    .appendPath("cards")
                    .build();
            String url = builturi.toString();

            try{
                String JsonResponse = HttpUtils.get(url);
                return JsonResponse;
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;

         }

}
