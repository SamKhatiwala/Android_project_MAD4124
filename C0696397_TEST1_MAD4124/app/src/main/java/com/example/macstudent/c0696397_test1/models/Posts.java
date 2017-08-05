
package com.example.macstudent.c0696397_test1.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts implements Parcelable
{

    @SerializedName("userId")
    @Expose
    private long userId;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body")
    @Expose
    private String body;
    public final static Creator<Posts> CREATOR = new Creator<Posts>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Posts createFromParcel(Parcel in) {
            Posts instance = new Posts();
            instance.userId = ((long) in.readValue((long.class.getClassLoader())));
            instance.id = ((long) in.readValue((long.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.body = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Posts[] newArray(int size) {
            return (new Posts[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Posts() {
    }

    /**
     * 
     * @param id
     * @param body
     * @param title
     * @param userId
     */
    public Posts(long userId, long id, String title, String body) {
        super();
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(body);
    }

    public int describeContents() {
        return  0;
    }

}
