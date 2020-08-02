package com.example.jokesgenerator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JokeModel {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("value")
    @Expose
    private ArrayList<Value> value = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Value> getValue() {
        return value;
    }

    public void setValue(ArrayList<Value> value) {
        this.value = value;
    }

    public class Value {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("joke")
        @Expose
        private String joke;
        @SerializedName("categories")
        @Expose
        private ArrayList<Object> categories = new ArrayList<>();

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public ArrayList<Object> getCategories() {
            return categories;
        }

        public void setCategories(ArrayList<Object> categories) {
            this.categories = categories;
        }
    }
}

