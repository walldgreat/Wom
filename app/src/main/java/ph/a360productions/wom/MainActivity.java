package ph.a360productions.wom;


import android.content.Intent;

import android.text.TextUtils;
import android.view.LayoutInflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Context;

import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.List;


public class MainActivity extends AppCompatActivity {
    boolean isTestingAds = true;
    MySQLiteHelper db;
    List<Offer> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ad: start
        // Create a banner ad
        //AdView mAdView = new AdView(this);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        //mAdView.setAdSize(AdSize.SMART_BANNER);
        //mAdView.setAdUnitId("myAdUnitId");

        // Create an ad request.
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

        if (isTestingAds) {

            // Optionally populate the ad request builder.
            adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        }

        // Start loading the ad.
        mAdView.loadAd(adRequestBuilder.build());
        //ad: end

        db = new MySQLiteHelper(this);


        list = db.getAllOffers();

        /*
        for(int i=0; i<list.size();i++)
        {
            Log.d("verlin",list.get(i).getDescription());
            Log.d("verlin", list.get(i).getPrice());
            Log.d("verlin", list.get(i).getOffer_name());

        }
        */
        //Log.d("verlin", list.toString());

        TableLayout mTlayout =
                (TableLayout) findViewById(R.id.tablelayout1);


        View view[] = new View[100];
        int i;
        TextView mProductName1, mDescription1, mPrice1;
        TextView mProductName2, mDescription2, mPrice2;
        Button mButton1, mButton2;


        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (i = 0; i < list.size(); i = i + 2)

        {
            view[i] = inflater.inflate(R.layout.tablerowlayout, null);
            mProductName1 = (TextView) view[i].findViewById(R.id.textViewProductName1);
            mProductName1.setText(list.get(i).getOffer_name());
            mDescription1 = (TextView) view[i].findViewById(R.id.textViewDescription1);
            mDescription1.setText(list.get(i).getDescription());
            mDescription1.setMaxLines(3);
            mDescription1.setEllipsize(TextUtils.TruncateAt.END);
            //mDescription1.setHorizontallyScrolling(true);
            mPrice1 = (TextView) view[i].findViewById(R.id.textViewPrice1);
            mPrice1.setText(list.get(i).getPrice());
            mButton1 = (Button) view[i].findViewById(R.id.buttonBuy1);
            mButton1.setTag(list.get(i).getId());
            //mButton1.setOnClickListener(onClickListener);
            addListenerOnButton(mButton1);
            //mButton1.setTag(i);

            try {
                mProductName2 = (TextView) view[i].findViewById(R.id.textViewProductName2);
                mProductName2.setText(list.get(i + 1).getOffer_name());
                mDescription2 = (TextView) view[i].findViewById(R.id.textViewDescription2);
                mDescription2.setText(list.get(i + 1).getDescription());
                mDescription2.setMaxLines(3);
                mDescription2.setEllipsize(TextUtils.TruncateAt.END);
                mPrice2 = (TextView) view[i].findViewById(R.id.textViewPrice2);
                mPrice2.setText(list.get(i + 1).getPrice());
                mButton2 = (Button) view[i].findViewById(R.id.buttonBuy2);
                mButton2.setTag(list.get(i + 1).getId());
                //mButton2.setOnClickListener(onClickListener);
                addListenerOnButton(mButton2);
            } catch (Exception e) {
// quick dirty way to avoid problem
            }

            mTlayout.addView(view[i]);
        }


    }

    public void addListenerOnButton(final Button mButton_parm) {

        final Context context = this;

        //button = (Button) findViewById(R.id.button1);

        mButton_parm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int i = (int) mButton_parm.getTag() - 1;

//                Log.d("verlin_lai:", mButton_parm.getTag().toString());

//                Log.d("verlin_lai:", list.get((int) mButton_parm.getTag()).getDescription());
                Intent intent = new Intent(context, SimpleActivity.class);
                intent.putExtra("Description", list.get(i).getDescription());
                intent.putExtra("Offer", list.get(i).getOffer_name());
                intent.putExtra("Price", list.get(i).getPrice());
                intent.putExtra("Validity", list.get(i).getValidity());
                startActivity(intent);


            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}// end class
