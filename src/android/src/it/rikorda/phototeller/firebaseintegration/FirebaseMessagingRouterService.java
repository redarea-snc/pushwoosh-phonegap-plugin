package it.rikorda.phototeller.firebaseintegration;

import com.google.firebase.messaging.RemoteMessage;
import com.pushwoosh.PushwooshFcmHelper;
import org.apache.cordova.firebase.FirebasePluginMessagingService;

public class FirebaseMessagingRouterService extends FirebasePluginMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if(PushwooshFcmHelper.isPushwooshMessage(remoteMessage)){
            //this is a Pushwoosh push, SDK will handle it automatically
            PushwooshFcmHelper.onMessageReceived(this, remoteMessage);
        }
        else{
            //--Rut - 08/01/2018 - handling push di Firebase (di default)
            super.onMessageReceived(remoteMessage);
        }
    }
}
