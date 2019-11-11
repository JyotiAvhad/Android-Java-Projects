package com.example.foodies;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyPhoneNoActivity extends AppCompatActivity {

    private static final String TAG = "VerifyPhoneNoActivity";

    private EditText et_verifyOTP;
    private String verificationId;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);

        Log.d(TAG, "onCreate: start activity");

        firebaseAuth = FirebaseAuth.getInstance();
        et_verifyOTP = findViewById(R.id.et_otp);

        Intent intent = getIntent();
        String mobile = intent.getStringExtra("mobile");
        sendVerificationCode(mobile);

        findViewById(R.id.card_sendOTP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = et_verifyOTP.getText().toString().trim();

                if (code.isEmpty() || code.length() < 6) {
                    et_verifyOTP.setError("Enter Valid OTP");
                    et_verifyOTP.requestFocus();
                    return;
                }
                //verifying the code entered manually
                verifyVerificationCode(code);

                Log.d(TAG, "onClick: "+code);
            }
        });

    }

    private void verifyVerificationCode(String code) {

        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        Log.d(TAG, "verifyVerificationCode: "+credential);

        //signing the user
        signInWithPhoneCredential(credential);

    }

    private void signInWithPhoneCredential(PhoneAuthCredential credential) {

        Log.d(TAG, "signInWithPhoneCredential: ");

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(VerifyPhoneNoActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            Intent intent = new Intent(VerifyPhoneNoActivity.this, DashboardActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                        } else {

                            //verification unsuccessful.. display an error message

                            String message = "Somthing is Wrong";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid Code Entered...";
                            }
                        }
                    }
                });

    }

    /*
     * sending verification code and the country id is concatenated
     */
    private void sendVerificationCode(String mobile) {

        Log.d(TAG, "sendVerificationCode: "+mobile);

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobile,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                callBacks);
    }

    /*
    callback to detect the verification status
    */
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();

            Log.d(TAG, "onVerificationCompleted: "+code);

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                et_verifyOTP.setText(code);
                //verifying the code
                verifyVerificationCode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(VerifyPhoneNoActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            //storing the verification id that is sent to the user
            verificationId = s;
        }
    };

    public void hideKeyboard(View view) {

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);

    }
}
