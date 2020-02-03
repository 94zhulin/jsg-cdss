package com.jsg.entity;

import lombok.Data;

import java.util.List;

@Data
public class Token {
    private String token;
    private Long time;
    private UserGenera user;
    private List<Module> modules;

    public Token(String token, Long time, UserGenera user) {
        this.token = token;
        this.time = time;
        this.user = user;
    }

}
