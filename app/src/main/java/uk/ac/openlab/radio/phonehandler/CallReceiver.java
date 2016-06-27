package uk.ac.openlab.radio.phonehandler;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

import uk.ac.openlab.radio.activities.ShowOverviewActivity;

/**
 * Created by deepaksood619 on 27/6/16.
 */
public class CallReceiver extends PhoneCallReceiver {

    @Override
    protected void onIncomingCallStarted(Context ctx, String number, Date start) {
        super.onIncomingCallStarted(ctx, number, start);
        //call incoming: +8860244278 date start: Mon Jun 27 13:21:33 IST 2016

        Log.v("dks","call incoming: "+number+" date start: "+start);

    }


    @Override
    protected void onIncomingCallEnded(Context ctx, String number, Date start, Date end) {
        super.onIncomingCallEnded(ctx, number, start, end);
        Log.v("dks","call incoming ended: "+number+" date start: "+start + "date end: "+end);

    }


    @Override
    public void onCallStateChanged(Context context, int state, String number) {
        super.onCallStateChanged(context, state, number);
        Log.v("dks","state changed: "+state + " number: "+number);
        if(state == 2 && number != null) {
            if(number.contains("8860244278")) {
                Log.v("dks","removing alertdialog");
                ShowOverviewActivity.callReceived = true;
                ShowOverviewActivity.alertDialog.dismiss();
            }
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    protected void onOutgoingCallStarted(Context ctx, String number, Date start) {
        super.onOutgoingCallStarted(ctx, number, start);
    }

    @Override
    protected void onOutgoingCallEnded(Context ctx, String number, Date start, Date end) {
        super.onOutgoingCallEnded(ctx, number, start, end);
    }

    @Override
    protected void onMissedCall(Context ctx, String number, Date start) {
        super.onMissedCall(ctx, number, start);
    }
}