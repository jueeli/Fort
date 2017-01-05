package example.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by softbunch on 7/4/16.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                } finally {
                    Intent intent = new Intent(SplashScreen.this, FortInformation.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        splashTread.start();
    }
}
