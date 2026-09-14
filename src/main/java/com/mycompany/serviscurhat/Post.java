package com.mycompany.serviscurhat;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String content;
    private String mood;
    private String nickname;
    private int supportCount;
    private LocalDateTime createdAt;

    public Post(Long id, String content, String mood, String nickname) {
        this.id = id;
        this.setContent(content);
        this.setMood(mood);
        this.setNickname(nickname);
        this.supportCount = 0;
        this.createdAt = LocalDateTime.now();
    }

    public void addSupport() {
        this.supportCount++;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public String getNickname() {
        return nickname;
    }

    public int getSupportCount() {
        return supportCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        if (content == null || content.isBlank()) {
            this.content = "(Isi curhatan kosong)";
        } else {
            this.content = content;
        }
    }

    public void setMood(String mood) {
        if (mood == null || mood.isBlank()) {
            this.mood = "💬 Umum";
        } else {
            this.mood = mood;
        }
    }

    public void setNickname(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            this.nickname = "Anonim";
        } else {
            this.nickname = nickname;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (~%s)\n\"%s\"\n🤗 Support: %d\n",
                mood, nickname, createdAt.toLocalDate(), content, supportCount);
    }
}