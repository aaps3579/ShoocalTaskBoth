package com.example.aman.shoocaltaskboth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aman.shoocaltaskboth.model.MyResult;
import com.example.aman.shoocaltaskboth.model.RequestData;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Response;

public class TaskOne extends AppCompatActivity {
    EditText et_first_name, et_last_name, et_phone, et_address, et_restaurant_name;
    Spinner sp_request_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        findViews();
    }

    RequestData makeRequest() {

        String first_name = et_first_name.getText().toString();
        String last_name = et_last_name.getText().toString();
        String phone = et_phone.getText().toString();
        String address = et_address.getText().toString();
        String restaurant_type = et_restaurant_name.getText().toString();
        String selectedType = (String) sp_request_type.getSelectedItem();
        int type = 0;
        if (selectedType.equalsIgnoreCase("owner"))
            type = 1;
        else if (selectedType.equalsIgnoreCase("manager"))
            type = 2;
        else
            type = 3;
        if (first_name.equals("") || last_name.equals("") || phone.equals("") || address.equals("") || restaurant_type.equals("")) {
            return null;
        } else {
            return new RequestData(first_name, last_name, phone, address, restaurant_type, type);
        }
    }


    void findViews() {
        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_address = (EditText) findViewById(R.id.et_address);
        et_restaurant_name = (EditText) findViewById(R.id.et_restaurant_name);
        sp_request_type = (Spinner) findViewById(R.id.sp_request_type);
    }

    //button listener
    public void sendPostReq(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestData requestData = makeRequest();
                if (requestData == null) {
                    Toast.makeText(TaskOne.this, "Please Fill All Details", Toast.LENGTH_SHORT).show();
                } else {
                    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                    String credentials = Credentials.basic("admin", "1234");
                    Call<MyResult> responseCall = apiInterface.sendRequest(credentials, requestData);
                    try {
                        Response<MyResult> resultResponse = responseCall.execute();
                        MyResult myResult = resultResponse.body();

                        Log.d("TAG", " Response " + responseCall.isExecuted() + "  Result = " + resultResponse.isSuccessful()+" "+resultResponse.message());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }
}
