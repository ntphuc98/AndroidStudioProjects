package com.example.musicdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MusicBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, PlayerService.class));
    }
}
