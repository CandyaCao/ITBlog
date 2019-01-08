package com.github.candyacao.bean;

import java.util.Date;

public class Comment {
    private String id;
    private Date createDate;
    private String content;
    private User user;
    private String postID;

    public Comment() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostID(){return postID;}

    public void setPostID(String postID){this.postID = postID;}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "comment{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", createDate=" + createDate +
                ", content='" + content + '\'' +
                '}';
    }
}
