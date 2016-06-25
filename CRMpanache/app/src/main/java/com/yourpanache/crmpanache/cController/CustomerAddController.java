package com.yourpanache.crmpanache.cController;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yourpanache.crmpanache.SelectServiceActivity;
import com.yourpanache.crmpanache.aModel.Helper;
import com.yourpanache.crmpanache.aModel.USER;
import com.yourpanache.crmpanache.bCommunicator.CustomerAddCommunicator;
import com.yourpanache.crmpanache.bCommunicator.CustomerCheckCommunicator;

/**
 * Created by user on 24-Jun-16.
 */
public class CustomerAddController implements CommunicatorHandler {

    Context mContext;
    Toast toastMessage;
    CustomerAddCommunicator CustAddCom;

    public CustomerAddController(Context context){

        this.mContext = context;
        this.toastMessage = Toast.makeText(mContext.getApplicationContext(), "", Toast.LENGTH_LONG);

        //Initailise the communicator
        this.CustAddCom = new CustomerAddCommunicator();
        this.CustAddCom.addResponseListener(this);
        this.CustAddCom.addErrorListener(this);

    }

    public void CustomerAddControl(String customerMobile, String customerName, String customerGender, String customerEmail){

        USER user = new USER(customerMobile, customerName, customerGender, customerEmail);
        Gson gson = new Gson();
        final String jsonInString = gson.toJson(user);
        //Form the url
        String url = Helper.serverIp + Helper.checkUserRoute;
        CustAddCom.PostRequest(url, jsonInString);
    }

    @Override
    public void responseHandler(String response) {
        try {
            if (response.contains("True")) {
                toastMessage.setText("User added! : " + response);
                Intent i = new Intent(mContext, SelectServiceActivity.class);
                mContext.startActivity(i);
            } else {
                toastMessage.setText("User addition didn't work!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            toastMessage.setText("Some Exception occurred in CustomerAddController");
        }
        //Show the toastmessage
        toastMessage.show();
    }

    @Override
    public void errorHandler() {
        //Do your error handling here
        toastMessage.setText("That didn't work in CustomerAddController !");
        toastMessage.show();
    }
}
