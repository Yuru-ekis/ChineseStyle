package me.yuruekis.chinesestyle;

public class Photos {
    private String name;

    private String photosImgURL;

    public Photos(String name, String photosImgURL) {
        this.name = name;
        this.photosImgURL = photosImgURL;
    }

    public String getName() {
        return name;
    }

    public String getPhotosImgURL() {
        return photosImgURL;
    }
}
