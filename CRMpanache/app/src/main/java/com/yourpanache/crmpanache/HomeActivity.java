package com.yourpanache.crmpanache;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.yourpanache.crmpanache.aModel.Appointment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private List<Appointment> appointmentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AppointmentsAdapter aAdapter;
    private Button newCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.appointment_activity_main);
        setContentView(R.layout.home_activity);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        aAdapter = new AppointmentsAdapter(HomeActivity.this, appointmentList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);

        prepareAppointmentData();

        try {

            FloatingActionButton newCustomer = (FloatingActionButton) findViewById(R.id.add_button);
            newCustomer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(HomeActivity.this, CustomerAddActivity.class);
//                    Intent i = new Intent(HomeActivity.this, CustomerAddActivity.class);
                    startActivity(i);
//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                }
            });
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void prepareAppointmentData() {
        Appointment appointment = new Appointment("Priyansh", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Pandey", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Maidam", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Pandey", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Maidam", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Pandey", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Maidam", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Pandey", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Maidam", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Pandey", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Maidam", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Pandey", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        appointment = new Appointment("Maidam", "SERVICEID", "2015.00");
        appointmentList.add(appointment);

        aAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private HomeActivity.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final HomeActivity.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }

    /*

    */
}
