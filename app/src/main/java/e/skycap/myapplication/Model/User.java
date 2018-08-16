package e.skycap.myapplication.Model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;

public class User {

    @NonNull

    private String email,password;

    public User(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int isInputDataValid(){

           if(TextUtils.isEmpty(getEmail()))
           {
                return 0;
           }
           else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
           {
               return 1;
           }
           else if(TextUtils.isEmpty(getPassword()))
           {
               return 2;
           }
           else if(getPassword().length()<6)
           {
               return 3;
           }
           else {
               return -1;
           }


        }


    }
