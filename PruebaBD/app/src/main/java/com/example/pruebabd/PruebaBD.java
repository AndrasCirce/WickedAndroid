package com.example.pruebabd;

import com.google.firebase.database.FirebaseDatabase;

public class PruebaBD extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
