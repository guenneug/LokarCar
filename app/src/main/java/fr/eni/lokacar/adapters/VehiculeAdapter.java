package fr.eni.lokacar.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import fr.eni.lokacar.R;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.dao.TypeVehiculeDAO;
import fr.eni.lokacar.utils.ViewUtil;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeAdapter.ViewHolder> {


    private List<Vehicule> vehicules;
    private ClickListenerVehicule clickListenerVehicule;

    public VehiculeAdapter() {
        this.vehicules=new ArrayList<>();
    }

    public VehiculeAdapter(ClickListenerVehicule clickListenerVehicule) {
        this();
        this.clickListenerVehicule = clickListenerVehicule;
    }

    public void addVehicules (List<Vehicule> vehicules)
    {this.vehicules.addAll(vehicules);}

    @NonNull
    @Override
    public VehiculeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_dans_liste,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculeAdapter.ViewHolder holder, int position) {

        String colorOccupee = String.valueOf(R.color.colorOccupee);

        holder.tvTitre.setText(this.vehicules.get(position).getMarque()+ " "+this.vehicules.get(position).getModele());
        holder.tvValeurImmatriculation.setText(this.vehicules.get(position).getImmatriculation());

        String typeVehicule = TypeVehiculeDAO.getType(this.vehicules.get(position).getTypeVehicule_id());


        holder.tvValeurTypeVehicule.setText(typeVehicule);

        if (this.vehicules.get(position).isLouee())
        {
            holder.relativeLayout.setBackgroundResource(R.color.colorOccupee);

        } else
        {

            holder.relativeLayout.setBackgroundResource(R.color.colorLibre);
        }


    }

    @Override
    public int getItemCount() {
        return vehicules!=null?vehicules.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitre;
        TextView tvValeurImmatriculation;
        TextView tvValeurTypeVehicule;
        LinearLayout row_linearlayout;
        RelativeLayout relativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            tvTitre = itemView.findViewById(R.id.tvTitre);

            ViewGroup vg = itemView.findViewById(R.id.layoutClesValeurs);
            row_linearlayout=(LinearLayout)itemView.findViewById(R.id.layoutClesValeurs);
            relativeLayout=(RelativeLayout)itemView.findViewById(R.id.layoutElementVehicule);
            this.tvValeurImmatriculation = ViewUtil.genererVueCleValeur(vg,"N° immatriculation");
            this.tvValeurTypeVehicule = ViewUtil.genererVueCleValeur(vg,"Type de véhicule");

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(VehiculeAdapter.this.clickListenerVehicule!=null)
                    {
                        clickListenerVehicule.onClickVehicule(vehicules.get(getAdapterPosition()));
                    }
                }
            });

        }
    }

    public interface ClickListenerVehicule
    {
        void onClickVehicule(Vehicule vehicule);
    }
}
