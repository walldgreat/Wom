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
            /*
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

            */
            db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 30','Call - Smart, TNT, Sun Text - All Networks.; Voice:Yes ; SMS: Yes; DATA: Free Chat/Surf (15 mb)','30','1','UNLI30 ','6406')");


db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 299','Call - Smart, TNT Text - Smart, TNT Free Text 150 - All Networks.; Voice:Yes ; SMS: Yes; DATA: No','299','15','UNLI299 ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 25','Call - Smart, TNT Text - Smart, TNT, Sun Free Text 50 - All Networks.; Voice:Yes ; SMS: Yes; DATA: Free Chat/Surf (15 mb)','25','1','Unli Call & Text 25','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 200','Call - Smart, TNT Text - Smart, TNT Free Text 500 - All Networks.; Voice:Yes ; SMS: Yes; DATA: No','200','7','UNLI200 ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 150','Call - Smart, TNT Text - Smart, TNT Free Text 100 - All Networks.; Voice:Yes ; SMS: Yes; DATA: No','150','7','UNLI150','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 100','Call - Smart, TNT Text - Smart, TNT Free Text 80 - All Networks.; Voice:Yes ; SMS: Yes; DATA:   No','100','4','UNLI100 ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 400','Call - 50 mins Smart, Sun, TNT Text 3000 - All Networks.; Voice:No ; SMS: No; DATA: 35 mb','400','30','TRINET400 ','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 40','Call - Smart, Sun, TNT Text - Smart, Sun, TNT.; Voice:Yes ; SMS: Yes; DATA: Unli FB (mobile)','40','1','TRINET40 ','2949')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 300','Call - 300 min Smart,Sun,TNT Text - Smart,TNT,Sun.; Voice:Yes ; SMS: No; DATA: 30 mb','300','30','TRINET300 ','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 200','Call - 250 min Smart,Sun,TNT Text 1500 - All Networks.; Voice:No ; SMS: No; DATA: 75 mb','200','15','TRINET200 ','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 15','NA.; Voice:NA ; SMS: NA; DATA: NA','15','1','TRINET 15 ','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TRI-NET 100','Text 750 - All Networks Call - 120 mins Smart,Sun,TNT.; Voice:No ; SMS: No; DATA: 35 mb','100','7','TRINET100 ','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','TOTAL 20','Text 20 - All Networks Call - 20 mins Smart, Sun, TNT.; Voice:No ; SMS: No; DATA: No','20','1','TOTAL20','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Super Messaging 10','Not available.; Voice:No ; SMS: No; DATA: Chat, Call via FB Messenger, Viber, WhatsApp, Wechat & Line','10','1','SUPER10 ','9999')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','STICKERTXT','Sending text with stickers.; Voice:No ; SMS: No; DATA: No','NA','NA','STICKERS ','8009')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Smartalk 500','Call - Smart, TNT.; Voice:Yes ; SMS: Yes; DATA: No','500','30','STICKERS','6400')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Smartalk 100','Call - Smart, TNT.; Voice:Yes ; SMS: Yes; DATA: No','100','5','STICKERS','6400')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Lahatxt 30','Call - 20 mins Smart, TNT Text 300 - All Networks.; Voice:No ; SMS: No; DATA: No','30','2','STICKERS','2266')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Lahatxt 20','Call - 10 mins Smart, TNT Text 250 - All Networks.; Voice:No ; SMS: No; DATA: No','20','1','STICKERS ','2266')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Call, Text & Music 15','Text 150 - All Networks Call - 5 mins Smart, TNT.; Voice:No ; SMS: No; DATA: Unli Music streaming Spinnr','15','1','STICKERS ','2266')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Unli Text 50','Text - Smart, TNT, Sun.; Voice:Yes ; SMS: No; DATA: No','50','7','STICKERS ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Unli Text 200','Text - Smart, TNT, Sun.; Voice:Yes ; SMS: No; DATA: No','200','30','STICKERS','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Unli Text 100','Text - Smart, TNT, Sun.; Voice:Yes ; SMS: No; DATA: No','100','15','STICKERS ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Calls 400','Call - 950 mins TNT, Smart.; Voice:No ; SMS: No; DATA: No','400','30','STICKERS ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Big Calls 100','Call - 200 mins TNT, Smart.; Voice:No ; SMS: No; DATA: No','100','7','STICKERS ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All-Net SOS','4 Free text All Networks & 1 peso load.; Voice:No ; SMS: No; DATA: No','5','1','STICKERS','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Smart/TNT SOS','3 Free text Smart/TNT & 1 peso load.; Voice:No ; SMS: No; DATA: No','4','1','STICKERS','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 30','Text - All Networks Call - 30 mins Smart, TNT.; Voice:Yes ; SMS: No; DATA: No','30','2','STICKERS ','2827')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 20','Text - All Networks Call - 20 mins Smart, TNT.; Voice:Yes ; SMS: No; DATA: Free chat & surf','20','1','STICKERS ','2827')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 15','Text 150 - All Networks Call - 5 mins Smart, TNT.; Voice:No ; SMS: No; DATA: No','15','1','STICKERS','2827')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Text 100','Text - All Networks Call 100 minutes Smart, TNT.; Voice:Yes ; SMS: No; DATA: No','100','7','STICKERS','2827')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All In 99','Text - All Networks Call 100 minutes Smart, TNT, Sun.; Voice:Yes ; SMS: No; DATA: 80 MB and Unli Facebook','99','7','STICKERS','2827')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Day Opera Mini 1 Day','Smart, TNT, Infinity.; Voice:No ; SMS: No; DATA: Yes','15','1','STICKERS','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Day Opera Mini 5 Days','Smart, TNT, Infinity.; Voice:No ; SMS: No; DATA: Yes','60','5','STICKERS ','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Day Opera Mini 7 Days','Smart, TNT, Infinity.; Voice:No ; SMS: No; DATA: Yes','80','7','STICKERS','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Day Opera Mini 15 Days','Smart, TNT, Infinity.; Voice:No ; SMS: No; DATA: Yes','160','15','STICKERS ','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All Day Opera Mini 30 Days','Smart, TNT, Infinity.; Voice:No ; SMS: No; DATA: Yes','299','30','STICKERS','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','All-in 25','60 min calls Smart/Tnt/Sun.; Voice:Yes ; SMS: No; DATA: 10 mb','25','1','STICKERS ','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Unli Call & Text 25','unlimited calls to SMART/TNT, unlimited texts to SMART/TNT/SUN, 50 texts to all networks.; Voice:Yes ; SMS: Yes; DATA: FREE chat & surf (up to 15MB)','25','1','STICKERS ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Barkada WeChat ','-.; Voice:No ; SMS: No; DATA: WeChat Messaging*','10','1','STICKERS ','2200')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Barkada ChatAll','-.; Voice:No ; SMS: No; DATA: Chat all to Line, WeChat, WhatsApp and Facebook Messenger','299','30','STICKERS ','2200')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Fb2','-.; Voice:No ; SMS: No; DATA: Unli Facebook','2','1','STICKERS ','6406')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Text P15','-.; Voice:Yes ; SMS: No; DATA: No','15','2','STICKERS ','5867')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Out P15','30 mins TRI-NET calls to 5 Smart/TNT/Sun.; Voice:Yes ; SMS: No; DATA: 10MB, FREE Unli Facebook','15','1','STICKERS ','5867')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Out P25','30 mins TRI-NET calls to 5 Smart/TNT/Sun.; Voice:Yes ; SMS: No; DATA: 10MB, FREE Unli Facebook','25','2','STICKERS ','5867')");
db.execSQL("INSERT INTO offers VALUES(null ,'SMART','Jump All Out P50','30 mins TRI-NET calls to 5 Smart/TNT/Sun.; Voice:Yes ; SMS: No; DATA: 10MB, FREE Unli Facebook','50','5','STICKERS ','5867')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Unlimited 25','Text - All Network Call - Sun only.; Voice:Yes ; SMS: Yes; DATA: Unlimited Facebook','25','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Unlimited 30','Text - All Network Call - Sun, Smart, TNT.; Voice:Yes ; SMS: Yes; DATA: Unlimited Facebook','30','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Unlimited 100','Text - All Network Call - Sun, Smart, TNT.; Voice:Yes ; SMS: Yes; DATA: Unlimited Facebook','100','5','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Unlimited 150','Text - All Network Call - Sun, Smart, TNT +25 free regular load.; Voice:Yes ; SMS: Yes; DATA: Unlimited Facebook','150','7','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Unlimited 450','Text - All Network Call - Sun, Smart, TNT +50 free regular load.; Voice:Yes ; SMS: Yes; DATA: Unlimited Facebook','450','30','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Combo 10','50 Texts All Networks 50 Texts Sun 10 mins call Sun, Smart, TNT.; Voice:No ; SMS: No; DATA: 10 mins mobile internet','10','1','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Combo 20','100 Text All Networks 100 Texts to Sun 25 mins call Sun, Smart, TNT.; Voice:No ; SMS: No; DATA: No','20','2','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Combo 50','250 Text All Networks 250 Texts to Sun 70 mins call Sun, Smart, TNT.; Voice:No ; SMS: No; DATA: Nonstop Chat (Viber, WeChat, LINE)','50','5','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Combo 150','750 Text All Networks 750 Texts to Sun 250 mins call Sun, Smart, TNT.; Voice:No ; SMS: No; DATA: NO','150','15','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Winner Text 10','Text - Sun only Call - 10 mins Sun, Smart, TNT.; Voice:Yes ; SMS: No; DATA: 10 mins mobile internet','10','1','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text Unlimited 20','Text - Sun only Call - 20 mins Sun only.; Voice:Yes ; SMS: No; DATA: No','20','2','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text Unlimited 50','Text - Sun only Call - 60 mins Sun only.; Voice:Yes ; SMS: No; DATA: No','50','7','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text Unlimited 60','Text - Sun only Call - 60 mins Sun, Smart, TNT 200 Free Texts All Networks.; Voice:Yes ; SMS: No; DATA: No','60','7','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text Unlimited 150','Text - Sun only Call - 40 hours Sun only.; Voice:Yes ; SMS: No; DATA: No','150','30','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Power Text Unlimited 200','Text - Sun only Call - 40 hours Sun only 1000 text All Networks.; Voice:Yes ; SMS: No; DATA: No','200','30','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text Unlimited 300','Text - Sun only Call - 5 hours Sun, Smart, TNT 1500 Free Texts All Networks.; Voice:Yes ; SMS: No; DATA: No','300','30','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text All 15','Text - All Networks.; Voice:Yes ; SMS: No; DATA: Unlimited Facebook','15','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text All 20','Text - All Networks.; Voice:Yes ; SMS: No; DATA: No','20','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text All 30','Text - All Networks.; Voice:Yes ; SMS: No; DATA: Unlimited Facebook','30','3','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text All Plus 25','Text - All Networks Call - 60 mins Sun call only.; Voice:Yes ; SMS: No; DATA: 30 mins mobile internet','25','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Text All Plus 100','Text - All Networks Call - 60 mins Sun call only.; Voice:Yes ; SMS: No; DATA: 60 mins mobile internet','100','7','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Unli Trio 20','Text - Sun, Smart, TNT.; Voice:Yes ; SMS: No; DATA: Unlimited Facebook','20','2','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Unli Trio 30','Text - Sun, Smart, TNT Call - 30 mins call Sun, TNT, Smart.; Voice:Yes ; SMS: No; DATA: Unlimited Facebook','30','3','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Call & Text Combo 10','50 Sun Texts 50 Text to All Networks 10 mins call Smart, Sun, TNT.; Voice:No ; SMS: No; DATA: 10 mins of mobile internet + 1Day music streaming at Spinnr & 1 free song download','15','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Winner Text 10 + Spinnr','Text - Sun only Call - 10 mins Smart, Sun, TNT.; Voice:Yes ; SMS: No; DATA: 10 mins of mobile internet + 1Day music streaming at Spinnr & 1 free song download','15','1','STICKERS','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'SUN','Sun Call Text & Music 15','Text 150 - All networks Call - 5 mins Sun only.; Voice:No ; SMS: No; DATA: 1 Day FREE Music Streaming ','15','1','STICKERS ','247')");
db.execSQL("INSERT INTO offers VALUES(null ,'0','Promo Name','Unlimited.; Voice:Text ; SMS: Call; DATA: Internet','Cost (Pesos)','Validity day[s]','STICKERS ','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan Txt 10','No.; Voice:100 SMS/ MMS to TNT/Smart, +10 SMS to All Networks ; SMS: No; DATA: No','10','1','STICKERS ','8855')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan Txt 20','No.; Voice:200 Texts to All Networks ; SMS: No; DATA: No','20','2','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unli Txt 10','Yes (Text).; Voice:Unlitext to TNT/Smart ; SMS: No; DATA: No','10','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Sangka tutex 15','No.; Voice:2 Days 200 Texts to TNT/Smart ; SMS: No; DATA: No','15','2','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Sangka tutex 60','No.; Voice:7 Days 1000 Texts to TNT/Smart ; SMS: No; DATA: No','60','7','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unli Txt 150','Yes (Text).; Voice:Unlitext to TNT/Smart ; SMS: No; DATA: No','150','30','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Sangka tutok 15','No.; Voice:No ; SMS: 20 Mins Call to TNT/Smart; DATA: No','15','2','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Sangka tutok 30','No.; Voice:No ; SMS: 45 Mins Call to TNT/Smart; DATA: No','30','4','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Patok-O-Tex15','No.; Voice:P0.50  Text Rate to TNT/Smart ; SMS: P0.50 Call Rate to TNT/Smart; DATA: No','15','1','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Patok-O-Tex20','No.; Voice:P0.50  Text Rate to TNT/Smart ; SMS: P0.50 Call Rate to TNT/Smart; DATA: No','20','1','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Patok- O-Tex 30','No.; Voice:P0.50  Text Rate to TNT/Smart ; SMS: P0.50 Call Rate to TNT/Smart; DATA: No','30','2','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan ALL-IN-ONE 20','No.; Voice:200 Texts to All Networks ; SMS: + 20mins Call to TNT/Smart; DATA: No','20','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan ALL-IN-ONE 30','No.; Voice:300 Texts to All Networks ; SMS: + 30 Minutes Call to TNT/Smart; DATA: No','30','2','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan ALL-IN-ONE 55','No.; Voice:550 Texts to All Networks ; SMS: + 55mins Call to TNT/Smart; DATA: No','55','3','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan ALL-IN-ONE 99','No.; Voice:990 Texts to All Networks ; SMS: + 80 Minutes Call to TNT/Smart; DATA: No','99','7','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan ALL-IN-ONE 15','No.; Voice:150 Texts to All Networks ; SMS: + 15mins Call to TNT/Smart; DATA: No','15','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unlitext Extra 30','Yes (Text).; Voice: Unlitext to TNT/Smart ; SMS: 15mins Call to TNT/Smart; DATA: No','30','3','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Piso FB','No.; Voice:No ; SMS: No; DATA: Mobile FB','1','10mins (1.3mb cap)','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','FB 5','No.; Voice:No ; SMS: No; DATA: Mobile FB','5','6hrs (8.4mb cap)','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','FB Mobile App','Unli FB.; Voice:No ; SMS: No; DATA: FB via FB Mobile App','at least 1 peso load','1','STICKERS','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Smart Net','Unli FB & Twitter updates.; Voice:No ; SMS: No; DATA: Free Unli Social','at least 1 peso load','NA','STICKERS ','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Yahoo Unli','Unli YM .; Voice:No ; SMS: No; DATA: YahooMail & Messenger (mobile browser)','15','1','STICKERS','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unli Surf','Unli.; Voice:No ; SMS: No; DATA: Mobile Browsing to all sites','50','1','STICKERS','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unlitxt 2 ALL 300','Yes (Text).; Voice:Unlitext to All Networks ; SMS: No; DATA: No','300','30','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Flexi 50','No.; Voice:5 Int'l Text or IDD Minutes ; SMS: 5 Int'l Text or IDD Minutes; DATA: No','50','NA','STICKERS','433')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Flexi 30','No.; Voice:6 Int'l Text or IDD Minutes ; SMS: 6 Int'l Text or IDD Minutes; DATA: No','30','NA','STICKERS ','433')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Kamus Text','No.; Voice:50 International Texts or All Networks ; SMS: NA; DATA: No','20','NA','STICKERS','433')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','3p IDD','No.; Voice: ; SMS: IDD Calls; DATA: No','3 pesos permin','NA','STICKERS','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unlitxt ALL +Unli Tropa Call','Yes.; Voice:Unli Text ; SMS: Unli Call TNT; DATA: ','20','10PM-10AM & 12NN-6PM','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Katok- At-Tex25','Unli for 2!.; Voice:Unli Text ; SMS: Unli Call; DATA: ','25','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','TriNet 300','Unli (Text).; Voice:Trinet Texts TNT/Smart/ Sun ; SMS: + 300mins of Calls to TNT/Smart/ Sun; DATA: + 30 MB Internet','300','30','STICKERS','2477')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Araw Araw Load 30','Yes (Text).; Voice:Unlitext ; SMS: + 30 Minutes of Calls; DATA: +30 Minutes Internet','30','3','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan Unli Trio Plus','Yes (Text).; Voice:Unlitext TNT/Smart/ Sun ; SMS: + 10mins Calls to TNT/Smart; DATA: No','15','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Nokia Express Browsing','Yes (Browsing).; Voice:No ; SMS: No; DATA: FB, Twitter, Email & More! (Nokia Express)','15','1','STICKERS ','211')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','5=15 Minutes','No.; Voice:No ; SMS: No; DATA: Internet browsing','5','15min','STICKERS ','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Pisonet Sampler','No.; Voice:No ; SMS: No; DATA: 1 peso = 5hrs net','1','2','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unlitxt 2 ALL 20','Yes (Text).; Voice:Unlitext to All Networks ; SMS: No; DATA: No','20','2','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Always On 30','No.; Voice:30 Free TNT/Smart/ Sun Sms ; SMS: No; DATA: 70 MB','30','1','STICKERS','2200')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Always On 20','No.; Voice:20 Free TNT/Smart/ Sun Sms ; SMS: No; DATA: 45 MB','20','1','STICKERS ','2200')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','FB 2','Yes (FB net).; Voice:No ; SMS: No; DATA: Unli FB','2','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unlitext Plus 10','Yes (Text).; Voice:UnliText TNT/Smart/ Sun ; SMS: No; DATA: No','10','1','STICKERS ','3545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unlitxt Plus 20','Yes (Text, FB).; Voice:UnliText TNT/Smart/ Sun ; SMS: 30 Minutes Calls to TNT/Smart/ Sun; DATA: Unli FB','20','2','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Extra','No.; Voice:Just add 5 pesos to your current promo to extend ; SMS: Just add 5 pesos to your current promo to extend; DATA: No','5','extend','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Chat Text','NA.; Voice:Group Messaging ; SMS: NA; DATA: NA','NA','NA','STICKERS','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Sticker Text','NA.; Voice:contextual & download stickers texting ; SMS: NA; DATA: NA','NA','NA','STICKERS ','0')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Unli Talk and Text 20','Yes (Text, Call).; Voice:Unlitext Smart/TNT ; SMS: Unlicall Smart/TNT; DATA: No','20','1','STICKERS ','4547')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Gaan Unlitext Plus 15','Yes (Text, FB).; Voice:Unlitext to TNT/Smart/ Sun ; SMS: +30 Minutes call to TNT/Smart/ Sun; DATA: UNLI FB','15','1','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','Piso Unlitext','Yes (Text).; Voice:Unlitext sa TNT/ Smart! ; SMS: No; DATA: No','1','30 min','STICKERS ','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','PisoNet','Yes (FB, Twitter).; Voice:No ; SMS: No; DATA: Unli FB, Twitter (mobile)','1','10 min','STICKERS','4545')");
db.execSQL("INSERT INTO offers VALUES(null ,'TNT','UTP10*','Yes (FB, Twitter).; Voice:Yes (Unli) ; SMS: +30 min call (TNT/Smart/Sun); DATA: 30mb internet','10','1 day','STICKERS ','4505')");



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
