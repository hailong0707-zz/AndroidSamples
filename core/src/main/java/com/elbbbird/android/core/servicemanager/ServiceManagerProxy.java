package com.elbbbird.android.core.servicemanager;

import android.os.IBinder;

public class ServiceManagerProxy implements IServiceManager {

    public static final String DESCRIPTOR = "com.elbbbird.android.core.servicemanager.IServiceManager";

    private android.os.IBinder mRemote;

    ServiceManagerProxy(android.os.IBinder remote) {
        mRemote = remote;
    }

    /**
     * Cast an IBinder object into an
     * com.roobo.coreserver.modules.servicemanager.IRooboServiceManager
     * interface, generating a proxy if needed.
     */
    public static IServiceManager asInterface(IBinder obj) {
        if ((obj == null)) {
            return null;
        }
        android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (((iin != null) && (iin instanceof IServiceManager))) {
            return ((IServiceManager) iin);
        }
        return new ServiceManagerProxy(obj);
    }

    @Override
    public android.os.IBinder asBinder() {
        return mRemote;
    }

    public java.lang.String getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public android.os.IBinder getService(java.lang.String name) throws android.os.RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        android.os.IBinder _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(name);
            mRemote.transact(TRANSACTION_getService, _data, _reply, 0);
            _reply.readException();
            _result = _reply.readStrongBinder();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    @Override
    public android.os.IBinder checkService(java.lang.String name) throws android.os.RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        android.os.IBinder _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(name);
            mRemote.transact(TRANSACTION_checkService, _data, _reply, 0);
            _reply.readException();
            _result = _reply.readStrongBinder();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    @Override
    public void addService(java.lang.String name, android.os.IBinder service) throws android.os.RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(name);
            _data.writeStrongBinder(service);
            mRemote.transact(TRANSACTION_addService, _data, _reply, 0);
            _reply.readException();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
    }

    @Override
    public void removeService(java.lang.String name) throws android.os.RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            _data.writeString(name);
            mRemote.transact(TRANSACTION_removeService, _data, _reply, 0);
            _reply.readException();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
    }

    @Override
    public java.lang.String[] listServices() throws android.os.RemoteException {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String[] _result;
        try {
            _data.writeInterfaceToken(DESCRIPTOR);
            mRemote.transact(TRANSACTION_listServices, _data, _reply, 0);
            _reply.readException();
            _result = _reply.createStringArray();
        } finally {
            _reply.recycle();
            _data.recycle();
        }
        return _result;
    }

    public static final int TRANSACTION_getService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static final int TRANSACTION_checkService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    public static final int TRANSACTION_addService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    public static final int TRANSACTION_removeService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    public static final int TRANSACTION_listServices = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);

}
