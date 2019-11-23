package com.jsg.entity;

import lombok.Data;

@Data
public class Token {
    private String token;
    private Long time;
    private UserGenera user;

    public Token(String token, Long time, UserGenera user) {
        this.token = token;
        this.time = time;
        this.user = user;
    }

}
