package project.assessment.pheramor.com.assesment_project;

import android.net.Uri;

import java.io.Serializable;
import java.util.Date;

public class RegisterUser implements Serializable {
    String email;
    String password;
    String first_name;
    String last_name;
    String ZipCode;
    String height;
    String Gender;
    Date dob;
    String Interests;
    String from_age;
    String to_age;
    String race;
    String ethinicity;
    Uri photo_id;




    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String passwrord){
        this.password = passwrord;
    }

    public void setFirstName(String firstName){
        this.first_name = firstName;
    }

    public void setLastName(String lastName){
        this.last_name = lastName;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }

    public void setFrom_age(String from_age) {
        this.from_age = from_age;
    }

    public void setTo_age(String to_age) {
        this.to_age = to_age;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
    }

    public void setPhoto_id(Uri photo_id) {
        this.photo_id = photo_id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName(){
        return first_name+" "+last_name;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getGender() {
        return Gender;
    }

    public String getHeight() {
        return height;
    }

    public Date getDob() {
        return dob;
    }

    public String getInterests() {
        return Interests;
    }

    public String getFrom_age() {
        return from_age;
    }

    public String getTo_age() {
        return to_age;
    }

    public String getRace() {
        return race;
    }

    public String getEthinicity() {
        return ethinicity;
    }

    public Uri getPhoto_id() {
        return photo_id;
    }
}
