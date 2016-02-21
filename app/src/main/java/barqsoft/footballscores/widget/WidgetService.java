package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import android.widget.RemoteViewsService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import barqsoft.footballscores.DatabaseContract;
import barqsoft.footballscores.Scores;

/**
 * Created by archit.m on 30/01/16.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class WidgetService extends RemoteViewsService {

//    public static final int LEAGUE_COL_IND = 0;
//    public static final int DATE_COL_IND = 1;
//    public static final int TIME_COL_IND = 2;
//    public static final int HOME_COL_IND = 3;
//    public static final int AWAY_COL_IND = 4;
//    public static final int HOME_GOALS_COL_IND = 5;
//    public static final int AWAY_GOALS_COL_IND = 6;
//    public static final int MATCH_DAY_IND = 8;
//    public static final int MATCH_ID_IND = 7;

    public static final int COL_HOME = 3;
    public static final int COL_AWAY = 4;
    public static final int COL_HOME_GOALS = 6;
    public static final int COL_AWAY_GOALS = 7;
    public static final int COL_DATE = 1;
    public static final int COL_LEAGUE = 5;
    public static final int COL_MATCHDAY = 9;
    public static final int COL_ID = 8;
    public static final int COL_MATCHTIME = 2;
    public double detail_match_id = 0;

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        Date fragmentdate = new Date(System.currentTimeMillis()-86400000);
        SimpleDateFormat mformat = new SimpleDateFormat("yyyy-MM-dd");
        Cursor cursor = getContentResolver().query(DatabaseContract.scores_table.buildScoreWithDate(), null, null, new String[]{mformat.format(fragmentdate)}, null);
        List<Scores> scorelist = new ArrayList<>();
        while(cursor.moveToNext()){
            String league = cursor.getString(COL_LEAGUE);
            String date = cursor.getString(COL_DATE);
            String time = cursor.getString(COL_MATCHTIME);
            String home = cursor.getString(COL_HOME);
            String away = cursor.getString(COL_AWAY);
            String homeGoals = cursor.getString(COL_HOME_GOALS);
            String awayGoals = cursor.getString(COL_AWAY_GOALS);
            String matchId = cursor.getString(COL_ID);
            String matchDay = cursor.getString(COL_MATCHDAY);
            Log.v("archit",home+" "+homeGoals+" "+away+" "+awayGoals);
            Scores score= new Scores(league,date,time,home,away,homeGoals,awayGoals, matchId,matchDay);
            scorelist.add(score);
        }
        Log.v("archit","Scores list size = "+scorelist.size());
        return new WidgetDataProvider(this,scorelist);
    }
}
