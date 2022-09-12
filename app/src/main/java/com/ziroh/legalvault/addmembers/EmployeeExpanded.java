package com.ziroh.legalvault.addmembers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.adapters.EmployeeAdapter;
import com.ziroh.legalvault.dashboard.DashboardTemplate;
import com.ziroh.legalvault.datastorage.EmployeeList;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeExpanded#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeExpanded extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private EmployeeAdapter adapter;
    public static int lengthOfList;
    private NavController navController;
    private DatePickerDialog.OnDateSetListener setListener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeExpanded() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeExpanded.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeExpanded newInstance(String param1, String param2) {
        EmployeeExpanded fragment = new EmployeeExpanded();
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
        return inflater.inflate(R.layout.fragment_employee_expanded, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);

        TextView save = view.findViewById(R.id.save_2);
        TextView employeeCount = view.findViewById(R.id.user_count);
        TextView addMore = view.findViewById(R.id.add_more_2);
        TextView back = view.findViewById(R.id.back_2);
        TextView goToDashboard = view.findViewById(R.id.go_to_dashb_2);

        EditText name = view.findViewById(R.id.name_input_2);
        EditText email = view.findViewById(R.id.email_input_2);

        EditText date = view.findViewById(R.id.optional_input_2);
        ImageView calender = view.findViewById(R.id.calender_EmployeeExpanded);

        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
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
                navController.navigate(R.id.action_employeeExpanded_to_addEmployee);
            }
        });

        goToDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DashboardTemplate.class);
                startActivity(intent);
            }
        });

        // initiateData(view);
        setLengthOfList(EmployeeList.getNumberOfEmployees());
        initiateRecyclerView(view);
    }

    private void initiateRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(this.getContext());
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new EmployeeAdapter(EmployeeList.getEmployeeList());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public static int getLengthOfList() {
        return lengthOfList;
    }

    public void setLengthOfList(int lengthOfList) {
        this.lengthOfList = lengthOfList;
    }
}