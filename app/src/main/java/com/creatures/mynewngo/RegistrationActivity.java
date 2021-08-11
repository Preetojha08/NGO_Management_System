package com.creatures.mynewngo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {

    TextInputEditText tiet_user_name,tiet_user_email,tiet_user_mobile_no,tiet_user_gender,tiet_user_password,tiet_user_confirm_password;
    TextInputLayout textInputLayout_password,textInputLayout_confirm_password;
    Button btn_sign_up;
    TextView tv_sign_in;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String MobilePattern = "[0-9]{10}";
    String passwordPattern = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}";
    String str_username,str_email,str_mobile_no,str_gender,str_password,str_confirm_password;
    boolean password = false;

    RequestQueue request_queue = null;
    ProgressDialog progress_bar_reg_dialog = null;
    String server_api_url = "https://preetojhadatabasetrail.000webhostapp.com/NGO/signup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        tiet_user_name=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_name);
        tiet_user_email=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_email);
        tiet_user_mobile_no=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_mobile_no);
        tiet_user_gender=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_gender);
        tiet_user_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_password_one);
        tiet_user_confirm_password=(TextInputEditText)findViewById(R.id.text_input_edit_text_reg_user_confirm_password);

        textInputLayout_password=(TextInputLayout)findViewById(R.id.text_input_layout_password_one);
        textInputLayout_confirm_password=(TextInputLayout)findViewById(R.id.text_input_layout_confirm_password_two);

        tiet_user_password.setText("Abcd@1234");
        tiet_user_confirm_password.setText("Abcd@1234");
        tiet_user_gender.setText("Male");
        tiet_user_mobile_no.setText("1234567890");
        tiet_user_email.setText("user@gmail.com");
        tiet_user_name.setText("User Name");

        btn_sign_up=(Button)findViewById(R.id.button_registration_add_data);

        tv_sign_in=(TextView)findViewById(R.id.sign_in_text_view);

        tv_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                finish();
            }
        });

       tiet_user_password.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {

               if (tiet_user_password.getText().toString().length() <= 0) {
                   Log.i("Password","This is Empty");
                   textInputLayout_password.setPasswordVisibilityToggleEnabled(true);
                   //Toast.makeText(RegistrationActivity.this, "Empty", Toast.LENGTH_SHORT).show();

               } else {
                   Log.i("Password","This is Not Empty");
                   //Toast.makeText(RegistrationActivity.this, "Not Empty", Toast.LENGTH_SHORT).show();
               }

           }
       });

       tiet_user_confirm_password.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {

               if (tiet_user_confirm_password.getText().toString().length() <= 0) {
                   Log.i("Password","This is Empty");
                   textInputLayout_confirm_password.setPasswordVisibilityToggleEnabled(true);
                   //Toast.makeText(RegistrationActivity.this, "Empty", Toast.LENGTH_SHORT).show();

               } else {
                   Log.i("Password","This is Not Empty");
                   //Toast.makeText(RegistrationActivity.this, "Not Empty", Toast.LENGTH_SHORT).show();
               }

           }
       });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_username=tiet_user_name.getText().toString().trim();
                str_email=tiet_user_email.getText().toString().trim();
                str_mobile_no=tiet_user_mobile_no.getText().toString().trim();
                str_gender=tiet_user_gender.getText().toString().trim();
                str_password=tiet_user_password.getText().toString().trim();
                str_confirm_password=tiet_user_confirm_password.getText().toString().trim();

                if (str_username.isEmpty() || str_email.isEmpty() || str_mobile_no.isEmpty() || str_gender.isEmpty() || str_password.isEmpty() || str_confirm_password.isEmpty() )
                {
                    Toast.makeText(RegistrationActivity.this, "Fields are empty !!", Toast.LENGTH_SHORT).show();

                }
                else if (str_username.equals(" ") || str_email.equals(" ") || str_mobile_no.equals(" ") || str_gender.equals(" ") || str_password.equals(" ") || str_confirm_password.equals(" ") )
                {
                    Toast.makeText(RegistrationActivity.this, "Fields are empty !!", Toast.LENGTH_SHORT).show();
                }
                else if (!str_email.matches(emailPattern))
                {
                    tiet_user_email.setError("Invalid email address");
                }
                else if (!str_mobile_no.matches(MobilePattern))
                {
                    tiet_user_mobile_no.setError("Invalid Mobile NO");
                }
                else if (!str_password.matches(passwordPattern) && !str_confirm_password.matches(passwordPattern))
                {
                    //passwordToggleEnabled
                    //textInputLayout_password.isPasswordVisibilityToggleEnabled(true);
                    textInputLayout_password.setPasswordVisibilityToggleEnabled(false);
                    textInputLayout_confirm_password.setPasswordVisibilityToggleEnabled(false);
                    tiet_user_password.setError("Invalid Password");
                    tiet_user_confirm_password.setError("Invalid Password");
                }
                else if (!str_password.equals(str_confirm_password))
                {
                    textInputLayout_confirm_password.setPasswordVisibilityToggleDrawable(View.GONE);
                    tiet_user_confirm_password.setError("Password doesn't Match");
                    //textInputLayout_confirm_password.setPasswordVisibilityToggleEnabled(false);

                }
                else
                {
                    textInputLayout_password.setPasswordVisibilityToggleEnabled(true);
                    textInputLayout_confirm_password.setPasswordVisibilityToggleEnabled(true);
                    Toast.makeText(RegistrationActivity.this, "Done: "+str_username, Toast.LENGTH_SHORT).show();
                    SendSignUpDataToServer(str_username,str_email,str_mobile_no,str_password,str_gender);
                }

            }
        });

    }

    void SendSignUpDataToServer(String user_name, String user_email, String user_mobile_no, String user_password,String user_gender)
    {

        request_queue= Volley.newRequestQueue(this);
        progress_bar_reg_dialog = ProgressDialog.show(this, "Signing UP","Please Wait", true);
        final HashMap<String, String> parameters = new HashMap();

        // Add your parameters in HashMap
        /*parameters.put("username",Objects.requireNonNull(tiet_user_name.getText().toString().trim()));
        parameters.put("email",Objects.requireNonNull(tiet_user_email.getText().toString().trim()));
        parameters.put("mobile_no",Objects.requireNonNull(tiet_user_mobile_no.getText().toString().trim()));
        parameters.put("password",Objects.requireNonNull(tiet_user_password.getText().toString().trim()));
        parameters.put("gender",Objects.requireNonNull(tiet_user_gender.getText().toString().trim()));
         */

        parameters.put("username",user_name);
        parameters.put("email",user_email);
        parameters.put("mobile_no",user_mobile_no);
        parameters.put("password",user_password);
        parameters.put("gender",user_gender);


        StringRequest string_request = new StringRequest(Request.Method.POST,server_api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("Response Check", "response: " + response);
                progress_bar_reg_dialog.dismiss();

                // Handle Server response here
                try {
                    JSONObject response_json_object = new JSONObject(response);
                    boolean status = response_json_object.getBoolean("isSuccess");
                    if (response_json_object.has("data"))
                    {
                        JSONObject data = response_json_object.getJSONObject("data");
                    }
                    else
                    {
                        Log.e("Error ek Aur", "onResponse: error ");
                    }
                    Toast.makeText(RegistrationActivity.this , response_json_object.getString("message") , Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    Toast.makeText(RegistrationActivity.this, "Error: "+e, Toast.LENGTH_LONG).show();
                    String error = " "+e;
                    tiet_user_name.setText(error);
                    Log.e("Error Check", "problem occurred "+error);
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error in Response", "problem occurred, volley error: " + error.getMessage());
                progress_bar_reg_dialog.dismiss();

            }

        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return parameters;

            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap();
                // Add your Header paramters here
                return headers;
            }
        };

        request_queue.add(string_request);

    }

}