package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.Task;

import org.openyolo.api.CredentialClient;
import org.openyolo.protocol.CredentialRetrieveResult;
import org.openyolo.protocol.Hint;
import org.openyolo.protocol.HintRetrieveRequest;
import org.openyolo.protocol.HintRetrieveResult;

/**
 * TODO: document the purpose of this class
 */

public class CredentialsOpenYoloClient extends CredentialsClient {

    private CredentialClient mCredentialClient;

    CredentialsOpenYoloClient(@NonNull Context context, @NonNull Auth.AuthCredentialsOptions
            authCredentialsOptions) {
        super(context, authCredentialsOptions);
        mCredentialClient = CredentialClient.getInstance(getApplicationContext());
    }

    CredentialsOpenYoloClient(@NonNull Activity activity, @NonNull Auth.AuthCredentialsOptions
            authCredentialsOptions) {
        super(activity, authCredentialsOptions);
        mCredentialClient = CredentialClient.getInstance(getApplicationContext());
    }

    @Nullable
    public Credential getCredential(@Nullable Intent data) {
        CredentialRetrieveResult result = mCredentialClient.getCredentialRetrieveResult(data);
        if (result != CredentialRetrieveResult.UNKNOWN) {
            org.openyolo.protocol.Credential openYoloCredential = result.getCredential();
            // todo convert to Credential
            return null;
        }
        HintRetrieveResult result2 = mCredentialClient.getHintRetrieveResult(data);
        if (result2 != HintRetrieveResult.UNKNOWN) {
            Hint openYoloHint = result2.getHint();
            // todo convert to Credential
            return null;
        }
        return null;
    }

    @Override
    public Task<Void> save(@NonNull Credential credential) {
        return super.save(credential); // TODO return a Task for this
    }

    @Override
    public PendingIntent getHintPickerIntent(@NonNull HintRequest hintRequest) {
        HintRetrieveRequest request = null; // todo, convert HintRequest to HintRetrieveRequest
        Intent retrieveHintIntent = mCredentialClient.getHintRetrieveIntent(request);

        return PendingIntent.getActivity(getApplicationContext(), 0, retrieveHintIntent, 0);
    }

    @Override
    public Task<CredentialRequestResponse> request(@NonNull CredentialRequest credentialRequest) {
        return super.request(credentialRequest); // TODO return a Task for this
    }

    @Override
    public Task<Void> delete(@NonNull Credential credential) {
        return super.delete(credential); // TODO return a Task for this
    }

    @Override
    public Task<Void> disableAutoSignIn() {
        mCredentialClient.disableAutoSignIn();
        return super.disableAutoSignIn(); // TODO return a Task for this
    }

}
