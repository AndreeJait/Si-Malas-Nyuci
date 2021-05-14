package student.kelompok_6.simalasnyuci.model;

import androidx.annotation.Nullable;

public class User {
    private int id;
    private String full_name;
    private String email;
    private String password;
    private String phone_number;
    @Nullable
    private String gender;
    @Nullable
    private String address;
    private String profile;
    private String status;
    private String role;

    public User(int id, String full_name, String email, String password, String phone_number, String gender, String address, String profile, String status, String role) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.gender = gender;
        this.address = address;
        this.profile = profile;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getProfile() {
        return profile;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
