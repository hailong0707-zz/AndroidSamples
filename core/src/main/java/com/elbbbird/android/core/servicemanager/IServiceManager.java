package com.elbbbird.android.core.servicemanager;

public interface IServiceManager extends android.os.IInterface {
    public android.os.IBinder getService(java.lang.String name) throws android.os.RemoteException;

    public android.os.IBinder checkService(java.lang.String name) throws android.os.RemoteException;

    public void addService(java.lang.String name, android.os.IBinder service) throws android.os.RemoteException;

    public void removeService(java.lang.String name) throws android.os.RemoteException;

    public java.lang.String[] listServices() throws android.os.RemoteException;
}
