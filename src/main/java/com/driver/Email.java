package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }


    public boolean check(String s){
        boolean u = false;
        boolean l = false;
        boolean d = false;
        boolean spe = false;
        String special = "[!@#$%&*()_+=|<>?{}\\[\\]~-]";

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                d=true;
            }
            if(Character.isUpperCase(ch)){
                u=true;
            }
            if(Character.isLowerCase(ch)){
                l=true;
            }
            if(special.contains("" + ch)){
                spe = true;
            }
        }

        if(u && l && d && spe && s.length()>=8){
            return true;
        }
        else{
            return  false;
        }

    }
    public void changePassword(String oldPassword, String newPassword){
        if(this.password==oldPassword){
            if(check(newPassword)){
                this.password = newPassword;
            }
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}
