package iset.project.checkinpromobile;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText emailInput;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        emailInput = findViewById(R.id.emailInput);
        Button resetPasswordButton = findViewById(R.id.resetPasswordButton);

        auth = FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(view -> {
            String email = emailInput.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
                return;
            }

            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(this, "Password reset email sent. Check your inbox.", Toast.LENGTH_SHORT).show();
                            finish(); // Close activity after success
                        } else {
                            String error = task.getException() != null ? task.getException().getMessage() : "Failed to send reset email.";
                            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
