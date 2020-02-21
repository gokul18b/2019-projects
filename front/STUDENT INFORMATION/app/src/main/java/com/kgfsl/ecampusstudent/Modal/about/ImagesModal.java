package com.kgfsl.ecampusstudent.Modal.about;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by manivasagam on 08-11-2017.
 */

public class ImagesModal implements Parcelable {

    private int id;
    private String name;
    private String imageUrl;

    public ImagesModal() {
        super();
    }

    private ImagesModal(Parcel in) {
        super();
        this.id = in.readInt();
        this.name = in.readString();
        this.imageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getId());
        parcel.writeString(getName());
        parcel.writeString(getImageUrl());
    }

    public static final Parcelable.Creator<ImagesModal> CREATOR = new Parcelable.Creator<ImagesModal>() {
        public ImagesModal createFromParcel(Parcel in) {
            return new ImagesModal(in);
        }

        public ImagesModal[] newArray(int size) {
            return new ImagesModal[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static Parcelable.Creator<ImagesModal> getCreator() {
        return CREATOR;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImagesModal other = (ImagesModal) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", imageUrl="
                + imageUrl + "]";
    }
}