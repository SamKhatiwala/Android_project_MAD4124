
package com.example.macstudent.c0696397_test1.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Albums implements Parcelable
{

    @SerializedName("albumId")
    @Expose
    private long albumId;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumbnailUrl")
    @Expose
    private String thumbnailUrl;
    public final static Creator<Albums> CREATOR = new Creator<Albums>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Albums createFromParcel(Parcel in) {
            Albums instance = new Albums();
            instance.albumId = ((long) in.readValue((long.class.getClassLoader())));
            instance.id = ((long) in.readValue((long.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbnailUrl = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Albums[] newArray(int size) {
            return (new Albums[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Albums() {
    }

    /**
     * 
     * @param id
     * @param title
     * @param albumId
     * @param thumbnailUrl
     * @param url
     */
    public Albums(long albumId, long id, String title, String url, String thumbnailUrl) {
        super();
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(albumId);
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(url);
        dest.writeValue(thumbnailUrl);
    }

    public int describeContents() {
        return  0;
    }

}
