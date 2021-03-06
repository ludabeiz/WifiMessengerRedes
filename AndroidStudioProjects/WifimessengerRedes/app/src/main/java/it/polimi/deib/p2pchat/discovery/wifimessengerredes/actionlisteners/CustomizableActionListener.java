package it.polimi.deib.p2pchat.discovery.actionlisteners;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

public class CustomizableActionListener implements WifiP2pManager.ActionListener {

    private final Context context;
    private final String successLog, successToast, failLog, failToast, tag;


    /**
     * Constructor of CustomizableActionListener.
     * successLog, successToast, failLog, failToast can be == null, and if this happens the associated action is skipped.
     * @param context Context necessary to display Toasts.
     * @param tag String that represents the tag for Log.d, but if is == null, this constructor uses "ActionListenerTag" as tag.
     * @param successLog String that represent the message for Log.d in onSuccess
     * @param successToast String that represent the message for Toasts in onSuccess
     * @param failLog String that represent the message for Log.d in onFailure. The failure code will be added automatically.
     * @param failToast String that represent the message for Toasts in onFailure
     */
    public CustomizableActionListener(@NonNull Context context,
                                      String tag,
                                      String successLog, String successToast,
                                      String failLog, String failToast) {
        this.context = context;
        this.successLog = successLog;
        this.successToast = successToast;
        this.failLog = failLog;
        this.failToast = failToast;

        if(tag==null) {
            this.tag = "ActionListenerTag";
        } else {
            this.tag = tag;
        }
    }

    @Override
    public void onSuccess() {
        if(successLog != null) {
            Log.d(tag, successLog);
        }
        if(context!=null && successToast != null) {
            Toast.makeText(context, successToast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(int reason) {
        if(failLog != null) {
            Log.d(tag, failLog + ", reason: " + reason);
        }
        if(context!=null && failToast != null) {
            Toast.makeText(context, failToast, Toast.LENGTH_SHORT).show();
        }
    }
}
