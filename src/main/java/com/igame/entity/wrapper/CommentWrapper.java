package com.igame.entity.wrapper;

import com.igame.entity.Comment;
import com.igame.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyH
 * @email 2064150592@qq.com
 * @create 2020-10-12 9:13
 */
public class CommentWrapper {

    private Comment parentComment;

    private int countReplies = 0;

    private final Map<Integer, Comment> replies = new HashMap<>();

    public int getCountReplies() {
        return countReplies;
    }

    public void setCountReplies(int countReplies) {
        this.countReplies = countReplies;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Map<Integer, Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        for (Comment reply : replies) {
            this.replies.put(reply.getCommentId(), reply);
            countReplies++;
        }
    }

    private User currentUser;

    private Comment currentComment;

    private Comment replyComment;

    private List<Comment> commentList;

    public Comment getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(Comment replyComment) {
        this.replyComment = replyComment;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Comment getCurrentComment() {
        return currentComment;
    }

    public void setCurrentComment(Comment currentComment) {
        this.currentComment = currentComment;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
