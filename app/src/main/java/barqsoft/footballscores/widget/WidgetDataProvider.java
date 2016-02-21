package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;

import barqsoft.footballscores.R;
import barqsoft.footballscores.Scores;
import barqsoft.footballscores.scoresAdapter;

/**
 * Created by archit.m on 30/01/16.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory{

    List<Scores> collection = new ArrayList<>();
    Context context;
    Intent intent;
    public scoresAdapter mAdapter;




    private void initData(){
        //collection.clear();
//        for (int i=0;i<10;i++){
//            collection.add("List view item : "+i);
//        }
    }
    public WidgetDataProvider(Context context, List collection) {
        this.context = context;
        this.collection= collection;
    }

    @Override
    public void onCreate() {
        initData();
    }

    @Override
    public void onDataSetChanged() {
        initData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return collection.size();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    @Override
    public RemoteViews getViewAt(int position) {
//        RemoteViews view = new RemoteViews(context.getPackageName(),
//                android.R.layout.simple_list_item_1);
//        view.setTextViewText(android.R.id.text1, collection.get(position));
//        return view;
        //Log.v("archit","Getting view for position = "+position);
        RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.test_list_item);
        Scores scores   = collection.get(position);
        view.setTextViewText(R.id.home_team,scores.getHome());
        view.setContentDescription(R.id.home_team, "Home team :: " + scores.getHome());

        view.setTextViewText(R.id.match_score, scores.getHomeGoals() + "-" + scores.getAwayGoals());
        view.setContentDescription(R.id.match_score,"Match Score :: "+ scores.getHomeGoals() + "-" + scores.getAwayGoals());

        view.setTextViewText(R.id.away_team, scores.getAway());
        view.setContentDescription(R.id.away_team,"Away Team :: "+scores.getAway());

//        view.setTextViewText(R.id.home_name,scores.getHome());
//        view.setTextViewText(R.id.score_textview,scores.getHomeGoals()+"-"+scores.getAwayGoals());
//        view.setTextViewText(R.id.away_name,scores.getAway());
//        view.setTextViewText(R.id.data_textview,scores.getDate());
        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}
