package com.example.picture.models;

public class Picture {
    public long id;
    public byte[] urlImage;

    public Picture(long id, byte[] urlImage) {
        this.id = id;
        this.urlImage = urlImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(byte[] urlImage) {
        this.urlImage = urlImage;
    }
}
