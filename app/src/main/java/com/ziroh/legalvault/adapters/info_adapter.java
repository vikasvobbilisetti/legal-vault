package com.ziroh.legalvault.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.datastorage.EmployeeList;

import java.util.List;

public class info_adapter extends RecyclerView.Adapter<info_adapter.ViewHolder>{

    private List<String> info_list;


    public info_adapter(List<String> teamList) {
        this.info_list = teamList;
    }

    @NonNull
    @Override
    public info_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_format, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull info_adapter.ViewHolder holder, int position) {
        String admin_name = info_list.get(position);
        String admin_id = EmployeeList.get_id(admin_name);
        holder.setData(R.drawable.dashboard_manage_member_contact, admin_name, admin_id, R.drawable.delete_vector);

    }

    @Override
    public int getItemCount() {
        return info_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView contact_image;
        private TextView admin_name;
        private TextView admin_id;
        private ImageView delete_admin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contact_image = itemView.findViewById(R.id.contact_image);
            admin_name = itemView.findViewById(R.id.admin_name);
            admin_id = itemView.findViewById(R.id.admin_id);
            delete_admin = itemView.findViewById(R.id.delete_admin);
        }

        public void setData(int admin_view, String admin_name, String admin_id, int delete_admin) {
            this.contact_image.setImageResource(admin_view);
            this.admin_name.setText(admin_name);
            this.admin_id.setText(admin_id);
            this.delete_admin.setImageResource(delete_admin);
        }
    }
}
