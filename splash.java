package aligoldsmith.com;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;

import android.view.Window;

import android.view.WindowManager;


public class splash extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Window window = getWindow() ;


        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);




        Thread t = new Thread(){


            @Override

            public void run() {try {

                sleep(4000);

                startActivity(new Intent(getApplicationContext(),LoginActivity.class));

                finish();

            } catch (InterruptedException e) {

                e.getStackTrace();

            }


                super.run();

            }

        };


        t.start();





    }


}

