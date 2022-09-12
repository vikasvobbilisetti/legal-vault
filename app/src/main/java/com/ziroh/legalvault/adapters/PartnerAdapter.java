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
import com.ziroh.legalvault.datastorage.Partner;

import java.util.List;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.PartnerViewHolder> {

    private List<Partner> partnerList;

    public PartnerAdapter(List<Partner> partnerList) {
        this.partnerList = partnerList;
    }

    @NonNull
    @Override
    public PartnerAdapter.PartnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_format, parent, false);
        return new PartnerAdapter.PartnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartnerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String name = partnerList.get(position).getPartnerName();
        String email_id = partnerList.get(position).getPartnerEmailID();
        int delete = partnerList.get(position).getPartnerDeleteSymbol();
        holder.setData(name, email_id, delete);
        holder.partner_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                partnerList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,partnerList.size());
            }
        });
    }


    @Override
    public int getItemCount() {
        return partnerList.size();
    }

    public class PartnerViewHolder extends RecyclerView.ViewHolder {

        private TextView partner_name;
        private TextView partner_email;
        private ImageView partner_delete;

        public PartnerViewHolder(@NonNull View itemView) {
            super(itemView);
            partner_name = itemView.findViewById(R.id.employee_name);
            partner_email = itemView.findViewById(R.id.employee_email);
            partner_delete = itemView.findViewById(R.id.employee_delete);
        }

        public void setData(String name, String email_id, int delete) {
            this.partner_name.setText(name);
            this.partner_email.setText(email_id);
            this.partner_delete.setImageResource(delete);
        }
    }
}
