package com.ziroh.legalvault.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.datastorage.Client;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder>{

    private List<Client> clientList;

    public ClientAdapter(List<Client> clientList) {
        this.clientList = clientList;
    }

    @NonNull
    @Override
    public ClientAdapter.ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_format, parent, false);
        return new ClientAdapter.ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientAdapter.ClientViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String name = clientList.get(position).getClientName();
        String email_id = clientList.get(position).getClientEmailID();
        int delete = clientList.get(position).getClientDeleteSymbol();
        holder.setData(name, email_id, delete);

        holder.client_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clientList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,clientList.size());

            }
        });
    }

    @Override
    public int getItemCount() {
        return clientList.size();
    }

    public class ClientViewHolder extends RecyclerView.ViewHolder {

        private TextView client_name;
        private TextView client_email;
        private ImageView client_delete;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            client_name = itemView.findViewById(R.id.employee_name);
            client_email = itemView.findViewById(R.id.employee_email);
            client_delete = itemView.findViewById(R.id.employee_delete);
        }

        public void setData(String name, String email_id, int delete) {
            this.client_name.setText(name);
            this.client_email.setText(email_id);
            this.client_delete.setImageResource(delete);
        }
    }
}
