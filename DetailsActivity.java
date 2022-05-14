package aligoldsmith.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}