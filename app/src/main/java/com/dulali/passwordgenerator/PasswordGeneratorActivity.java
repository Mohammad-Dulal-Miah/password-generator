package com.dulali.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;

import java.util.Random;

public class PasswordGeneratorActivity extends AppCompatActivity implements MaxAdListener
{

    //init all element
    EditText inputSize;
    TextView result;
    Button generator;
    CheckBox upper,lower,digit,symbol;
    ImageView copy;
    MediaPlayer mediaPlayer;
    private MaxAdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_generator);
        //four checkbox
        upper = findViewById(R.id.upper);
        lower = findViewById(R.id.lower);
        digit = findViewById(R.id.digit);
        symbol = findViewById(R.id.symbol);
        //one button
        generator = findViewById(R.id.generator);
        //text view and editText
        result = findViewById(R.id.result);
        inputSize = findViewById(R.id.inputSize);
        //image
        copy = findViewById(R.id.copy);

        mediaPlayer = new MediaPlayer();

        //This section work for copy the password
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData data = (ClipData) ClipData.newPlainText("text" ,result.getText());
                clipboard.setPrimaryClip(data);
                Toast.makeText(PasswordGeneratorActivity.this, "Password copied done", Toast.LENGTH_SHORT).show();
            }
        });

        generator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer = MediaPlayer.create(PasswordGeneratorActivity.this , R.raw.button);
                mediaPlayer.start();
                String size = inputSize.getText().toString();

                if(TextUtils.isEmpty(size)){
                    Toast.makeText(PasswordGeneratorActivity.this, "Please provide your password length...", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (Integer.parseInt(size) <= 200) {
                        boolean c1 = upper.isChecked();
                        boolean c2 = lower.isChecked();
                        boolean c3 = digit.isChecked();
                        boolean c4 = symbol.isChecked();


                        String lowerCase = "abcsdefghijklmnopqrstuvwxyz";
                        String number = "0123456789";
                        String symbol = "&%$#@!*";

                        int s = Integer.parseInt(size);

                        StringBuilder pass = new StringBuilder();
                        Random r = new Random();

                        if (c1 && c2 && c3 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(4);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));
                                } else if (num == 1) {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                } else if (num == 2) {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }

                            result.setText(pass);
                        } else if (c1 && c2 && c3) {
                            while (pass.length() != s) {
                                int num = r.nextInt(3);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));
                                } else if (num == 1) {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }
                            result.setText(pass);

                        } else if (c1 && c2 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(3);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));
                                } else if (num == 1) {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                } else {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                }
                            }

                            result.setText(pass);
                        } else if (c1 && c3 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(3);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));

                                } else if (num == 1) {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }

                            result.setText(pass);
                        } else if (c2 && c3 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(3);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                } else if (num == 1) {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }

                            result.setText(pass);
                        } else if (c1 && c2) {
                            while (pass.length() != s) {
                                int num = r.nextInt(2);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));
                                } else {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                }
                            }
                            result.setText(pass);
                        } else if (c1 && c3) {
                            while (pass.length() != s) {
                                int num = r.nextInt(2);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }

                            result.setText(pass);
                        } else if (c1 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(2);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    char a = lowerCase.charAt(index);
                                    pass.append(Character.toUpperCase(a));
                                } else {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                }
                            }
                            result.setText(pass);
                        } else if (c2 && c3) {
                            while (pass.length() != s) {
                                int num = r.nextInt(2);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }

                            result.setText(pass);
                        } else if (c2 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(2);
                                if (num == 0) {
                                    int index = r.nextInt(26);
                                    pass.append(lowerCase.charAt(index));
                                } else {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                }

                            }
                            result.setText(pass);
                        } else if (c3 && c4) {
                            while (pass.length() != s) {
                                int num = r.nextInt(4);
                                if (num == 0) {
                                    int index = r.nextInt(6);
                                    pass.append(symbol.charAt(index));
                                } else {
                                    int index = r.nextInt(10);
                                    pass.append(number.charAt(index));
                                }
                            }
                            result.setText(pass);
                        } else if (c1) {
                            while (pass.length() != s) {

                                int index = r.nextInt(26);
                                char a = lowerCase.charAt(index);
                                pass.append(Character.toUpperCase(a));
                            }


                            result.setText(pass);
                        } else if (c2) {
                            while (pass.length() != s) {

                                int index = r.nextInt(26);
                                pass.append(lowerCase.charAt(index));

                            }

                            result.setText(pass);
                        } else if (c3) {
                            while (pass.length() != s) {
                                int index = r.nextInt(10);
                                pass.append(number.charAt(index));
                            }
                            result.setText(pass);
                        } else if (c4) {
                            while (pass.length() != s) {
                                int index = r.nextInt(6);
                                pass.append(symbol.charAt(index));
                            }
                            result.setText(pass);
                        } else {
                            Toast.makeText(PasswordGeneratorActivity.this, "Please Fill the Checkbox...", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(PasswordGeneratorActivity.this, "Password size less than 201...", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        AppLovinSdk.getInstance( PasswordGeneratorActivity.this ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( PasswordGeneratorActivity.this, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
            }
        } );

        adView= findViewById(R.id.adView);
        adView.loadAd();

    }

    @Override
    public void onAdLoaded(MaxAd ad) {

    }

    @Override
    public void onAdDisplayed(MaxAd ad) {

    }

    @Override
    public void onAdHidden(MaxAd ad) {

    }

    @Override
    public void onAdClicked(MaxAd ad) {

    }

    @Override
    public void onAdLoadFailed(String adUnitId, MaxError error) {

    }

    @Override
    public void onAdDisplayFailed(MaxAd ad, MaxError error) {

    }
}