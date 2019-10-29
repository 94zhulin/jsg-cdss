package com.jsg.entity;

import lombok.Data;

@Data
public class Token {
    private String token;
    private Long time;
    private User user;

    public Token(String token, Long time, User user) {
        this.token = token;
        this.time = time;
        this.user = user;
    }

}
