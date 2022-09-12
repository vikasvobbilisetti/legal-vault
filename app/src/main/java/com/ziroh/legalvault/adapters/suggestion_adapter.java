package com.ziroh.legalvault.adapters;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.datastorage.Employee;
import com.ziroh.legalvault.R;

import java.util.List;

public class suggestion_adapter extends RecyclerView.Adapter<suggestion_adapter.ViewHolder>{

    private List<Employee> employeeList;
    Dialog myDialog;
    public static String temp = "null";

    public suggestion_adapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suggestion_format, parent, false);
        ViewHolder v = new ViewHolder(view);

//        v.item_contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = v.getAdapterPosition();
//                System.out.println(position);
//                myDialog = new Dialog(parent.getContext());
//                myDialog.setContentView(R.layout.fragment_layout1);
//                EditText temp = (EditText) myDialog.findViewById(R.id.admin_input);
//                try {
//                    temp.setText(employeeList.get(position).getName());
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//                System.out.println(temp.getText().toString());
//            }
//        });
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = employeeList.get(position).getEmployeeName();
        String id = employeeList.get(position).getEmployeeEmailID();
        holder.setData(name, id);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView id;
        private ConstraintLayout item_contact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_contact = (ConstraintLayout) itemView.findViewById(R.id.suggestion_contact_id);
            name = itemView.findViewById(R.id.name_input);
            id = itemView.findViewById(R.id.email_input);
        }

        public void setData(String admin_name, String admin_id) {
            this.name.setText(admin_name);
            this.id.setText(admin_id);
        }
    }
}

