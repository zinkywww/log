package com.wzy.log_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private int id;
    //作为外键与user表关联。
    private int userId;
    private String title;
    private String content;

}
