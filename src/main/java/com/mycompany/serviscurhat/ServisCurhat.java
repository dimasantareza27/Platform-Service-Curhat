package com.mycompany.serviscurhat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServisCurhat {
    
    private static List<Post> postList = new ArrayList<>();
    private static long idCounter = 1;

    public static Post createPost(String content, String mood, String nickname) {
        Post newPost = new Post(idCounter++, content, mood, nickname);
        postList.add(newPost);
        return newPost;
    }

    public static Post getPostById(Long id) {
        for (Post post : postList) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        return null;
    }

    public static boolean giveSupport(Long id) {
        Post post = getPostById(id);
        if (post != null) {
            post.addSupport();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        createPost("Progres tugas akhir rasanya stuck, butuh motivasi.", "🌧️ Butuh Masukan", "PenjelajahMalam");
        createPost("Terima kasih ke barista cafe kampus yang ramah hari ini!", "☕ Sekadar Luapan", "PemikirSendu");

        System.out.println("=== APLIKASI PLATFORM CURHAT (RUANG DENGAR) ===");

        while (running) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tampilkan Semua Curhatan");
            System.out.println("2. Buat Curhatan Baru");
            System.out.println("3. Beri Support (Virtual Hug)");
            System.out.println("4. Edit Curhatan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- DINDING CURHAT ---");
                    if (postList.isEmpty()) {
                        System.out.println("Belum ada curhatan.");
                    } else {
                        for (Post p : postList) {
                            System.out.println("ID: " + p.getId());
                            System.out.println(p);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Isi Curhatan: ");
                    String content = scanner.nextLine();
                    System.out.print("Mood: ");
                    String mood = scanner.nextLine();
                    System.out.print("Nama Samaran: ");
                    String nickname = scanner.nextLine();

                    createPost(content, mood, nickname);
                    System.out.println("✅ Curhatan berhasil diunggah!");
                    break;

                case 3:
                    System.out.print("Masukkan ID Curhatan yang ingin didukung: ");
                    long targetId = scanner.nextLong();
                    if (giveSupport(targetId)) {
                        System.out.println("🤗 Kamu berhasil memberikan dukungan!");
                    } else {
                        System.out.println("❌ Curhatan dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Curhatan yang ingin diedit: ");
                    long editId = scanner.nextLong();
                    scanner.nextLine();

                    Post targetPost = getPostById(editId);
                    if (targetPost != null) {
                        System.out.print("Isi Curhatan Baru: ");
                        String newContent = scanner.nextLine();
                        System.out.print("Mood Baru: ");
                        String newMood = scanner.nextLine();
                        System.out.print("Nama Samaran Baru: ");
                        String newNickname = scanner.nextLine();

                        targetPost.setContent(newContent);
                        targetPost.setMood(newMood);
                        targetPost.setNickname(newNickname);

                        System.out.println("✅ Data curhatan berhasil diperbarui!");
                    } else {
                        System.out.println("❌ Curhatan tidak ditemukan.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Terima kasih telah berbagi di Ruang Dengar.");
                    break;

                default:
                    System.out.println("Opsi tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
}