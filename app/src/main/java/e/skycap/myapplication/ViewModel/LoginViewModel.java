package e.skycap.myapplication.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import e.skycap.myapplication.BR;
import e.skycap.myapplication.Model.User;
import e.skycap.myapplication.View.MainActivity;
import e.skycap.myapplication.View.PostListActivity;


public class LoginViewModel extends BaseObservable{

    private User user;

private String successMessage = "Login was successful";

private String errorMessageemail = "Email not valid";
private String errorMessagepassword = "password length must be greater than 6 character";
private String errorMessagblankeemail = "Enter the Email ";
private String errorMessageblankpassword = "Email the Password";


    Context con;

    public LoginViewModel(Context context){
        user=new User("","");
        this.con = context;
    }



    @Bindable
public String toastMessage = null;

    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);

    }



public void afterEmailTextChanged(CharSequence s){
       user.setEmail(s.toString());
}

public void afterPasswordTextChanged(CharSequence s){
    user.setPassword(s.toString());
}


public void onLoginClicked(){
int errorcode=user.isInputDataValid();

        if(errorcode==0)
        {
            setToastMessage(errorMessagblankeemail);
        }
        else  if(errorcode==1)
        {
            setToastMessage(errorMessageemail);
        }
       else if(errorcode==2)
        {
            setToastMessage(errorMessageblankpassword);
        }

        else if(errorcode==3)
        {
            setToastMessage(errorMessagepassword);
        }
        else{
            setToastMessage(successMessage);

            Intent login = new Intent(con, PostListActivity.class);
            con.startActivity(login);
        }
}


}
