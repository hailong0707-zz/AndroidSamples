package com.elbbbird.android.core.servicemanager;

import android.database.MatrixCursor;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.HashMap;

/**
 * Created by Hailong Zhang on 2016/3/29.
 */
public abstract class ServiceManagerNative extends Binder implements IServiceManager {

    private static final java.lang.String DESCRIPTOR = ServiceManagerProxy.DESCRIPTOR;

    /**
     * Construct the stub at attach it to the interface.
     */
    public ServiceManagerNative() {
        this.attachInterface(this, DESCRIPTOR);
    }


    @Override
    public android.os.IBinder asBinder() {
        return this;
    }

    @Override
    public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags)
            throws android.os.RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION: {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            case ServiceManagerProxy.TRANSACTION_getService: {
                data.enforceInterface(DESCRIPTOR);
                java.lang.String _arg0;
                _arg0 = data.readString();
                android.os.IBinder _result = this.getService(_arg0);
                reply.writeNoException();
                reply.writeStrongBinder(_result);
                return true;
            }
            case ServiceManagerProxy.TRANSACTION_checkService: {
                data.enforceInterface(DESCRIPTOR);
                java.lang.String _arg0;
                _arg0 = data.readString();
                android.os.IBinder _result = this.checkService(_arg0);
                reply.writeNoException();
                reply.writeStrongBinder(_result);
                return true;
            }
            case ServiceManagerProxy.TRANSACTION_addService: {
                data.enforceInterface(DESCRIPTOR);
                java.lang.String _arg0;
                _arg0 = data.readString();
                android.os.IBinder _arg1;
                _arg1 = data.readStrongBinder();
                this.addService(_arg0, _arg1);
                reply.writeNoException();
                return true;
            }
            case ServiceManagerProxy.TRANSACTION_removeService: {
                data.enforceInterface(DESCRIPTOR);
                java.lang.String _arg0;
                _arg0 = data.readString();
                this.removeService(_arg0);
                reply.writeNoException();
                return true;
            }
            case ServiceManagerProxy.TRANSACTION_listServices: {
                data.enforceInterface(DESCRIPTOR);
                java.lang.String[] _result = this.listServices();
                reply.writeNoException();
                reply.writeStringArray(_result);
                return true;
            }
        }
        return super.onTransact(code, data, reply, flags);
    }

    private static HashMap<String, IBinder> sServices = new HashMap<String, IBinder>();
    private static ServiceManagerNative sServiceManagerNative = new ServiceManagerNative() {
        @Override
        public IBinder getService(String name) throws RemoteException {
            return sServices.get(name);
        }

        @Override
        public IBinder checkService(String name) throws RemoteException {
            return sServices.get(name);
        }

        @Override
        public void addService(String name, IBinder service) throws RemoteException {
            sServices.put(name, service);
        }

        @Override
        public void removeService(String name) throws RemoteException {
            sServices.remove(name);
        }

        @Override
        public String[] listServices() throws RemoteException {
            return (String[]) sServices.keySet().toArray();
        }
    };

    public static MatrixCursor sServiceManagerCursor = new MatrixCursor(new String[]{}) {

        @Override
        public Bundle getExtras() {
            Bundle extra = new Bundle();
            extra.putParcelable(ServiceManager.KEY_SERVICE_MANAGER, new ParcelBinder(sServiceManagerNative));

            return extra;
        }
    };
}
