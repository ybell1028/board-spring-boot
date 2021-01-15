package com.example.hw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity // 데이터베이스의 테이블과 1대1 매칭
//@Table(name="Post")
public class Post {
    @Id // 테이블 컬럼의 기본키에 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본키에 지정된 auto increment등의 속성을 지정
    private Long Id;

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /*보통 JPA 같은 경우 자바 스펙의 상당부븐을 따르므로, POJO(Plain Old Java Object) 규약을 따라서 작성하게 된다.
    해당 방식을 따르지 않는경우. ORM이 변환을 제대로 수행하지 못한다.*/

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(Id, post.Id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content);
    }

    @Override
    public int hashCode(){
        return Objects.hash(Id, title, content);
    }
}
