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
import com.ziroh.legalvault.datastorage.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;

    public EmployeeAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_format, parent, false);
        return new EmployeeViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        String name = employeeList.get(position).getEmployeeName();
        String email_id = employeeList.get(position).getEmployeeEmailID();
        int delete = employeeList.get(position).getEmployeeDeleteSymbol();
        holder.setData(name, email_id, delete);

        holder.employee_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employeeList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,employeeList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView employee_name;
        private TextView employee_email;
        private ImageView employee_delete;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            employee_name = itemView.findViewById(R.id.employee_name);
            employee_email = itemView.findViewById(R.id.employee_email);
            employee_delete = itemView.findViewById(R.id.employee_delete);
        }

        public void setData(String name, String email_id, int delete) {
            this.employee_name.setText(name);
            this.employee_email.setText(email_id);
            this.employee_delete.setImageResource(delete);
        }
    }

}
