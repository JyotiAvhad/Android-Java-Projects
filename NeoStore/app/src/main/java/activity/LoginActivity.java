package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.neostore.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText user_name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);

        findViewById(R.id.fabAdd).setOnClickListener(this);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.tvLoginForgetPwd).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnLogin:
                loginUser();
                break;

            case R.id.fabAdd:
                registerUser();
                break;

            case R.id.tvLoginForgetPwd:
                forgotPassword();
                break;

        }
    }

    private void loginUser() {

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private void registerUser() {

        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void forgotPassword() {

        Intent intent = new Intent(LoginActivity.this, ForgotPwdActivity.class);
        startActivity(intent);
    }
}
