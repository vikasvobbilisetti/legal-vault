package com.ziroh.legalvault.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.datastorage.ManageContact_G_S;

import java.util.List;

public class ManageContactAdapter extends RecyclerView.Adapter<ManageContactAdapter.ViewHolder>{


    private List<ManageContact_G_S> contactList;
    Context mcontext;

    public ManageContactAdapter(List<ManageContact_G_S> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext=parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_manage_team_member_format, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        String name = contactList.get(position).getName();
        String email_id = contactList.get(position).getEmail_id();
        int delete = contactList.get(position).getDelete();
        holder.setData(name, email_id, delete);

        holder.contact_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contactList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,contactList.size());

            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contact_name;
        private TextView contact_email;
        private ImageView contact_dot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contact_name = itemView.findViewById(R.id.contact_name);
            contact_email = itemView.findViewById(R.id.contact_email);
            contact_dot = itemView.findViewById(R.id.contact_dot);
        }

        public void setData(String name, String email_id, int delete) {
            this.contact_name.setText(name);
            this.contact_email.setText(email_id);
            this.contact_dot.setImageResource(delete);
        }

    }
}

