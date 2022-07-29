package com.sparta.week3_assignment.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String author;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;


    public Memo(String title, String contents, String author, String password){
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
    }

        public Memo(MemoRequestDto requestDto){
            this.title = requestDto.getTitle();
            this.contents = requestDto.getContents();
            this.author = requestDto.getAuthor();
            this.password = requestDto.getPassword();
        }

        public void update(MemoRequestDto requestDto){
            this.title = requestDto.getTitle();
            this.contents = requestDto.getContents();
            this.author = requestDto.getAuthor();
            this.password = requestDto.getPassword();
        }

        public boolean confirm(PassWordRequestDto requestDto){
            return this.password.equals(requestDto.getPassword());
        }
    }
