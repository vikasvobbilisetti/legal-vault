package com.ziroh.legalvault.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziroh.legalvault.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardSettingsConfirmChanges#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardSettingsConfirmChanges extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardSettingsConfirmChanges() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardSettingsConfirmChanges.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardSettingsConfirmChanges newInstance(String param1, String param2) {
        DashboardSettingsConfirmChanges fragment = new DashboardSettingsConfirmChanges();
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
        View view = inflater.inflate(R.layout.fragment_dashboard_settings_confirm_changes, container, false);
        TextView settings_confirm_btn;
        ImageView settings_confirm_cross;

        settings_confirm_btn = view.findViewById(R.id.remove_user_confirm);
        settings_confirm_cross = view.findViewById(R.id.remove_user_cross);

        settings_confirm_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new DashboardSettings()).commit();
            }
        });

        settings_confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new DashboardSettings()).commit();
            }
        });
        return view;
    }
}