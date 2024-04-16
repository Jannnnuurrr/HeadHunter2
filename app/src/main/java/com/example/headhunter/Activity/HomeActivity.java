package com.example.headhunter.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.headhunter.Fragment.AllJobFragment;
import com.example.headhunter.R;
import com.example.headhunter.Fragment.WorkerProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "job_notifications";
    private static final String CHANNEL_NAME = "Job Notifications";
    private static final String CHANNEL_DESCRIPTION = "Get notified about new job opportunities.";


    //Нижняя панель BottomNavigation
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        createNotificationChannel();
        showNotification(this, "Вышло 6 новых вакансии!", "Поскорее откликнитесь и получите работу мечты.");

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.home_bg));

        //Bottom Navigation то что снизу
        bottomNavigation = findViewById(R.id.bottomNavigationView);

        //Установка слушателя на панель снизу
        bottomNavigation.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_all_job) {
                replaceFragment(new AllJobFragment());
                return true;
            } else if (item.getItemId() == R.id.menu_user_profile) {
                    replaceFragment(new WorkerProfileFragment());
                return true;
            }
            return false;
        });

        // Установить кнопку "All Job" в качестве выбранной при запуске активности
        bottomNavigation.setSelectedItemId(R.id.menu_all_job);
    }
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESCRIPTION);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showNotification(Context context, String title, String message) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true);

        Intent intent = new Intent(context, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);
        notificationManager.notify(1, builder.build());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }
    //Установка видимости menu_edit_profile по тому как что показывает fragment_container
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        menu.findItem(R.id.menu_edit_profile).setVisible(currentFragment instanceof WorkerProfileFragment);
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logout){
            // Обработка нажатия на пункт меню выход из профиля
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            finish(); // Закрытие текущей активности
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Замена фрагмента
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
