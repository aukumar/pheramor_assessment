package project.assessment.pheramor.com.assesment_project;

import java.io.Serializable;

public class RegisterUser implements Serializable {
    String email;
    String password;
    String first_name;
    String last_name;



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

    public String getEmail() {
        return email;
    }

    public String getName(){
        return first_name+" "+last_name;
    }
}
