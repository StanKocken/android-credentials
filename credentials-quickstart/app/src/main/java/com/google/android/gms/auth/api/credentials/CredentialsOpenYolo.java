package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.example.credentialsbasic.MainActivity;

/**
 * TODO: document the purpose of this class
 */

public class CredentialsOpenYolo {

    public static CredentialsOpenYoloClient getClient(@NonNull Activity var0) {
        return new CredentialsOpenYoloClient(var0, CredentialsOptions.DEFAULT);
    }

    public static CredentialsOpenYoloClient getClient(@NonNull Activity var0, @NonNull CredentialsOptions var1) {
        return new CredentialsOpenYoloClient(var0, var1);
    }

    public static CredentialsOpenYoloClient getClient(@NonNull Context var0) {
        return new CredentialsOpenYoloClient(var0, CredentialsOptions.DEFAULT);
    }

    public static CredentialsOpenYoloClient getClient(@NonNull Context var0, @NonNull CredentialsOptions var1) {
        return new CredentialsOpenYoloClient(var0, var1);
    }
}
