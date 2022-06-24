package com.example.application;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Model {
    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public ResultModel getResult() {
        return result;
    }

    public void setResult(ResultModel result) {
        this.result = result;
    }

    @SerializedName("response")
    Integer response;

    @SerializedName("result")
    ResultModel result;



 public class ResultModel{
     public String getTotal() {
         return total;
     }

     public void setTotal(String total) {
         this.total = total;
     }

     public ArrayList<Contents> getContents() {
         return contents;
     }

     public void setContents(ArrayList<Contents> contents) {
         this.contents = contents;
     }

     @SerializedName("total")
    String total;

    @SerializedName("contents")
    ArrayList<Contents> contents;

}

public class Contents{
    @SerializedName("id")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("name")
    String name;

}


}
