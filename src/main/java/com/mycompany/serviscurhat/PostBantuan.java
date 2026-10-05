package com.mycompany.serviscurhat;

public class PostBantuan extends Post {
    private String kategori;

    public PostBantuan(Long id, String content, String mood, String nickname, String kategori) {
        super(id, content, mood, nickname);
        this.setKategori(kategori);
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        if (kategori == null || kategori.isBlank()) {
            this.kategori = "Umum";
        } else {
            this.kategori = kategori;
        }
    }

    @Override
    public String getKategoriPost() {
        return "Butuh Saran - " + kategori;
    }
}