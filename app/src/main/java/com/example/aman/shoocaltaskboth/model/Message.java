package com.example.aman.shoocaltaskboth.model;

import java.io.Serializable;

public class Message implements Serializable {
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
