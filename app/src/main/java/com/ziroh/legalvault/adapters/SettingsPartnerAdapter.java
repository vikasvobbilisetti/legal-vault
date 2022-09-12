package com.ziroh.legalvault.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.datastorage.SettingsPartner;

import java.util.List;

public class SettingsPartnerAdapter extends RecyclerView.Adapter<SettingsPartnerAdapter.SettingsPartnerViewHolder>{

    private List<SettingsPartner> partnerList;

    public SettingsPartnerAdapter(List<SettingsPartner> partnerList) {
        this.partnerList = partnerList;
    }

    @NonNull
    @Override
    public SettingsPartnerAdapter.SettingsPartnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_member_format, parent, false);
        return new SettingsPartnerAdapter.SettingsPartnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsPartnerAdapter.SettingsPartnerViewHolder holder, int position) {
        String partName = partnerList.get(position).getSettingsPartnerName();
        String partEmail = partnerList.get(position).getSettingsPartnerEmail();

        holder.setData(partName, partEmail);
    }

    @Override
    public int getItemCount() {
        return partnerList.size();
    }

    public class SettingsPartnerViewHolder extends RecyclerView.ViewHolder {

        private CheckBox partnerName;
        private TextView partnerEmail;

        public SettingsPartnerViewHolder(@NonNull View itemView) {
            super(itemView);

            partnerName = itemView.findViewById(R.id.name_checkbox);
            partnerEmail = itemView.findViewById(R.id.email_settings);
        }

        public void setData(String partName, String partEmail) {
            partnerName.setText(partName);
            partnerEmail.setText(partEmail);
        }
    }
}

