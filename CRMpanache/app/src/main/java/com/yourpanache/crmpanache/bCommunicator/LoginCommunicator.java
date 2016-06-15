package com.yourpanache.crmpanache.bCommunicator;

import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yourpanache.crmpanache.ApplicationClass;
import com.yourpanache.crmpanache.HomeActivity;
import com.yourpanache.crmpanache.cController.CommunicatorHandler;
import com.yourpanache.crmpanache.cController.LoginController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14-Jun-16.
 */
public class LoginCommunicator {


    private List<CommunicatorHandler> responseListeners = new ArrayList<CommunicatorHandler>();
    private List<CommunicatorHandler> errorListeners = new ArrayList<CommunicatorHandler>();

    public void addResponseListener(CommunicatorHandler commHandler) {

        responseListeners.add(commHandler);
    }


    public void addErrorListener(CommunicatorHandler commHandler) {

        errorListeners.add(commHandler);
    }


    //post request handler
    public void PostRequest(String url, final String jsonData) {

        RequestQueue queue = Volley.newRequestQueue(ApplicationClass.getContext());

//            StringRequest req = new StringRequest(Request.Method.POST, "http://164.99.140.98:8080/login", new Response.Listener<String>() {
//            StringRequest req = new StringRequest(Request.Method.POST, "http://192.168.1.6:8080/login", new Response.Listener<String>() {
        StringRequest req = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                for (CommunicatorHandler commHandler : responseListeners) {
                    commHandler.responseHandler(response);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                for (CommunicatorHandler commHandler : responseListeners) {
                    commHandler.errorHandler();
                }

            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                return jsonData.getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        queue.add(req);
    }
}
