package com.elbbbird.android.core.servicemanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhanghailong-ms on 2015/3/20.
 */
public class ParcelBinder implements Parcelable {

    private IBinder binder;

    public ParcelBinder(IBinder binder) {
        this.binder = binder;
    }

    private ParcelBinder(Parcel parcel) {
        readFromParcel(parcel);
    }

    public IBinder getBinder() {
        return binder;
    }

    public void setBinder(IBinder binder) {
        this.binder = binder;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(binder);
    }

    public static final Creator<ParcelBinder> CREATOR = new Creator<ParcelBinder>() {
        @Override
        public ParcelBinder createFromParcel(Parcel source) {
            return new ParcelBinder(source);
        }

        @Override
        public ParcelBinder[] newArray(int size) {
            return new ParcelBinder[size];
        }
    };

    private void readFromParcel(Parcel parcel) {
        this.binder = parcel.readStrongBinder();
    }
}
