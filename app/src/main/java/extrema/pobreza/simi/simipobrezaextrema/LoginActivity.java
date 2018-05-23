package extrema.pobreza.simi.simipobrezaextrema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnStartSesion = findViewById(R.id.login_btn_start);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnStartSesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
