package com.yourpanache.crmpanache.cController;

/**
 * Created by user on 15-Jun-16.
 */
public interface CommunicatorHandler {

    //Method to handle response from the server call
    void responseHandler(String response);

    //Method to handle the error response from the server call
    void errorHandler();

}
