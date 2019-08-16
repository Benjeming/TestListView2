package domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class NewsTitle implements Serializable {
    private String title;

    public NewsTitle() {
    }

    public NewsTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
