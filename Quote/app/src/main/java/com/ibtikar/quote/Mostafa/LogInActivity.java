package com.ibtikar.quote.Mostafa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.ibtikar.quote.Abdalla.MyMainActivity;
import com.ibtikar.quote.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends Activity {


    private LoginButton loginButton;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MY KEY HASH:", "ac");

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        FacebookSdk.sdkInitialize(getApplicationContext());

        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_log_in);
        Log.e("MY KEY HASH:", "hello");


        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        loginButton.setReadPermissions("email");
        Log.e("MY KEY HASH:", "ac");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {


                Log.e("MY KEY HASH:", "ac");

                loginButton.setBackgroundResource(R.drawable.facebook_icon);


                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {

                                String email = null;
                                try {
                                    email = object.getString("email");
                                    // image.setProfileId(object.getString("id"));
                                    String id = object.getString("id");

                                    //  Picasso.with(MainActivity.this).load("https://graph.facebook.com/" + id + "/picture?type=large").into(cir);

                                    Intent intent = new Intent(LogInActivity.this , MyMainActivity.class);
                                    startActivity(intent);


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // emailInfo.setText(email);

                                Log.v("LoginActivity", response.toString());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,email,name");
                request.setParameters(parameters);
                request.executeAsync();

            }

            @Override
            public void onCancel() {

                                Log.e("MY KEY HASH:", "cancel");

            }

            @Override
            public void onError(FacebookException e) {

                                Log.e("MY KEY HASH:", "error");

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
