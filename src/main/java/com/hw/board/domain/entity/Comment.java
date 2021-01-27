package com.hw.board.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comment {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long Id;

    private String title;
    private String content;
    private String writer;

    /* JPA에서 1:N, M:1 과 같은 관계를 매핑하는 방법은
    @ManyToOne 어노테이션을 붙여주고, @JoinColumn 어노테이션을 이용해서
    매핑의 대상이 되는 반대편 객체의 키 값을 적어주면 된다.
    또한, 관계(Relationship)의 방향이 따로 없는 테이블과는 다르게 JPA는 사실
    내부적으로 포인터(레퍼런스)의 형태를 띄고 있기 때문에 매핑 방향이 정해져 있다.
    보통 위와 같은 방식을 보고, 단방향 매핑이라고 하고 JPA에서는 이러한 단방향 매핑 이외에도 양방향 매핑이라는것을 지원한다.
    JPA를 이용해서 이렇게 매핑 해놓으면, 실제 코드에서는 마치 객체를 읽고 쓰는 것처럼, 테이블에 접근하는게 가능해지게 된다.*/
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(Id, comment.Id) &&
                Objects.equals(title, comment.title) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(writer, comment.writer);
    }

    @Override
    public int hashCode() { return Objects.hash(Id, title, content, writer); }
}