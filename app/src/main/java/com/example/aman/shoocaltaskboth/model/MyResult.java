package com.example.aman.shoocaltaskboth.model;

import java.util.List;

class Message {
    public int Status;
    public String Message;

    public Message(int status, String message) {
        Status = status;
        Message = message;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}

public class MyResult {
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
}
