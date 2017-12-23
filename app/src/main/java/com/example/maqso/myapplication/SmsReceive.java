package com.example.maqso.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.design.widget.Snackbar;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by maqso on 10/11/2017.
 */

public class SmsReceive extends BroadcastReceiver {

    String message;

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            SmsMessage smsMessage = msgs[0];
            message = smsMessage.getDisplayMessageBody();
            Communicator ob = new Communicator();
            ob.setSms(message);
            EventBus.getDefault().post(ob);
        }
    }
}
