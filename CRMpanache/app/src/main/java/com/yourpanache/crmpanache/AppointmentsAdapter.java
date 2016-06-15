package com.yourpanache.crmpanache;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yourpanache.crmpanache.aModel.Appointment;

import java.util.List;

/**
 * Created by user on 11-Jun-16.
 */
public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.MyViewHolder>{

    private List<Appointment> appointmentList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView userName, serviceId, finalPrice;
        RelativeLayout appointmentListItemLayout;

        public MyViewHolder(View view){
            super(view);
            userName = (TextView) view.findViewById(R.id.userName);
            serviceId = (TextView) view.findViewById(R.id.serviceId);
            finalPrice = (TextView) view.findViewById(R.id.finalPrice);
            appointmentListItemLayout = (RelativeLayout) view.findViewById(R.id.appointment_list_item);
        }
    }

    public AppointmentsAdapter(Context ctx, List<Appointment> appointmentList) {
        this.mContext = ctx;
        this.appointmentList = appointmentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointment_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final Appointment appointment = appointmentList.get(position);

        holder.appointmentListItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, appointment.getUserName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.userName.setText(appointment.getUserName());
        holder.serviceId.setText(appointment.getServiceId());
        holder.finalPrice.setText(appointment.getFinalPrice());
    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

}
