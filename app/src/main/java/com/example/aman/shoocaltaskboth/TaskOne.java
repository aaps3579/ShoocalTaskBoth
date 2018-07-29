package com.example.aman.shoocaltaskboth;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.aman.shoocaltaskboth.model.Message;
import com.example.aman.shoocaltaskboth.model.MyResult;
import com.example.aman.shoocaltaskboth.model.RequestData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Response;

public class TaskOne extends AppCompatActivity {
    EditText et_first_name, et_last_name, et_phone, et_address, et_restaurant_name;
    Spinner sp_request_type;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);
        findViews();
    }

    RequestData makeRequest() {

        String first_name = et_first_name.getText().toString().trim();
        String last_name = et_last_name.getText().toString().trim();
        String phone = et_phone.getText().toString().trim();
        String address = et_address.getText().toString().trim();
        String restaurant_type = et_restaurant_name.getText().toString().trim();
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
        RequestData requestData = makeRequest();
        if (requestData == null) {
            Toast.makeText(this, "Please Fill All Fields!", Toast.LENGTH_SHORT).show();
        } else {
            MyNetworkTask myNetworkTask = new MyNetworkTask(requestData);
            myNetworkTask.execute();
        }

    }

    class MyNetworkTask extends AsyncTask<String, Integer, MyResult> {

        RequestData requestData;

        MyNetworkTask(RequestData requestData) {
            this.requestData = requestData;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(TaskOne.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected MyResult doInBackground(String... strings) {
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            String credentials = Credentials.basic("admin", "1234");
            Call<MyResult> responseCall = apiInterface.sendRequest(credentials, requestData);
            try {
                Response<MyResult> resultResponse = responseCall.execute();
                MyResult myResult = resultResponse.body();
                return myResult;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(MyResult myResult) {
            progressDialog.dismiss();
            if (myResult == null) {
                Toast.makeText(TaskOne.this, "Error Sending Request", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(TaskOne.this, "Request Sent With Success Status " + myResult.success, Toast.LENGTH_SHORT).show();
                Toast.makeText(TaskOne.this, myResult.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
