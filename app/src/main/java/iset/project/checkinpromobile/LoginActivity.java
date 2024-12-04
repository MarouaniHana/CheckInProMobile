package iset.project.checkinpromobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import iset.project.checkinpromobile.Model.LoginRequest;
import iset.project.checkinpromobile.Model.User;
import iset.project.checkinpromobile.User.Client;
import iset.project.checkinpromobile.User.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        TextView signupLink = findViewById(R.id.signupLink);
        TextView forgotPasswordLink = findViewById(R.id.forgotPasswordLink);

        // Navigate to SignupActivity
        signupLink.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        // Placeholder login functionality
        loginButton.setOnClickListener(view -> {
            // Add login logic here
        });

        // Navigate to ResetPasswordActivity
        forgotPasswordLink.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
        });
    }
}
*/


public class LoginActivity extends AppCompatActivity {
    private UserService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize the API service
        apiService = Client.getRetrofit("http://localhost:8080")
                .create(UserService.class);

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {
            // Create a LoginRequest object with the user's input
            LoginRequest loginRequest = new LoginRequest("john@example.com", "password123");

            // Make the API call to login
            apiService.login(loginRequest).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        // Navigate to MainActivity after successful login
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Optional: Finish LoginActivity to prevent going back to it
                    } else {
                        // Handle login failure (show an error message, for example)
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    // Handle network failure
                }
            });
        });

        // If you have other actions like signup or password reset, handle them here
        TextView signupLink = findViewById(R.id.signupLink);
        signupLink.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        TextView forgotPasswordLink = findViewById(R.id.forgotPasswordLink);
        forgotPasswordLink.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
        });
    }
}
