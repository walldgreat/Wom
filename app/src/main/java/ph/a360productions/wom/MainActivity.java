package ph.a360productions.wom;

import android.content.Intent;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.telephony.gsm.GsmCellLocation;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TableLayout mTlayout;
    String[] mTextofButton = { "Dipak", "E", "I", "J", "L",
            "M", "G", "R", "N", "T", "H", "P",
            "K", "Y", "V" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySQLiteHelper db = new MySQLiteHelper(this);

           db.addOffer(
                   new Offer("SMART",
                           "ALL TXT 20", " 4 day of unli txt to all network that you cant text",
                           "20.00", "5 days", "ALLTXT20", "234") );
        List<Offer> list = db.getAllOffers();
        Log.d("verlin", list.toString());
// programmatic start
        /*
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

       setHeader(this, layout);
        setBody(this, layout);

        setContentView(layout);
*/
        /*
        TableLayout mTlayout =
                (TableLayout) findViewById(R.id.mTlayout1);
        //mTlayout.removeAllViewsInLayout();


        TableRow tr=new TableRow(this);
        for(int i=0;i<mTextofButton.length;i++){
            Button btn=new Button(this);
            btn.setText(mTextofButton[i]);
            tr.addView(btn);

        }
        mTlayout.addView(tr);
        */
        //programmati end


    }

    private  boolean setBody(Context context, LinearLayout rlx) {
        String[] row = { "ROW1", "ROW2", "Row3", "Row4", "Row 5", "Row 6",
                "Row 7" };
        String[] column = { "Brand", "Product","Description",  "Price", "Validity"};


        int rl=row.length;
        int cl = column.length;

        Log.d("--", "R-Lenght--" + rl + "   " + "C-Lenght--" + cl);


        LinearLayout.LayoutParams params = new
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );

        /*
        LinearLayout rlx = new LinearLayout(context);
        rlx.setOrientation(LinearLayout.VERTICAL);
        */

        //RelativeLayout rlx = new RelativeLayout(context);


        ScrollView sv = new ScrollView(context);
        sv.setLayoutParams(params);

        TableLayout tableLayout = createTableLayout(row, column,rl, cl);
        tableLayout.setLayoutParams(params);

        HorizontalScrollView hsv = new HorizontalScrollView(context);
        hsv.setLayoutParams(params);

        hsv.addView(tableLayout);
        sv.addView(hsv);
        rlx.addView(sv);
        //rlx.addView(sv);
        // creating LayoutParams
        //ll.addView(rlx);
        //setHeader(ll.getContext());
        //setHeader(this);
        //setContentView(ll);
        // create params for widgets
        // now create layout params
        /*
        LinearLayout.LayoutParams layoutParam = new
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );
        rlx.setLayoutParams(params);

// now add the layout
        //this.addContentView(rlx, layoutParam);
        this.addContentView(rlx, layoutParam);
        */
        return true;
    }
    private boolean setHeader(Context context, LinearLayout layout)
    {

// create params for widgets
        LinearLayout.LayoutParams params = new
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

// create layout
        /*
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        */

//create a button
        Button btn = new Button(context);
        btn.setText("Click Me");
        btn.setLayoutParams(params);

//create text view widget
        TextView tv = new TextView(context);
        tv.setText("Hello World!! AGAIN!!");
        tv.setLayoutParams(params);

//add button to layout
        layout.addView(btn);

//add textview to layout
        layout.addView(tv);
/*
// now create layout params
        LinearLayout.LayoutParams layoutParam = new
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );


// now add the layout
        this.addContentView(layout, layoutParam);
*/

        return true;


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
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Log.d("CameraDemo", "Pic saved");


        }
    }
    */

    public void makeCellEmpty(TableLayout tableLayout, int rowIndex, int columnIndex) {
        // get row from table with rowIndex
        TableRow tableRow = (TableRow) tableLayout.getChildAt(rowIndex);

        // get cell from row with columnIndex
        TextView textView = (TextView)tableRow.getChildAt(columnIndex);

        // make it black
        textView.setBackgroundColor(Color.BLACK);
    }


    public void setHeaderTitle(TableLayout tableLayout, int rowIndex, int columnIndex){

        // get row from table with rowIndex
        TableRow tableRow = (TableRow) tableLayout.getChildAt(rowIndex);

        // get cell from row with columnIndex
        TextView textView = (TextView)tableRow.getChildAt(columnIndex);

        textView.setText("Hello");
    }

    private TableLayout createTableLayout(String [] rv, String [] cv,int rowCount, int columnCount) {
        // 1) Create a tableLayout and its params
        TableLayout.LayoutParams tableLayoutParams = new TableLayout.LayoutParams();
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setBackgroundColor(Color.BLACK);

        // 2) create tableRow params
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(1, 1, 1, 1);
        tableRowParams.weight = 1;

        for (int i = 0; i < rowCount; i++) {
            // 3) create tableRow
            TableRow tableRow = new TableRow(this);
            tableRow.setBackgroundColor(Color.BLACK);

            for (int j= 0; j < columnCount; j++) {
                // 4) create textView
                TextView textView = new TextView(this);
                //  textView.setText(String.valueOf(j));
                textView.setBackgroundColor(Color.WHITE);
                textView.setGravity(Gravity.CENTER);

                String s1 = Integer.toString(i);
                String s2 = Integer.toString(j);
                String s3 = s1 + s2;
                int id = Integer.parseInt(s3);
                Log.d("TAG", "-___>"+id);
                if (i ==0 && j==0){
                    textView.setText("XXXX'");
                } else if(i==0){
                    Log.d("TAAG", "set Column Headers");
                    textView.setText(cv[j-1]);
                }else if( j==0){
                    Log.d("TAAG", "Set Row Headers");
                    textView.setText(rv[i-1]);
                }else {
                    textView.setText(""+id);
                    // check id=23
                    if(id==23){
                        textView.setText("ID=23");

                    }
                }

                // 5) add textView to tableRow
                tableRow.addView(textView, tableRowParams);
            }

            // 6) add tableRow to tableLayout
            tableLayout.addView(tableRow, tableLayoutParams);
        }

        return tableLayout;
    }
}// end class

/*
{

        final TextView textElement = (TextView) findViewById(R.id.header1);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                TelephonyManager telm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                GsmCellLocation cellLocation = (GsmCellLocation) telm.getCellLocation();

                String new_cid = String.valueOf(cellLocation.getCid() & 0xffff);
                String new_lac = String.valueOf(cellLocation.getLac() & 0xffff);


                textElement.setText("cid=" + new_cid + " lac=" + new_lac);
            }
        });
        // balance inquiry
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("211", null, "BILL?", null, null);


                //TextView textElement = (TextView) findViewById(R.id.header1);
                textElement.setText("Message sent!");
            }
        });

        // balance inquiry
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click


                preview.camera.takePicture(shutterCallback, rawCallback,
                        jpegCallback);
                textElement.setText("Picture Taken!");
            }
        });


}
        */

