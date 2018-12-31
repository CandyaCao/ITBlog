package com.github.candyacao.bean;

import java.util.Date;
import java.util.List;

public class Post {

    private String id;
    private String content;
    private String authorID;
    private String title;
    private String summary;
    // 展示图片的链接
    private String photoLink;
    private Date createDate;
    private List<Comment> comments;

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", authorID='" + authorID + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", photoLink='" + photoLink + '\'' +
                ", createDate=" + createDate +
                ", comments=" + comments +
                '}';
    }
}




