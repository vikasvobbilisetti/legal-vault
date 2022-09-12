package com.ziroh.legalvault.addmembers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.dashboard.DashboardTemplate;
import com.ziroh.legalvault.datastorage.EmployeeList;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeAddition#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeAddition extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private NavController navController;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeAddition() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeAddition.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeAddition newInstance(String param1, String param2) {
        EmployeeAddition fragment = new EmployeeAddition();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_employee_addition, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        TextView viewMore = view.findViewById(R.id.expand);
        TextView save = view.findViewById(R.id.save_1);
        TextView addMore = view.findViewById(R.id.add_more);
        TextView back = view.findViewById(R.id.back);
        TextView goToDashboard = view.findViewById(R.id.go_to_dashb);

        TextView nameDisplay = view.findViewById(R.id.name_display);
        TextView emailDisplay = view.findViewById(R.id.email_display);
        ImageView deleteDisplay = view.findViewById(R.id.delete_display);
        TextView employeeCount = view.findViewById(R.id.user_count);

        EditText name = (EditText) view.findViewById(R.id.name_input);
        EditText email = (EditText) view.findViewById(R.id.email_input);

        EditText date = view.findViewById(R.id.optional_input);
        ImageView calender = view.findViewById(R.id.calender_EmployeeAdd);
        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String dateString = day + "/" + month + "/" + year;
                        date.setText(dateString);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1 = i1 + 1;
                        String dateString = day + "/" + i1 + "/" + i;
                        date.setText(dateString);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        if (EmployeeList.getNumberOfEmployees() > 0) {
            nameDisplay.setText(EmployeeList.getEmployeeList().get(0).getEmployeeName());
            emailDisplay.setText(EmployeeList.getEmployeeList().get(0).getEmployeeEmailID());
            viewMore.setAlpha(1);
            deleteDisplay.setVisibility(View.VISIBLE);
        } else {
            nameDisplay.setText("No details registered");
            emailDisplay.setText("");
            viewMore.setAlpha(0.5f);
            deleteDisplay.setVisibility(View.INVISIBLE);
        }

        employeeCount.setText("Number of employees added :" + String.valueOf(EmployeeList.getNumberOfEmployees()));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DashboardTemplate.class);
                startActivity(intent);
            }
        });

        addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameString = name.getText().toString();
                String emailString = email.getText().toString();
                EmployeeList.addEmployee(nameString, emailString);
                navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_employeeAddition_self);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_employeeAddition_to_addEmployee);
            }
        });

        goToDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DashboardTemplate.class);
                startActivity(intent);
            }
        });

        viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_employeeAddition_to_employeeExpanded);
            }
        });
    }
}