package fr.eni.lokacar.utils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.eni.lokacar.R;

public class ViewUtil {

    public static TextView genererVueCleValeur(ViewGroup parent, String cle)
    {
        View vueCleValeur = LayoutInflater.from(parent.getContext()).inflate(R.layout.cle_valeur,parent,false);
        parent.addView(vueCleValeur);
        ((TextView)vueCleValeur.findViewById(R.id.tvCle)).setText(cle);
        //Log.i("THIERRY",vueCleValeur.toString());
        //Log.i("THIERRY",((TextView)vueCleValeur.findViewById(R.id.tvCle)).getText().toString());
        return vueCleValeur.findViewById(R.id.tvValeur);
    }

}
