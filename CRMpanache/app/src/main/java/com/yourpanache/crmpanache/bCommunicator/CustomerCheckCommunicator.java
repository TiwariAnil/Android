package com.yourpanache.crmpanache.bCommunicator;

import android.content.Intent;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yourpanache.crmpanache.ApplicationClass;
import com.yourpanache.crmpanache.SelectServiceActivity;
import com.yourpanache.crmpanache.cController.CommunicatorHandler;
import com.yourpanache.crmpanache.dView.CustomerAddActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24-Jun-16.
 */
public class CustomerCheckCommunicator {

    private List<CommunicatorHandler> responseListeners = new ArrayList<CommunicatorHandler>();
    private List<CommunicatorHandler> errorListeners = new ArrayList<CommunicatorHandler>();

    public void addResponseListener(CommunicatorHandler commHandler) {

        responseListeners.add(commHandler);
    }


    public void addErrorListener(CommunicatorHandler commHandler) {

        errorListeners.add(commHandler);
    }

    public void GetRequest(String url, String customerMobile){

        RequestQueue queue = Volley.newRequestQueue(ApplicationClass.getContext());
//        StringRequest req = new StringRequest(Request.Method.GET, "http://164.99.140.98:8080/isUser/" + customerMobile, new Response.Listener<String>() {
        StringRequest req = new StringRequest(Request.Method.GET, url + customerMobile, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
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
        });
        queue.add(req);

    }
}
