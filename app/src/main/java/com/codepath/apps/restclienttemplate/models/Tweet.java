package com.codepath.apps.restclienttemplate.models;

import android.text.format.DateUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class Tweet {

    public String body;
    public String createdAt;
    public long id;
    public long userId;
    public User user;


    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        tweet.id = jsonObject.getLong("id");
        User user = User.fromJson(jsonObject.getJSONObject("user")); // getJSONObject instead of string because User is an object, not a string
        tweet.user = user;
        tweet.userId = user.id;
        return tweet;
    }

    public String relativeTimeStamp(){
        return TimeFormatter.getTimeDifference(createdAt);
    }


    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i <jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }




    }

