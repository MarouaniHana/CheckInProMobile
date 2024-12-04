package iset.project.checkinpromobile;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import iset.project.checkinpromobile.Model.SignupRequest;
import iset.project.checkinpromobile.Model.User;
import iset.project.checkinpromobile.User.Client;
import iset.project.checkinpromobile.User.UserService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*public class SignupActivity extends AppCompatActivity {

    private EditText nameInput, emailInput, passwordInput, confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize inputs
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.signupEmailInput);
        passwordInput = findViewById(R.id.signupPasswordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        Button signupButton = findViewById(R.id.signupButton);

        // Handle Sign-Up Logic
        signupButton.setOnClickListener(view -> {
            String name = nameInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (validateInputs(name, email, password, confirmPassword)) {
                // Proceed with sign-up logic (e.g., send data to server)
                Toast.makeText(SignupActivity.this, "Sign-Up Successful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean validateInputs(String name, String email, String password, String confirmPassword) {
        // Check if fields are empty
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(confirmPassword)) {
            Toast.makeText(this, "Please confirm your password", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Additional password checks (optional)
        if (password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
*/
public class SignupActivity extends AppCompatActivity {
    private UserService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        apiService = Client.getRetrofit("http://localhost:8080")
                .create(UserService.class);

        // Example signup button click
        Button signupButton = findViewById(R.id.signupButton);
        signupButton.setOnClickListener(view -> {
            SignupRequest signupRequest = new SignupRequest("John", "Doe", "john@example.com",
                    "john_doe", "password123", "123456",
                    "12345", "Developer", "Address",
                    "1990-01-01", "2022-01-01", null);

            apiService.signup(signupRequest).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        // Handle successful signup
                        User newUser = response.body();
                        // Navigate to profile or next screen
                    } else {
                        // Handle error
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    // Handle network error
                }
            });
        });
    }
}
