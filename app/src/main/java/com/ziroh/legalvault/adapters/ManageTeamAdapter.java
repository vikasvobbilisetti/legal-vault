package com.ziroh.legalvault.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ziroh.legalvault.R;
import com.ziroh.legalvault.dashboard.DashboardManageEdit;
import com.ziroh.legalvault.datastorage.ManageTeam;
import com.ziroh.legalvault.datastorage.ManageTeamList;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManageTeamAdapter extends RecyclerView.Adapter<ManageTeamAdapter.ViewHolder> implements Filterable {

    private List<ManageTeam> teamList;
    private List<ManageTeam> teamListall= new ArrayList<>();
    Context mcontext;

    public ManageTeamAdapter(List<ManageTeam> teamList) {
        this.teamList = teamList;
        teamListall.clear();
        teamListall.addAll(teamList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext=parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_manage_team_format, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position){
        String name = teamList.get(position).getName();
        String email_id = teamList.get(position).getEmail_id();
        int delete = teamList.get(position).getDelete();
        holder.setData(name, email_id, delete);

        holder.team_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mcontext,v);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate (R.menu.dashboard_manage_team_menu, popupMenu.getMenu());

                try {
                    Field[] fields = popupMenu.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(popupMenu);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId())
                        {
                            case R.id.edit:
                                replaceFragment(new DashboardManageEdit(),v);
                                break;
                            case R.id.remove:
                                ManageTeam temp= new ManageTeam(name,email_id,delete);
                                teamList.remove(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position,teamList.size());
                                int i;
                                for(i=0;i<teamListall.size();i++)
                                {
                                    if(((temp.getName()).equals(teamListall.get(i).getName()))&&((temp.getEmail_id()).equals(teamListall.get(i).getEmail_id())))
                                    {
                                        teamListall.remove(i);
                                        break;
                                    }
                                }

                        }
                        return false;
                    }
                });


            }
        });


    }

    private void replaceFragment(Fragment fragment,View view) {
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment ).addToBackStack(null).commit();
    }



    @Override
    public int getItemCount() {
        return teamList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter= new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<ManageTeam> filteredteamList = new ArrayList<>();
            teamList.clear();
            teamList.addAll(teamListall);

            if((charSequence.toString()).equals(""))
            {
                filteredteamList.addAll(teamListall);
            }
            else {
                int i;
                for (i = 0; i < ManageTeamList.getNumberOfTeam(); i++) {
                    String s = ManageTeamList.getTeamList().get(i).getName();
                    if ((s.toLowerCase()).contains((charSequence.toString()).toLowerCase())) {
                        filteredteamList.add(ManageTeamList.getTeamList().get(i));
                    }
                }
            }

            FilterResults  filterResults = new FilterResults();
            filterResults.values=filteredteamList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            teamList.clear();
            teamList.addAll((Collection<? extends ManageTeam>) filterResults.values);
            notifyDataSetChanged();

        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView team_name;
        private TextView team_email;
        private ImageView team_dot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            team_name = itemView.findViewById(R.id.team_name);
            team_email = itemView.findViewById(R.id.team_email);
            team_dot = itemView.findViewById(R.id.team_dot);
        }

        public void setData(String name, String email_id, int delete) {
            this.team_name.setText(name);
            this.team_email.setText(email_id);
            this.team_dot.setImageResource(delete);
        }
    }
}

