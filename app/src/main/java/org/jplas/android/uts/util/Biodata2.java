package org.jplas.android.uts.util;

import android.os.Parcel;
import android.os.Parcelable;

public class Biodata2 implements Parcelable {
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private String nama;
    private int gender;
    private int umur;
    private float index;

    public Biodata2(String nama, int gender, int umur) {
        this.nama = nama;
        this.gender = gender;
        this.umur = umur;
        this.index = biodata();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public float getIndex() {
        return index;
    }

    public void setIndex(float index) {
        this.index = index;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeInt(this.gender);
        dest.writeInt(this.umur);
        dest.writeFloat(this.index);
    }

    protected Biodata2(Parcel in) {
        this.nama = in.readString();
        this.gender = in.readInt();
        this.umur = in.readInt();
        this.index = in.readFloat();
    }

    public static final Parcelable.Creator<Biodata2> CREATOR = new Parcelable.Creator<Biodata2>() {
        @Override
        public Biodata2 createFromParcel(Parcel source) {
            return new Biodata2(source);
        }

        @Override
        public Biodata2[] newArray(int size) {
            return new Biodata2[size];
        }
    };

    private int biodata(){
        switch (gender){
            case MALE: return 3000000;
            case FEMALE: return 4000000;
            default: return 0;
        }
    }
}
