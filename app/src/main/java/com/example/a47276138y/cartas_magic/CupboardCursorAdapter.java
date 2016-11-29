package com.example.a47276138y.cartas_magic;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import nl.qbusict.cupboard.Cupboard;

/**
 * Created by 47276138y on 29/11/16.
 */

public abstract class CupboardCursorAdapter<T> extends CursorAdapter {

    private final Cupboard cb;
    private Class<T> mEntityClass;


    public CupboardCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    public CupboardCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    public CupboardCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }


    public CupboardCursorAdapter(Context context, Cupboard cupboard, Class<T> entityClass, Cursor cursor) {
                super(context, cursor, false);
                this.mEntityClass = entityClass;
                this.cb = cupboard;
            }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }



    public T getItem(int position) {
         if (getCursor().moveToPosition(position)) {
                    return cb.withCursor(getCursor()).get(mEntityClass);
                } else {
                    throw new IllegalArgumentException("Invalid position: " + position);
                }
        }
}
