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
import com.ziroh.legalvault.datastorage.Settings;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder>{
    private List<Settings> settingsList;

    public SettingsAdapter(List<Settings> settingsList) {
        this.settingsList = settingsList;
    }

    @NonNull
    @Override
    public SettingsAdapter.SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_super_admin, parent, false);
        return new SettingsAdapter.SettingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsAdapter.SettingsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        int person = settingsList.get(position).getSettingsPersonImage();
        String settingsName = settingsList.get(position).getSettingsName();
        String settingsPosition = settingsList.get(position).getSettingsEmail();
        int delete = settingsList.get(position).getSettingsDeleteImage();

        holder.setData(person, settingsName, settingsPosition, delete);

        holder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,settingsList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return settingsList.size();
    }

    public class SettingsViewHolder extends RecyclerView.ViewHolder {

        private ImageView personImg;
        private TextView name;
        private TextView position;
        private ImageView deleteImg;

        public SettingsViewHolder(@NonNull View itemView) {
            super(itemView);
            personImg = itemView.findViewById(R.id.settings_person_img);
            name = itemView.findViewById(R.id.settings_name);
            position = itemView.findViewById(R.id.settings_position);
            deleteImg = itemView.findViewById(R.id.settings_delete_img);
        }

        public void setData(int person, String settingsName, String settingsPosition, int delete) {
            personImg.setImageResource(person);
            name.setText(settingsName);
            position.setText(settingsPosition);
            deleteImg.setImageResource(delete);
        }
    }
}
