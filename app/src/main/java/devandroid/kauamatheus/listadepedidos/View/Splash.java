package devandroid.kauamatheus.listadepedidos.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import devandroid.kauamatheus.listadepedidos.R;
import devandroid.kauamatheus.listadepedidos.database.Lista_DB;


public class Splash extends AppCompatActivity {

    public static final int TIME_OUT_SPLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cumutarTelaSplash();
    }

    private void cumutarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Lista_DB db = new Lista_DB(Splash.this) ;

                Intent telaPrincipal = new Intent(Splash.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}