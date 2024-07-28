package com.wzy.log_system.entity;


public class Article {
    private int id;
    private int user;
    private String title;
    private String content;


    public Article() {
    }

    public Article(int id, int user, String title, String content) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return user
     */
    public int getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(int user) {
        this.user = user;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "Article{id = " + id + ", user = " + user + ", title = " + title + ", content = " + content + "}";
    }
}
