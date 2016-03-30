package com.elbbbird.android.widgets.provider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.elbbbird.android.widgets.R;

/**
 * Created by Hailong Zhang on 2016/3/30.
 */
public class SettingsWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];

            Intent intent = new Intent("android.net.vpn.SETTINGS");
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_settings);
            views.setOnClickPendingIntent(R.id.main_btn, pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
