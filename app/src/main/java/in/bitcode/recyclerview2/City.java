package in.bitcode.recyclerview2;

import java.io.Serializable;

public class City implements Serializable {
    private String mName;
    private long mPopulation;
    private int mImageId;

    public static final String KEY_CITY = "city";

    public City(String name, long population, int imageId) {
        this.mName = name;
        this.mPopulation = population;
        this.mImageId = imageId;
    }

    public String getName() {
        return mName;
    }

    public long getPopulation() {
       return mPopulation;
    }

    public int getImageId() {
        return mImageId;
    }
}
