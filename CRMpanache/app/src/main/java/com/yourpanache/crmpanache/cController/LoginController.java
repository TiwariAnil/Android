package com.yourpanache.crmpanache.cController;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yourpanache.crmpanache.HomeActivity;
import com.yourpanache.crmpanache.aModel.Helper;
import com.yourpanache.crmpanache.aModel.SALON;
import com.yourpanache.crmpanache.bCommunicator.LoginCommunicator;

/**
 * Created by user on 14-Jun-16.
 */
public class LoginController implements CommunicatorHandler {

    Context mContext;
    Toast toastMessage;
    LoginCommunicator loginCom;

    //Constrcutor
    public LoginController(Context context) {

        this.mContext = context;
        toastMessage = Toast.makeText(mContext.getApplicationContext(), "", Toast.LENGTH_LONG);

        //Initailise the communicator
        loginCom = new LoginCommunicator();
        loginCom.addResponseListener(this);
        loginCom.addErrorListener(this);
    }


    public void LoginControl(String username, String password){

        SALON obj = new SALON(username, password);
        Gson gson = new Gson();
        String jsonInString = gson.toJson(obj);

        //Form the url
        String url = Helper.serverIp + Helper.loginRoute;
        loginCom.PostRequest(url, jsonInString);

        //LoginCommunicate(jsonInString);

    }

    public void errorHandler() {

        //Do your error handling here
        toastMessage.setText("That didn't work!");
        toastMessage.show();
    }


    public void responseHandler(String response) {

        try {
            //Do your response handling here
            if (response.contains("True")) {

                toastMessage.setText("Response is: " + response);

                //Go to next activity
                //Should this be herE???
                Intent i = new Intent(mContext, HomeActivity.class);
                mContext.startActivity(i);

            } else {
                toastMessage.setText("Username/Password is invalid!");
            }
        }
        catch(Exception ex) {

            ex.printStackTrace();
            toastMessage.setText("Some unknown error occurred");
        }

        //Show th toast
        toastMessage.show();
    }
}
