package com.example.a47276138y.cartas_magic;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.example.a47276138y.cartas_magic.R.id.title_detail;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private ImageView image_detail;
    private TextView title_detail;
    private TextView type_detail;
    private TextView rarity_detail;
    private TextView color_detail;
    private TextView resistencia;
    private TextView text_detail;

    private View view;


    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);

                     Intent i = getActivity().getIntent();

                       if (i != null) {
                        Carta carta = (Carta) i.getSerializableExtra("carta");

                              if (carta != null) {
                               updateUi(carta);
                           }
                   }

        return view;
    }

    private void updateUi(Carta carta) {

        image_detail =(ImageView) view.findViewById(R.id.image_detail);
        title_detail = (TextView) view.findViewById(R.id.title_detail);
        type_detail = (TextView) view.findViewById(R.id.type_detail);
        rarity_detail= (TextView) view.findViewById(R.id.rarity_detail);
        color_detail = (TextView) view.findViewById(R.id.color_detail);
        resistencia= (TextView) view.findViewById(R.id.resistencia);
        text_detail = (TextView) view.findViewById(R.id.text_detail);


        Glide.with(getContext()).load(carta.getImgURL()).into(image_detail);
        title_detail.setText(carta.getName());
        type_detail.setText(carta.getTipus());
        rarity_detail.setText(carta.getRarity());
        color_detail.setText(carta.getColor());
        resistencia.setText(carta.getResistencia());
        text_detail.setText(carta.getText());


        Log.d("CARTA", carta.toString());
    }



}
