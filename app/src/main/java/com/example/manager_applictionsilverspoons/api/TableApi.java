package com.example.manager_applictionsilverspoons.api;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.manager_applictionsilverspoons.fragment.TableBookingFragment;
import com.example.manager_applictionsilverspoons.R;
import com.example.manager_applictionsilverspoons.model.TableOutputModel;
import com.example.manager_applictionsilverspoons.util.ConstantData;
import com.google.gson.Gson;

public class TableApi {


    public void  table(TableBookingFragment activity){
        Dialog pd = new Dialog(activity.getContext());
        pd.setContentView(R.layout.custom_dialog);
        pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        pd.setCancelable(false);
        pd.show();
        RequestQueue requestQueue= Volley.newRequestQueue(activity.getContext());
        String url= ConstantData.SERVERADDRESS+ ConstantData.TABLE_BOOKINGURL;

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        pd.dismiss();
                        Gson gson = new Gson();
                        TableOutputModel model=gson.fromJson(response,TableOutputModel.class);
                        ((TableBookingFragment)activity).setTableBooking(model);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
              Toast.makeText(activity.getContext(), "Error:"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        requestQueue.add(stringRequest);

    }
}
