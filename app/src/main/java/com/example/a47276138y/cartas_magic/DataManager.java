package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by 47276138y on 29/11/16.
 */

public class DataManager {

    private static UriHelper URI_HELPER = UriHelper.with(MagicTheGatheringContentProvider.AUTHORITY);
    private static Uri CARTA_URI = URI_HELPER.getUri(Carta.class);

    static void saveCards(ArrayList<Carta> cards, Context context) {
        cupboard().withContext(context).put(CARTA_URI, Carta.class, cards);
    }

    static void deleteCards(Context context) {
        cupboard().withContext(context).delete(CARTA_URI, "_id > ?", "1");
        }

    static CursorLoader getCursorLoader(Context context) {
        return new CursorLoader(context, CARTA_URI, null, null, null, null);
    }
}
