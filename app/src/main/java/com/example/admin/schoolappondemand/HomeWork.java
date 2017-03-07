package com.example.admin.schoolappondemand;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;

public class HomeWork extends AppCompatActivity {

    TextView tv1;

    RecyclerView recyclerView;

    RequestQueue requestQueue;

    HorizontalCalendar horizontalCalendar;

    ArrayList<HomeWorkModel> Al=new ArrayList<>();

    int date;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work);
        requestQueue= Volley.newRequestQueue(this);

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

/** start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        horizontalCalendar  = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .datesNumberOnScreen(5)   // Number of Dates cells shown on screen (Recommended 5)
                .dayFormat("EEE")     // WeekDay text format
                .dayNumberFormat("dd")  // Date format
                .textColor(Color.LTGRAY, Color.WHITE)    // Text color for none selected Dates, Text color for selected Date.
                .selectedDateBackground(Color.TRANSPARENT)  // Background color of the selected date cell.
                .selectorColor(Color.RED)   // Color of the selection indicator bar (default to colorAccent).
                .build();

        JsonArrayRequest jsn=new JsonArrayRequest("http://203.124.96.117:8063/Service1.asmx/HomeWorkAssignment", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                for(int i=0;i<jsonArray.length();i++){

                    try {
                        JSONObject object= (JSONObject) jsonArray.get(0);

                        int sdt=object.getInt("AssignDate");

                        


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(HomeWork.this, "" + volleyError, Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue=Volley.newRequestQueue(this);






        HomeWorkModel hmodel=new HomeWorkModel();
        hmodel.sethDate("Date");
        hmodel.setHday("Day");
        hmodel.setHlesson("Lesson 1");
        hmodel.setHchapter("Computer");
        hmodel.setImage(R.drawable.book1);
        Al.add(hmodel);

        HomeWorkModel hmodel1=new HomeWorkModel();
        hmodel1.sethDate("Date");
        hmodel1.setHday("Day");
        hmodel1.setHlesson("Lesson 2");
        hmodel1.setHchapter("Computer");
        hmodel1.setImage(R.drawable.book1);
        Al.add(hmodel1);

        HomeWorkModel hmodel2=new HomeWorkModel();
        hmodel2.sethDate("Date");
        hmodel2.setHday("Day");
        hmodel2.setHlesson("Lesson 3");
        hmodel2.setHchapter("Computer");
        hmodel2.setImage(R.drawable.book1);
        Al.add(hmodel2);

        HomeWorkModel hmodel3=new HomeWorkModel();
        hmodel3.sethDate("Date");
        hmodel3.setHday("Day");
        hmodel3.setHlesson("Lesson 2");
        hmodel3.setHchapter("Computer");
        hmodel3.setImage(R.drawable.book1);
        Al.add(hmodel3);

        HomeWorkModel hmodel4=new HomeWorkModel();
        hmodel4.sethDate("Date");
        hmodel4.setHday("Day");
        hmodel4.setHlesson("Lesson 3");
        hmodel4.setHchapter("Computer");
        hmodel4.setImage(R.drawable.book1);
        Al.add(hmodel4);

        recyclerView= (RecyclerView) findViewById(R.id.rv_hmrk);

        HomeHrkAdapter obj=new HomeHrkAdapter(this,R.layout.homework_card,Al);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(obj);




        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        tv1= (TextView) findViewById(R.id.profile_tv);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back_btn);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv1.setText("Home Work");
    }
}


