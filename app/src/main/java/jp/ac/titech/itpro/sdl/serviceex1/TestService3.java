package jp.ac.titech.itpro.sdl.serviceex1;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestService3 extends IntentService {
    private final static String TAG = "TestService3";
    public final static String EXTRA_MYARG = "MYARG";
    public final static String ACTION_ANSWER = "ACTION_ANSWER";
    public final static String EXTRA_ANSWER = "EXTRA_ANSWER";

    public TestService3() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
        Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
        String message = "Hello, I'm Service3.";
        Intent answerIntent = new Intent();
        answerIntent.setAction(ACTION_ANSWER);
        answerIntent.putExtra(EXTRA_ANSWER, message);
        sendBroadcast(answerIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate in " + Thread.currentThread());
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy in " + Thread.currentThread());
        super.onDestroy();
    }
}

