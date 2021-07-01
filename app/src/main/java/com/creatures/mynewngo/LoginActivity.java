package com.creatures.mynewngo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    TextView tv_sign_up;
    TextInputEditText tiet_log_user_name,tiet_log_user_password;
    TextInputLayout til_log_password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String MobilePattern = "[0-9]{10}";
    Button login_btn;
    String log_username,log_userpassword;
    int user_input=0;
    String pre_password="Test@1234";

    //Google Sign UP
    ImageView image_view_google_login,image_view_facebook_login;
    SignInButton google_signInButton;
    GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 1;
    int counter=0;

    RequestQueue request_queue = null;
    ProgressDialog progress_bar_reg_dialog = null;
    String server_api_url = "https://preetojhadatabasetrail.000webhostapp.com/NGO/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        tiet_log_user_name=(TextInputEditText)findViewById(R.id.text_input_edit_text_log_user_name);
        tiet_log_user_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_log_user_password);
        til_log_password=(TextInputLayout)findViewById(R.id.text_input_layout_login_password);

        image_view_google_login=(ImageView)findViewById(R.id.imgview_google_login);
        image_view_facebook_login=(ImageView)findViewById(R.id.imgview_facebook_login);

        google_signInButton=(SignInButton)findViewById(R.id.google_sign_up_button);


        login_btn=(Button)findViewById(R.id.button_login);

        tv_sign_up=(TextView)findViewById(R.id.sign_up_text_view);

        tv_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
                finish();
            }
        });

        tiet_log_user_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (tiet_log_user_password.getText().toString().length() <= 0) {
                    Log.i("Password","This is Empty");
                    til_log_password.setPasswordVisibilityToggleEnabled(true);
                    //Toast.makeText(RegistrationActivity.this, "Empty", Toast.LENGTH_SHORT).show();

                } else {
                    Log.i("Password","This is Not Empty");
                    //Toast.makeText(RegistrationActivity.this, "Not Empty", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (tiet_log_user_password.getText().toString().length() <= 0) {
                    Log.i("Password","This is Empty");
                    til_log_password.setPasswordVisibilityToggleEnabled(true);
                    //Toast.makeText(RegistrationActivity.this, "Empty", Toast.LENGTH_SHORT).show();

                } else {
                    Log.i("Password","This is Not Empty");
                    //Toast.makeText(RegistrationActivity.this, "Not Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        image_view_google_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                google_signInButton.performClick();
                user_input=40;
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                log_userpassword=tiet_log_user_password.getText().toString().trim();
                log_username=tiet_log_user_name.getText().toString().trim();

                if (log_username.isEmpty() || log_username.equals(" ") )
                {
                    tiet_log_user_name.setError("User is empty !!");
                }
                if (log_userpassword.isEmpty() || log_userpassword.equals(" "))
                {
                    tiet_log_user_password.setError("Password is empty !!");
                    til_log_password.setPasswordVisibilityToggleEnabled(false);
                }
                else if (log_username.matches(emailPattern))
                {
                    //Toast.makeText(LoginActivity.this, "Login with Email Address", Toast.LENGTH_SHORT).show();
                    til_log_password.setPasswordVisibilityToggleEnabled(true);
                    user_input=20;
                    SendLoginDataToServer(log_username,log_userpassword);

                }
                else if (log_username.matches(MobilePattern))
                {
                    //Toast.makeText(LoginActivity.this, "Login with Mobile Number", Toast.LENGTH_SHORT).show();
                    user_input=30;
                    SendLoginDataToServer(log_username,log_userpassword);
                }
                else
                {
                    //Toast.makeText(LoginActivity.this, "Login with Username", Toast.LENGTH_SHORT).show();
                    user_input=10;
                    SendLoginDataToServer(log_username,log_userpassword);
                }

            }
        });

        google_signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });

    }

    void SendLoginDataToServer(String username,String password)
    {
        request_queue= Volley.newRequestQueue(this);
        progress_bar_reg_dialog = ProgressDialog.show(this, "Logging In","Please Wait", true);
        final HashMap<String, String> log_parameters = new HashMap();

        switch (user_input)
        {
            case 0:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                break;
            case 10:
                log_parameters.put("username",username);
                log_parameters.put("password",password);
                break;
            case 20:
                log_parameters.put("email",username);
                log_parameters.put("password",password);
                break;
            case 30:
                log_parameters.put("mobile_no",username);
                log_parameters.put("password",password);
                break;

        }

        StringRequest log_string_request = new StringRequest(Request.Method.POST, server_api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progress_bar_reg_dialog.dismiss();
                try {
                    JSONObject log_json_object = new JSONObject(response);
                    boolean status = log_json_object.getBoolean("isSuccess");
                    if (status == true) {
                        Toast.makeText(LoginActivity.this, log_json_object.getString("message"), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    } else {
                        Log.e("Error Login One", " Error: pata nai kyu nai horaha hAI");
                        Toast.makeText(LoginActivity.this, log_json_object.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, "Error: " + e, Toast.LENGTH_LONG).show();
                    String error = " " + e;
                    Log.e("Error Check", "problem occurred " + error);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error in Response", "problem occurred, volley error: " + error.getMessage());
                progress_bar_reg_dialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return log_parameters;

            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap();
                // Add your Header paramters here
                return headers;
            }
        };

        request_queue.add(log_string_request);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_SIGN_IN){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
           /*
            userName.setText(account.getDisplayName());
            userEmail.setText(account.getEmail());
            userId.setText(account.getId());*/
            GoogleSignInAccount account=result.getSignInAccount();
            String g_username,g_email,account_org;

            g_username=account.getDisplayName();
            g_email=account.getEmail();
            account_org="google";


        }else{
            Toast.makeText(getApplicationContext(),"Sign in cancel",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}