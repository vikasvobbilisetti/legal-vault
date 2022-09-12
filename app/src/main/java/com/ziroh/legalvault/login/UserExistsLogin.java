package com.ziroh.legalvault.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.profile.ProfilePasswordReset;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserExistsLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserExistsLogin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private NavController navController;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserExistsLogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserExistsLogin.
     */
    // TODO: Rename and change types and number of parameters
    public static UserExistsLogin newInstance(String param1, String param2) {
        UserExistsLogin fragment = new UserExistsLogin();
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
        return inflater.inflate(R.layout.fragment_user_exists_login, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {


        super.onViewCreated(view,savedInstanceState);


        TextView button = view.findViewById(R.id.next1);
        EditText email = view.findViewById(R.id.email_address);
        TextView viewable = view.findViewById(R.id.password_do);
        TextView signIn = view.findViewById(R.id.sign_in);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateEmail(view,email,viewable);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_userExistsLogin_to_userLogin);
            }
        });

    }

    private void validateEmail(View view, EditText email, TextView viewable){
        String emailInput = email.getText().toString();

        if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_userExistsLogin_to_emailVerification);
        }
        else{
            viewable.setVisibility(View.VISIBLE);
        }
    }
}