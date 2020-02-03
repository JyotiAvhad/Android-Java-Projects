package com.example.foodies;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.foodies.R;

public class FavoriteFragment extends Fragment {


    //1. Notification Channel
    //2. Notification Builder
    //3. Notification Manager

    private static final String Channel_Id = "abcd";
    private static final String Channel_Name = "My Notification";
    private static final String Channel_Desc = "Its a Notification";

    View myFragmnt;

    Button btn_notifyMe;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myFragmnt = inflater.inflate(R.layout.fragment_favorite, container, false);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(Channel_Id, Channel_Name, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(Channel_Desc);
            //Grab the NotificationManager and post the notification
            NotificationManager notificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }

        //Setup the buttons
        btn_notifyMe = myFragmnt.findViewById(R.id.btn_clickMe);
        btn_notifyMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNotification();
            }
        });

        return myFragmnt;
    }


    private void showNotification() {

        //create object of NotificationManager
        NotificationCompat.Builder notifyBuilder;

        notifyBuilder = new NotificationCompat.Builder(getContext(), Channel_Id)
                .setSmallIcon(R.drawable.ic_android_white_24dp)
                .setContentTitle("My Notification....!")
                .setContentText("Hey you are getting some new notification :-)")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
        notificationManagerCompat.notify(1, notifyBuilder.build());
    }

}
