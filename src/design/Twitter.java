package design;
import java.util.*;

public class Twitter {
	class Tweet{
        int time;
        int id;
        public Tweet(int time, int id){
            this.time = time;
            this.id = id;
        }
    }
    
    HashMap<Integer, Set<Integer>> users;
    HashMap<Integer, Set<Tweet>> tweets;
    int time;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        follow(userId, userId);
        Tweet tweet = new Tweet(time++, tweetId);
        if(!tweets.containsKey(userId)){
            tweets.put(userId, new HashSet<>());
        }
        tweets.get(userId).add(tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>((a, b) -> b.time - a.time);
        if(users.containsKey(userId)){
            for(Integer user : users.get(userId)){
                if(tweets.containsKey(user)){
                    for(Tweet tweet : tweets.get(user)){
                        queue.offer(tweet);
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty() && res.size() < 10){
            res.add(queue.poll().id);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new HashSet<>());
        }
        users.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId) && followerId != followeeId){
            users.get(followerId).remove(followeeId);
        }
    }
}
