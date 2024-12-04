package iset.project.checkinpromobile.User;

import iset.project.checkinpromobile.Model.LoginRequest;
import iset.project.checkinpromobile.Model.SignupRequest;
import iset.project.checkinpromobile.Model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
    // Signup endpoint
    @POST("/users/si")
    Call<User> signup(@Body SignupRequest signupRequest);

    // Login endpoint
    @POST("/users/login")
    Call<User> login(@Body LoginRequest loginRequest);

    // Profile endpoint
    @GET("/users/profile")
    Call<User> getProfile(@Header("User-Email") String email);

    // Update user endpoint
    @PUT("/users/{id}")
    Call<User> updateUser(@Path("id") Long id, @Body User updatedUser);

    // Send email to user
    @POST("/users/{id}/send-email")
    Call<Void> sendEmail(@Path("id") Long id);
}
