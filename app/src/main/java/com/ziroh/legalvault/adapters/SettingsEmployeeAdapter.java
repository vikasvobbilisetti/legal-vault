package com.ziroh.legalvault.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.datastorage.SettingsEmployee;

import java.util.List;

public class SettingsEmployeeAdapter extends RecyclerView.Adapter<SettingsEmployeeAdapter.SettingsEmployeeViewHolder> {

    private List<SettingsEmployee> employeeList;

    public SettingsEmployeeAdapter(List<SettingsEmployee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public SettingsEmployeeAdapter.SettingsEmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_member_format, parent, false);
        return new SettingsEmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsEmployeeAdapter.SettingsEmployeeViewHolder holder, int position) {
        String empName = employeeList.get(position).getSettingsEmployeeName();
        String empEmail = employeeList.get(position).getSettingsEmployeeEmail();

        holder.setData(empName, empEmail);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class SettingsEmployeeViewHolder extends RecyclerView.ViewHolder {

        private CheckBox employeeName;
        private TextView employeeEmail;

        public SettingsEmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            employeeName = itemView.findViewById(R.id.name_checkbox);
            employeeEmail = itemView.findViewById(R.id.email_settings);
        }

        public void setData(String empName, String empEmail) {
            employeeName.setText(empName);
            employeeEmail.setText(empEmail);
        }
    }
}

