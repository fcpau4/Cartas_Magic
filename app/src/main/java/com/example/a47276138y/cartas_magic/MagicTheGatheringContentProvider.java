package com.example.a47276138y.cartas_magic;


import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by Arfera on 29/11/2016.
 */

public class MagicTheGatheringContentProvider extends CupboardContentProvider {

    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";


    static{
        cupboard().register(Carta.class);
    }

    public MagicTheGatheringContentProvider(){
        super(AUTHORITY, 1);
    }
}
