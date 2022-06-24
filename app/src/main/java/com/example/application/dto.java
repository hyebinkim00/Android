package com.example.application;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class dto {

    @SerializedName("result")
    Integer result;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @SerializedName("response")
    respone respone;




    public respone getRespone() {
        return respone;
    }

    public void setRespone(dto.respone respone) {
        this.respone = respone;
    }

    public class respone{
        @SerializedName("name")
        String name;

        @SerializedName("type")
        List<Integer> type;

        public List<Integer> getType() {
            return type;
        }

        public void setType(List<Integer> type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
