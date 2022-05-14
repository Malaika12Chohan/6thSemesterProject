package aligoldsmith.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class aboutuspage extends AppCompatActivity {


    LottieAnimationView lottieAnimationView;

    TextView detailsText;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutuspage);
        detailsText = findViewById(R.id.details);
        layout = findViewById(R.id.layout);

        lottieAnimationView = findViewById(R.id.lottieAnimation);


    }

    public void expand(View view) {


        int v = (detailsText.getVisibility() == View.GONE) ? view.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        detailsText.setVisibility(v);
    }
}