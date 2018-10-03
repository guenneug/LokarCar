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
import fr.eni.lokacar.bo.Client;
import fr.eni.lokacar.bo.Vehicule;
import fr.eni.lokacar.utils.ViewUtil;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ViewHolder> {


    private List<Client> clients;
    private ClickListenerClient clickListenerClient;

    public ClientAdapter() {
        this.clients=new ArrayList<>();
    }

    public ClientAdapter(ClickListenerClient listenerClient){
        this();
        this.clickListenerClient = listenerClient;
    }

    public void addClients (List<Client> clients)
    {this.clients.addAll(clients);}

    @NonNull
    @Override
    public ClientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_dans_liste_client,parent,false);
        return new ClientAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ViewHolder holder, int position) {
        Client clientAAfficher = this.clients.get(position);
        holder.tvNomClient.setText(clientAAfficher.getNom());
        holder.tvPrenomClient.setText(clientAAfficher.getPrenom());

    }

    @Override
    public int getItemCount()  {
        return clients!=null?clients.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomClient;
        TextView tvPrenomClient;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvNomClient=itemView.findViewById(R.id.tvNomClient);
            this.tvPrenomClient=itemView.findViewById(R.id.tvPrenomClient);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ClientAdapter.this.clickListenerClient!=null)
                    {
                        clickListenerClient.onClickClient(clients.get(getAdapterPosition()));
                    }
                }
            });

        }
    }

    public interface ClickListenerClient{
        void onClickClient(Client client);

    }
}