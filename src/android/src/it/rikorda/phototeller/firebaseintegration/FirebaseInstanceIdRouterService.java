package it.rikorda.phototeller.firebaseintegration;

import com.google.firebase.iid.FirebaseInstanceId;
import com.pushwoosh.PushwooshFcmHelper;
import org.apache.cordova.firebase.FirebasePluginInstanceIDService;

public class FirebaseInstanceIdRouterService extends FirebasePluginInstanceIDService {
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Send a new token to Pushwoosh
        PushwooshFcmHelper.onTokenRefresh(this, refreshedToken);
        super.onTokenRefresh();
    }
}
