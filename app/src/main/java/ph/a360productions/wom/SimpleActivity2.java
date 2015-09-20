package ph.a360productions.wom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lai on 9/19/15.
 */
public class SimpleActivity2 extends Activity {

    Button button_cancel;
    TextView mTv;

    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.success_popup);

        Handler handler = new Handler();
        Runnable r=new Runnable() {
            @Override
            public void run() {
                finish();

            }
        };
        handler.postDelayed(r, 5000);


    }
}
