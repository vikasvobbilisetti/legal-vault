package com.ziroh.legalvault.datastorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;

import java.util.List;

public class DashboardEmployeeAdapter extends RecyclerView.Adapter<DashboardEmployeeAdapter.ViewHolder>{

    private List<Dashboard_employee_team> contactList;
    Context mcontext;

    public DashboardEmployeeAdapter(List<Dashboard_employee_team> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position_item) {

        String name =contactList.get(position_item).getName();
        String email_id = contactList.get(position_item).getEmail_id();
        String position = contactList.get(position_item).getposition();
        int delete = contactList.get(position_item).getbox();
        holder.setData(name, email_id,position, delete);


    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView employee_name;
        private TextView employee_email;
        private TextView employee_position;
        private ImageView square_View;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            employee_name = itemView.findViewById(R.id.employee_name);
            employee_email = itemView.findViewById(R.id.employee_mail);
            employee_position = itemView.findViewById(R.id.employee_position);
            square_View = itemView.findViewById(R.id.square_View);
        }

        public void setData(String name, String email_id,String position, int box) {
            this.employee_name.setText(name);
            this.employee_email.setText(email_id);
            this.employee_position.setText(position);
            this.square_View.setImageResource(box);
        }

    }
}
