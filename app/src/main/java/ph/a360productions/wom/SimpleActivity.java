package ph.a360productions.wom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by lai on 9/13/15.
 */
public class SimpleActivity extends Activity{
    Button button_cancel;

    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.offer_popup_window);

        //MySQLiteHelper db = new MySQLiteHelper(this);


        button_cancel = (Button) findViewById(R.id.cancel_buy_button);

        button_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);

            }

        });
    }

}
