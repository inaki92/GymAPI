package com.example.gymapi.Model.Workout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class workouts {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("creation_date")
    @Expose
    private String creationDate;
    @SerializedName("comment")
    @Expose
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
