package com.hama.book.springboot.domain.posts;


import com.hama.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // lombok - Getter 메소드 자동생성
@NoArgsConstructor // lombok - 기본 생성자 자동추가, public Posts() {}와 같은 효과
@Entity // jpa
public class Posts extends BaseTimeEntity {

    @Id // pk field
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk rule - auto increment
    private Long id;

    @Column(length = 500, nullable = false) // table column
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // lombok - 생성자와 비슷한 역할.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
