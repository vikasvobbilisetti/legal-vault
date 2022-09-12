package com.ziroh.legalvault.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziroh.legalvault.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserRegistration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserRegistration extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private NavController navController;
    private boolean passvis = false;
    private boolean passvis2 = false;
    private boolean info1 = false;
    private boolean info2 = false;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UserRegistration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserRegistration.
     */
    // TODO: Rename and change types and number of parameters
    public static UserRegistration newInstance(String param1, String param2) {
        UserRegistration fragment = new UserRegistration();
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
        return inflater.inflate(R.layout.fragment_user_registration, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {


        super.onViewCreated(view,savedInstanceState);
        TextView button = view.findViewById(R.id.next3);
        EditText confirm_pas = view.findViewById(R.id.confirm_pas);
        EditText create_pass = view.findViewById(R.id.create_pass);
        TextView password_is = view.findViewById(R.id.password_is);
        TextView viewable = view.findViewById(R.id.password_do);
        TextView info = view.findViewById(R.id.infoDisplay1);
        ConstraintLayout info_3 = view.findViewById(R.id.infoDisplay2);
        ImageView eye = view.findViewById(R.id.eye_1);
        ImageView eye2 = view.findViewById(R.id.eye_2);
        ImageView info1 = view.findViewById(R.id.info);
        TextView info2 = view.findViewById(R.id.hint);
        eye.setOnClickListener(view2-> pass(view2,eye,confirm_pas));
        eye2.setOnClickListener(view2-> pass2(view2,eye2,create_pass));
        info1.setOnClickListener(view3 -> info1dis(view3,info));
        info2.setOnClickListener(view4 -> info2dis(view4,info_3));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next1(view, create_pass,confirm_pas,viewable,password_is);
            }
        });
        confirm_pas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //none
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                next(view, create_pass,confirm_pas,viewable,password_is);
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //none
            }
        });

        create_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //none
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                next(view, create_pass,confirm_pas,viewable,password_is);
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //none
            }
        });

    }

    public void pass(View view2,ImageView v,EditText confirm_pas)
    {

        if(passvis) {
            v.setImageResource(R.drawable.user_registration_eye_1);
            confirm_pas.setTransformationMethod(PasswordTransformationMethod.getInstance());
            passvis=false;
        }
        else{
            v.setImageResource(R.drawable.user_registration_eye_2);
            confirm_pas.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            passvis=true;
        }

    }

    public void pass2(View view2,ImageView v,EditText create_pass)
    {

        if(passvis2) {
            v.setImageResource(R.drawable.user_registration_eye_1);
            create_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
            passvis2=false;
        }
        else{
            v.setImageResource(R.drawable.user_registration_eye_2);
            create_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            passvis2=true;
        }

    }

    public void next(View view,EditText create_pass,EditText confirm_pas, TextView viewable,TextView password_is)
    {
        int c=0;

        int s=0;
        String str=create_pass.getText().toString();
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) {
            s++;
        }

        pattern = Pattern.compile("(?:.*[a-z]){2}");
        matcher = pattern.matcher(str);
        matchFound = matcher.find();
        if(matchFound) {
            s++;
        }

        pattern = Pattern.compile("(?:.*[0-9]){2}");
        matcher = pattern.matcher(str);
        matchFound = matcher.find();
        if(matchFound) {
            s++;
        }

        pattern = Pattern.compile("(?:.*[\\D&&\\W&&\\S]){2}");
        matcher = pattern.matcher(str);
        matchFound = matcher.find();
        if(matchFound) {
            s++;
        }
        if(s == 4) {
            password_is.setVisibility(View.INVISIBLE);
            c++;
        }
        else{
            password_is.setVisibility(View.VISIBLE);
        }
        if(create_pass.getText().toString().equals(confirm_pas.getText().toString()))
        {
            viewable.setVisibility(View.INVISIBLE);
            c++;
        }
        else{
            viewable.setVisibility(View.VISIBLE);
        }
    }

    public void next1(View view, EditText create_pass,EditText confirm_pas, TextView viewable,TextView password_is)
    {
        int c=0;
        int s=0;
        String str=create_pass.getText().toString();
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(str);
        boolean matchFound = matcher.find();
        if(matchFound) {
            s++;
        }
        pattern = Pattern.compile("(?:.*[a-z]){2}");
        matcher = pattern.matcher(str);
        matchFound = matcher.find();
        if(matchFound) {
            s++;
        }
        pattern = Pattern.compile("(?:.*[0-9]){2}");
        matcher = pattern.matcher(str);
        matchFound = matcher.find();
        if(matchFound) {
            s++;
        }
        pattern = Pattern.compile("(?:.*[\\D&&\\W&&\\S]){2}");
        matcher = pattern.matcher(str);
        matchFound = matcher.find();
        if(matchFound) {
            s++;
        }
        if(s == 4) {
            password_is.setVisibility(View.INVISIBLE);
            c++;
        }
        else{
            password_is.setVisibility(View.VISIBLE);
        }
        if(create_pass.getText().toString().equals(confirm_pas.getText().toString()))
        {
            viewable.setVisibility(View.INVISIBLE);
            c++;
        }
        else{
            viewable.setVisibility(View.VISIBLE);
        }
        if(c==2)
        {
            navController = Navigation.findNavController(view);
            navController.navigate(R.id.action_userRegistration_to_userLogin);
        }
    }


    public void info1dis(View v,TextView info)
    {

        if(info1) {
            info.setVisibility(View.VISIBLE);
            info1=false;
        }
        else{
            info.setVisibility(View.GONE);
            info1=true;
        }
    }

    public void info2dis(View v ,ConstraintLayout info_3)
    {
        if(info2) {
            info_3.setVisibility(View.VISIBLE);
            info2=false;
        }
        else{
            info_3.setVisibility(View.GONE);
            info2=true;
        }
    }
}