package com.example.a47276138y.cartas_magic;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.example.a47276138y.cartas_magic.databinding.FragmentDetailBinding;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {


    private FragmentDetailBinding binding;
    View view;


    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_detail, container, false);
        View view = binding.getRoot();

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

        Glide.with(getContext()).load(carta.getImgURL()).into(binding.imageDetail);
        binding.titleDetail.setText(carta.getName());
        binding.typeDetail.setText(carta.getTipus());
        binding.rarityDetail.setText(carta.getRarity());
        binding.resistencia.setText(carta.getResistencia());
        binding.textDetail.setText(carta.getDescrip());

        Log.d("CARTA", carta.toString());
    }



}
