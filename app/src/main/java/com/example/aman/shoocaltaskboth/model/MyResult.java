package com.example.aman.shoocaltaskboth.model;

import java.io.Serializable;
import java.util.List;

public class MyResult implements Serializable {
    public boolean success;
    public boolean error;
    public List<Message> message;

    public MyResult(boolean success, boolean error, List<Message> message) {
        this.success = success;
        this.error = error;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        String result = "";
        for (Message m : message) {
            result += "Status = " + m.getStatus() + " \n Message = " + m.getMessage() + "\n";
        }
        return "Success " + success + " , Error =" + error + " Message List = " + result;
    }
}
