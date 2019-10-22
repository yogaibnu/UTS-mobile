package org.jplas.android.uts.util;

public class Biodata {
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private String nama;
    private int gender;
    private int umur;
    private float index;

    public Biodata(String nama, int gender, int umur) {
        this.nama = nama;
        this.gender = gender;
        this.umur = umur;
        this.index = resultGender();
    }

    public float getIndex() {
        return index;
    }

    private float resultGender() {
        switch (gender) {
            case MALE: return 3000000;
            case FEMALE: return 4000000;
            default: return 0;
        }
    }
}
