package barqsoft.footballscores;

/**
 * Created by archit.m on 31/01/16.
 */
public class Scores {
    public  String  league ;
    public   String date ;
    public   String time ;
    public   String home ;
    public   String away ;
    public   String homeGoals ;
    public   String awayGoals ;
    public   String matchId ;
    public   String matchDay ;

    public Scores(String league, String date, String time, String home, String away, String homeGoals, String awayGoals, String matchId, String matchDay) {
        this.league = league;
        this.date = date;
        this.time = time;
        this.home = home;
        this.away = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.matchId = matchId;
        this.matchDay = matchDay;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getMatchDay() {
        return matchDay;
    }

    public void setMatchDay(String matchDay) {
        this.matchDay = matchDay;
    }
}
