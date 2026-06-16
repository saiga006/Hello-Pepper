package com.pepper.helloapp;

import android.os.Bundle;
import android.util.Log;

import com.aldebaran.qi.sdk.QiContext;
import com.aldebaran.qi.sdk.QiSDK;
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks;
import com.aldebaran.qi.sdk.builder.SayBuilder;
import com.aldebaran.qi.sdk.design.activity.RobotActivity;
import com.aldebaran.qi.sdk.object.conversation.Say;

public class MainActivity extends RobotActivity implements RobotLifecycleCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QiSDK.register(this, this);
        setContentView(R.layout.activity_main);
        // Register the RobotLifecycleCallbacks to this Activity.
        Log.d("HelloApp", "onCreate invoked");
    }

    @Override
    protected void onDestroy() {
        // Unregister the RobotLifecycleCallbacks for this Activity.
        QiSDK.unregister(this, this);
        super.onDestroy();
    }

    @Override
    public void onRobotFocusGained(QiContext qiContext) {
        Log.d("HelloApp", "This is a test to check robot focus gained callback is received or not");
        // The robot focus is gained.
        Say say = SayBuilder.with(qiContext).withText("Hello Pepper").build();
        say.run();
    }

    @Override
    public void onRobotFocusLost() {
        // The robot focus is lost.
        Log.d("HelloApp", "onRobotFocusLost is invoked");
    }

    @Override
    public void onRobotFocusRefused(String reason) {
        // The robot focus is refused.
        Log.d("HelloApp", "onRobotFocusRefused is invoked" + "reason -> " + reason);
    }
}