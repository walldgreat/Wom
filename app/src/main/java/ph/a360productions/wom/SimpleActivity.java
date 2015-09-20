package ph.a360productions.wom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lai on 9/13/15.
 */
public class SimpleActivity extends Activity{
    Button button_cancel, button_confirm;
    TextView mTv;

    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer_popup_window);

        //MySQLiteHelper db = new MySQLiteHelper(this);


        button_cancel = (Button) findViewById(R.id.cancel_buy_button);
        button_confirm = (Button) findViewById(R.id.confirm_buy_button);
        mTv = (TextView) findViewById(R.id.confirm_textview);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String mDescription= bundle.getString("Description");
        String mOffer= bundle.getString("Offer");
        String mPrice= bundle.getString("Price");
        String mValidity= bundle.getString("Validity");
        mTv.setText("You are buying:\n\n" +
                        "Product: "+ mOffer + "\n" +
                        "Description: "+  mDescription  +"\n" +
                        "Validity: " + mValidity + "\n\n" +
                        "Price: " + mPrice
        );

        button_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                /*Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);*/


                finish();

            }

        });
        button_confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                // start
                Intent intent = new Intent(context, SimpleActivity2.class);
                startActivity(intent);
                finish();
                // end






            }

        });
    }

}
