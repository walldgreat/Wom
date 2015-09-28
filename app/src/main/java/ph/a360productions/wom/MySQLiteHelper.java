package ph.a360productions.wom; /**
 * Created by lai on 8/24/15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

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
    private static final String KEY_PRICE="price";
    private static final String KEY_VALIDITY="validity";
    private static final String KEY_KEYWORD = "keyword";
    private static final String KEY_ACCESS_CODE = "access_code";

    private static final String[] COLUMNS = {KEY_ID,KEY_BRAND, KEY_OFFER_NAME, KEY_DESCRIPTION, KEY_PRICE, KEY_KEYWORD, KEY_ACCESS_CODE};


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
                "brand TEXT, " +
                "offer_name TEXT, " +
                "description TEXT, " +
                "price TEXT, " +
                "validity TEXT, " +
                "keyword TEXT, " +
                "access_code TEXT) ";


        // create books table
        db.execSQL(CREATE_OFFER_TABLE);
        try {

            ContentValues values = new ContentValues();
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 25','Unlimited calls to Smart/TNT Unlimited texts to Smart/TNT/Sun 50 texts to all networks FREE chat & surf (up to 15MB)','25.00','1 day','UNLI25','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 30 Plus','Unlimited calls to Smart/Sun/TNT Unlimited texts to all networks Free Spinnr & Surf (up to 100MB)','30.00','1 day','UNLI30','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 35','Unlimited calls and texts to Smart/TNT/Sun 150 texts to all networks','35.00','1 day','UNLI35','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 50','Unlimited calls to Smart/TNT/Sun Unlimited texts to all networks 50 MB of surfing','50.00','3 days','UCT50','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 100','Unlimited calls and texts to Smart/TNT 80 texts to all networks','100.00','4 days','UNLI100','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 150','Unlimited calls and texts to Smart/TNT 100 texts to all networks','150.00','7 days','UNLI150','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 200','Unlimited calls and texts to Smart/TNT 500 texts to all networks','200.00','7 days','UNLI200','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 299','Unlimited calls and texts to Smart/TNT 150 texts to all networks','299.00','15 days','UNLI299','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 400','Unlimited calls and texts to Smart/TNT 1000 texts to all networks','400.00','15 days','UNLI400','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 600','Unlimited calls and texts to Smart/TNT 2000 texts to all networks','600.00','30 days','UNLI600','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call 20','Unlimited calls to Smart/TNT Unlimited Twitter 20 texts to all networks FREE internet','20.00','1 day','UNLI20','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 15','Unlimited texts to Smart/TNT/Sun','15.00','1 day','TRINET15','2477')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 30','10MB 200 All-net texts 50 minute calls','30.00','1 day','TRINET30','2477')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 40','Unlimited call and texts to Smart/TNT/Sun Unli Facebook','40.00','1 day','TRINET40 to 2949','2477')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 100','35MB 750 All-net texts 120 minute calls','100.00','7 days','TRINET100','2477')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 200','75MB 1500 All-net texts 250 minute calls','200.00','15 days','TRINET200','2477')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 300','30MB Unli text to Smart/TNT/Sun 300 minute calls 3 Hours mobile internet for Sun','300.00','30 days','TRINET300','2477')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Smartalk 100','Unli calls to Smart/TNT','100.00','5 days','TALK100','6400')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Smartalk 500','Unli calls to Smart/TNT','500.00','30 days','TALK500','6400')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Lahatxt 20','250 SMS to all networks 10 mins calls to Smart/TNT','20.00','1 day','L20','2266')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Lahatxt 30','300 SMS to all networks 20 mins calls to Smart/TNT','30.00','2 days','L30','2266')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Text P15','All net text','15.00','2 days','JUMPTXT15','5867')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Out P15','10MB 30 mins TRI-NET calls to 5 Smart/TNT/Sun Unlimited texts to all networks FREE Unli Facebook','15.00','1 day','JUMP15','5867')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Out P25','10MB 30 mins TRI-NET calls to 5 Smart/TNT/Sun Unlimited texts to all networks FREE Unli Facebook','25.00','2 days','JUMP15','5867')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Out P50','10MB 30 mins TRI-NET calls to 5 Smart/TNT/Sun Unlimited texts to all networks FREE Unli Facebook','50.00','5 days','JUMP50','5867')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Unli Text 50','Unlimited tri-net texts','50.00','7 days','TEXT50','6406 SMART','Big Unli Text 100','Unlimited tri-net texts','100.00','15 days','TEXT100','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Unli Text 200','Unlimited tri-net texts','200.00','30 days','TEXT200','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Calls 100','200 minutes of calls to Smart/TNT','100.00','7 days','CALL100','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Calls 200','450 minutes of calls to Smart/TNT','200.00','15 days','CALL200','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Calls 400','950 minutes of calls to Smart/TNT','200.00','30 days','CALL400','6406')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 15','150 texts to all networks and 5 minutes calls to Smart/TNT','15.00','1 day','AT15','2827')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 20','Unli All-net texts',' plus 20 minutes of calls to Smart/TNT','20.00','1 day','AT20','2827')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 30','Unli All-net texts',' plus 30 minutes of calls to Smart/TNT','30.00','2 days','AT30','2827')");
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All-Net SOS','On-Net OR All-Net SMS','3 SMART-to-SMART/TNT texts with P1.00-airtime 4 texts to all networks with P1.00 airport','','Dial *7572 to avail','2827')");


        }
        catch (Exception e) {


        }
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
    values.put(KEY_PRICE     , offer.getPrice());
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
                        new String[]{String.valueOf(id)}, // d. selections args
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
    public List<Offer> getAllOffers() {
        List<Offer> offers = new LinkedList<Offer>();

        // 1. build the query
        // ORDER BY CAST(`pic_number` AS SIGNED)
        String query = "SELECT  * FROM " + TABLE_OFFERS + " ORDER BY cast ('" + KEY_PRICE +"'as DECIMAL )";

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        Offer offer = null;
        if (cursor.moveToFirst()) {
            do {
                offer = new Offer();
                offer.setId(Integer.parseInt(cursor.getString(0)));
                offer.setBrand(cursor.getString(1));
                offer.setOffer_name(cursor.getString(2));
                offer.setDescription(cursor.getString(3));
                offer.setPrice(cursor.getString(4));
                offer.setValidity(cursor.getString(5));
                offer.setKeyword(cursor.getString(6));
                offer.setAccess_code(cursor.getString(7));
                //book.setTitle(cursor.getString(1));
                //book.setAuthor(cursor.getString(2));

                // Add book to books
                offers.add(offer);
            } while (cursor.moveToNext());
        }

        Log.d("getAllOffers()", offers.toString());

        // return books
        return offers;
    }

    public int updateOffer(Offer offer) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
       // values.put("title", book.getTitle()); // get title
        //values.put("author", book.getAuthor()); // get author
        values.put("brand",offer.getBrand());
        values.put("offer_name", offer.getOffer_name());
        values.put("description", offer.getDescription());
        values.put("price", offer.getPrice());
        values.put("validity", offer.getValidity());
        values.put("keyword", offer.getKeyword());
        values.put("access_code", offer.getAccess_code());

        // 3. updating row
        int i = db.update(TABLE_OFFERS, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(offer.getId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    public void deleteOffer(Offer offer) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_OFFERS, //table name
                KEY_ID+" = ?",  // selections
                new String[] { String.valueOf(offer.getId()) }); //selections args

        // 3. close
        db.close();

        //log
        Log.d("deleteOffer", offer.toString());

    }
}
