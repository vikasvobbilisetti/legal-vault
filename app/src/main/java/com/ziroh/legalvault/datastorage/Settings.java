package com.ziroh.legalvault.datastorage;

public class Settings {
    private int settingsPersonImage;
    private String settingsName;
    private String settingsEmail;
    private int settingsDeleteImage;

    public Settings(int personImage, String name, String email, int deleteImage) {
        this.settingsName = name;
        this.settingsEmail = email;
        this.settingsPersonImage = personImage;
        this.settingsDeleteImage = deleteImage;
    }

    public String getSettingsName() {
        return settingsName;
    }

    public void setSettingsName(String name) {
        this.settingsName = name;
    }

    public String getSettingsEmail() {
        return settingsEmail;
    }

    public void setSettingsEmail(String email) {
        this.settingsEmail = email;
    }

    public int getSettingsPersonImage() {
        return settingsPersonImage;
    }

    public void setSettingsPersonImage(int settingsPersonImage) {
        this.settingsPersonImage = settingsPersonImage;
    }

    public int getSettingsDeleteImage() {
        return settingsDeleteImage;
    }

    public void setSettingsDeleteImage(int settingsDeleteImage) {
        this.settingsDeleteImage = settingsDeleteImage;
    }
}
