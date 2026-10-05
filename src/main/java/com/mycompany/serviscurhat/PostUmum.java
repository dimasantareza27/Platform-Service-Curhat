package com.mycompany.serviscurhat;

public class PostUmum extends Post {

    public PostUmum(Long id, String content, String mood, String nickname) {
        super(id, content, mood, nickname);
    }

    @Override
    public String getKategoriPost() {
        return "Curhatan Umum";
    }
}