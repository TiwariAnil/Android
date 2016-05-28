package com.yourpanache.crmpanache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SelectServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_service);

        /*
        Pull all the services from the server, ONCE! And store locally on DB,
        Or Each day do it once.

        if( DB do  not has the services or outdated,  )
            Update them and store them
        else
            carry on.
         */

        /*
        Service_list Selected
         */

        /*
        Offer apply, & checkout!

        Hell lot of complexity here!
         */

        /*
        Feedback Page. After feed back CustomerAddActivity
         */

    }
}
