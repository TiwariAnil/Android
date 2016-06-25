package com.yourpanache.crmpanache.cController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.yourpanache.crmpanache.SelectServiceActivity;
import com.yourpanache.crmpanache.aModel.Helper;
import com.yourpanache.crmpanache.bCommunicator.CustomerCheckCommunicator;
import com.yourpanache.crmpanache.dView.CustomerAddActivity;


/**
 * Created by user on 24-Jun-16.
 */
public class CustomerCheckController implements CommunicatorHandler {

    Context mContext;
    Toast toastMessage;
    CustomerCheckCommunicator CustCheckCom;


    //Constrcutor
    public CustomerCheckController(Context context) {

        this.mContext = context;
        toastMessage = Toast.makeText(mContext.getApplicationContext(), "", Toast.LENGTH_LONG);

        //Initailise the communicator
        CustCheckCom = new CustomerCheckCommunicator();
        CustCheckCom.addResponseListener(this);
        CustCheckCom.addErrorListener(this);
    }

    public void CustomerCheckControl(String userMobile){

        //Form the url
        String url = Helper.serverIp + Helper.checkUserRoute;
        CustCheckCom.GetRequest(url, userMobile);
    }

    @Override
    public void responseHandler(String response) {
        try {
            //Do your response handling here
            if (response.contains("True")) {
                toastMessage.setText("Response is: " + response);

                //Go to next activity
                //Should this be herE???
                Intent i = new Intent(mContext, SelectServiceActivity.class);
                mContext.startActivity(i);

            } else {
                toastMessage.setText("It's a new User!");


                CustomerAddActivity.addUserToServer();

                nameUser.setVisibility(View.VISIBLE);
                genderUser.setVisibility(View.VISIBLE);
                emailUser.setVisibility(View.VISIBLE);

                //Set the flag
//                Helper.userStatusFlag = 1;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
            toastMessage.setText("Some Exception occurred in CustomerCheckController");
        }
        //Show th toast
        toastMessage.show();
    }

    @Override
    public void errorHandler() {
        //Do your error handling here
        toastMessage.setText("That didn't work in CustomerCheckController !");
        toastMessage.show();
    }
}
