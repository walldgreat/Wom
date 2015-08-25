package ph.a360productions.wom; /**
 * Created by lai on 8/24/15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Books table name
    private static final String TABLE_OFFERS = "offers";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    //private static final String KEY_TITLE = "title";
    //private static final String KEY_AUTHOR = "author";

    private static final String KEY_BRAND = "brand";
    private static final String KEY_OFFER_NAME = "offer_name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_OFFER="offer";
    private static final String KEY_VALIDITY="validity";
    private static final String KEY_KEYWORD = "keyword";
    private static final String KEY_ACCESS_CODE = "access_code";

    private static final String[] COLUMNS = {KEY_ID,KEY_BRAND, KEY_OFFER_NAME, KEY_DESCRIPTION, KEY_OFFER, KEY_KEYWORD, KEY_ACCESS_CODE};


    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "OffersDB";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_OFFER_TABLE = "CREATE TABLE offers ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "brand TEXT, "+
                "offer_name TEXT, "+
                "description TEXT, "+
                "price TEXT, "+
                "validity TEXT, "+
                "keyword TEXT, "+
                "access_code TEXT) ";


        // create books table
        db.execSQL(CREATE_OFFER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS offers");

        // create fresh books table
        this.onCreate(db);
    }


    public void addOffer(Offer offer){
        //for logging
        Log.d("addOffer", offer.toString());

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        //values.put(KEY_TITLE, book.getTitle()); // get title
        //values.put(KEY_AUTHOR, book.getAuthor()); // get author
    values.put(KEY_BRAND      , offer.getBrand());
    values.put(KEY_OFFER_NAME , offer.getOffer_name());
    values.put(KEY_DESCRIPTION, offer.getDescription());
    values.put(KEY_OFFER      , offer.getPrice());
    values.put(KEY_VALIDITY   , offer.getValidity());
    values.put(KEY_KEYWORD    , offer.getKeyword     ());
    values.put(KEY_ACCESS_CODE, offer.getAccess_code ());
        // 3. insert
        db.insert(TABLE_OFFERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public Offer getOffer(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_OFFERS, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        Offer offer = new Offer();
        offer.setId(Integer.parseInt(cursor.getString(0)));

        offer.setBrand(cursor.getString(1));
        offer.setOffer_name(cursor.getString(2));
        offer.setDescription(cursor.getString(3));
        offer.setPrice(cursor.getString(4));
        offer.setValidity(cursor.getString(5));
        offer.setKeyword(cursor.getString(6));
        offer.setAccess_code(cursor.getString(7));



        //log
        Log.d("getOffer(" + id + ")", offer.toString());

        // 5. return book
        return offer;
    }
}
