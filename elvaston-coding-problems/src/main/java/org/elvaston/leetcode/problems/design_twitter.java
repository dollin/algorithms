package org.elvaston.leetcode.problems;

import org.elvaston.leetcode.difficulty.medium;
import org.elvaston.leetcode.tags.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@medium
@hash_table
/**
 * https://leetcode.com/problems/design-twitter/
 *
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10
 * most recent tweets in the user's news feed. Your design should support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
 * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 *
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */


public class design_twitter {

    public static void main(String[] args) {
        design_twitter twitter = new design_twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));

        twitter.postTweet(2, 6);
        twitter.follow(1, 2);
        twitter.follow(2, 1);
        Arrays.sort(args, (o1, o2) -> 0);

        System.out.println(twitter.getNewsFeed(1));
        twitter.postTweet(2, 7);
        twitter.postTweet(1, 8);

        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);

        System.out.println(twitter.getNewsFeed(1));
    }

    private design_twitter() {

    }

    private List<int[]> tweets = new ArrayList<>();
    private Map<Integer, List<Integer>> followers = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        for (int i = tweets.size() - 1; i >= 0; i--) {
            int[] tweet = tweets.get(i);
            if (tweet[0] == userId || (followers.get(userId) != null && followers.get(userId).contains(tweet[0]))) {
                feed.add(tweet[1]);
                count++;
                if (count == 10) {
                    break;
                }
            }
        }
        return feed;
    }

    public void follow(int user, int followee) {
        List<Integer> followees = followers.getOrDefault(user, new ArrayList<>());
        if (!followees.contains(followee)) {
            followees.add(followee);
            followers.put(user, followees);
        }
    }

    public void unfollow(int user, int followee) {
        List<Integer> followees = followers.getOrDefault(user, new ArrayList<>());
        followees.remove((Integer) followee);
    }
}
