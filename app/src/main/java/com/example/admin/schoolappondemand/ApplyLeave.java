package com.example.admin.schoolappondemand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

public class ApplyLeave extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5;
    Button btn1;

    RequestQueue requestQueue;

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_leave);

       requestQueue= Volley.newRequestQueue(ApplyLeave.this);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);
        e1= (EditText) findViewById(R.id.et_leave_sname);
        e2= (EditText) findViewById(R.id.et_leave_cls_name);
        e3= (EditText) findViewById(R.id.et_leave_roll);
        e4= (EditText) findViewById(R.id.et_leave_date);
        e5= (EditText) findViewById(R.id.et_leave_reason);
        btn1= (Button) findViewById(R.id.btn_apply_leave);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=e1.getText().toString();
                String sclass=e2.getText().toString();
                String roll=e3.getText().toString();
                String leave=e4.getText().toString();
                String reason=e5.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, "url", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        return super.getParams();
                    }
                };
                requestQueue.add(stringRequest);
            }



        }
        );





        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.imagecircle);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv1.setText("Apply leave");
    }

}
