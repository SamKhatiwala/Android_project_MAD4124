
package com.example.macstudent.c0696397_test1.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comments implements Parcelable
{

    @SerializedName("postId")
    @Expose
    private long postId;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("body")
    @Expose
    private String body;
    public final static Creator<Comments> CREATOR = new Creator<Comments>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Comments createFromParcel(Parcel in) {
            Comments instance = new Comments();
            instance.postId = ((long) in.readValue((long.class.getClassLoader())));
            instance.id = ((long) in.readValue((long.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.email = ((String) in.readValue((String.class.getClassLoader())));
            instance.body = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Comments[] newArray(int size) {
            return (new Comments[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Comments() {
    }

    /**
     * 
     * @param id
     * @param body
     * @param email
     * @param name
     * @param postId
     */
    public Comments(long postId, long id, String name, String email, String body) {
        super();
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(postId);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(body);
    }

    public int describeContents() {
        return  0;
    }

}
