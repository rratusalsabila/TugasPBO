/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;
import java.util.Scanner; 
/**
 *
 * @author ASUS
 */
public class SistemKepanitiaan {
    
    public static void cariPanitia(String nama, AnggotaPanitia[] daftar, int jumlah) {
        System.out.println("\n=== Hasil Pencarian Nama: \"" + nama + "\" ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getNama().equalsIgnoreCase(nama)) {
                daftar[i].tampilkanInfo(); 
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data panitia tidak ditemukan.");
        }
    }

    public static void cariPanitia(String divisi, AnggotaPanitia[] daftar, int jumlah, boolean isDivisi) {
        System.out.println("\n=== Hasil Pencarian Divisi: \"" + divisi + "\" ===");
        boolean ditemukan = false;
        for (int i = 0; i < jumlah; i++) {
            if (daftar[i].getDivisi().equalsIgnoreCase(divisi)) {
                daftar[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Data panitia pada divisi tersebut tidak ditemukan.");
        }
    }

    public static void simulasiTugas(AnggotaPanitia panitia) {
        panitia.jalankanTugas();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnggotaPanitia[] daftarPanitia = new AnggotaPanitia[50]; 
        int jumlahPanitia = 0;
        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("   SISTEM MANAJEMEN KEPANITIAAN EVENT MAHASISWA   ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Panitia Baru");
            System.out.println("2. Tampilkan Seluruh Daftar Panitia");
            System.out.println("3. Cari Panitia");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input harus angka!");
                scanner.nextLine();
                continue;
            }

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (pilihan) {
                case 1 -> {
                    if (jumlahPanitia >= daftarPanitia.length) {
                        System.out.println("Kapasitas daftar panitia penuh!");
                        break;
                    }

                    System.out.println("\n--- Pilih Tipe Panitia ---");
                    System.out.println("1. Panitia Inti");
                    System.out.println("2. Staf Divisi");
                    System.out.println("3. Volunter");
                    System.out.print("Pilihan (1/2/3): ");
                    int tipe = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan Nama   : ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NPM    : ");
                    String npm = scanner.nextLine();
                    System.out.print("Masukkan Divisi : ");
                    String divisi = scanner.nextLine();

                    if (tipe == 1) {
                        System.out.print("Masukkan Jabatan: ");
                        String jabatan = scanner.nextLine();
                        daftarPanitia[jumlahPanitia++] = new PanitiaInti(nama, npm, divisi, jabatan);
                        System.out.println("Sukses: Panitia Inti berhasil ditambahkan!");
                    } else if (tipe == 2) {
                        System.out.print("Masukkan Tugas Spesifik: ");
                        String tugas = scanner.nextLine();
                        daftarPanitia[jumlahPanitia++] = new StafDivisi(nama, npm, divisi, tugas);
                        System.out.println("Sukses: Staf Divisi berhasil ditambahkan!");
                    } else if (tipe == 3) {
                        System.out.print("Masukkan Area Penugasan: ");
                        String area = scanner.nextLine();
                        daftarPanitia[jumlahPanitia++] = new Volunter(nama, npm, divisi, area);
                        System.out.println("Sukses: Volunter berhasil ditambahkan!");
                    } else {
                        System.out.println("Pilihan tipe tidak valid.");
                    }
                }

                case 2 -> {
                    System.out.println("\n--- DAFTAR PANITIA EVENT ---");

                    if (jumlahPanitia == 0) {
                        System.out.println("Daftar panitia tidak tersedia."); 
                    } else {
                        for (int i = 0; i < jumlahPanitia; i++) {
                            System.out.print((i + 1) + ". ");
                            daftarPanitia[i].tampilkanInfo();
                            simulasiTugas(daftarPanitia[i]);
                            daftarPanitia[i].hitungInsentif();

                            if (daftarPanitia[i] instanceof DapatMemimpin) {
                                DapatMemimpin pimpinan = (DapatMemimpin) daftarPanitia[i];
                                pimpinan.koordinasiProgram();
                            }
                            if (daftarPanitia[i] instanceof DapatLaporan) {
                                DapatLaporan pelapor = (DapatLaporan) daftarPanitia[i];
                                pelapor.buatLaporan();
                            }
                            System.out.println();
                        }
                    }
                    System.out.println("Total Panitia saat ini: " + AnggotaPanitia.getTotalPanitia());
                }

                case 3 -> {
                    System.out.println("\n--- Menu Pencarian ---");
                    System.out.println("1. Cari Berdasarkan Nama");
                    System.out.println("2. Cari Berdasarkan Divisi");
                    System.out.print("Pilihan (1/2): ");
                    int optCari = scanner.nextInt();
                    scanner.nextLine();

                    if (optCari == 1) {
                        System.out.print("Masukkan Nama Panitia: ");
                        String namaCari = scanner.nextLine();
                        cariPanitia(namaCari, daftarPanitia, jumlahPanitia); 
                    } else if (optCari == 2) {
                        System.out.print("Masukkan Nama Divisi: ");
                        String divisiCari = scanner.nextLine();
                        cariPanitia(divisiCari, daftarPanitia, jumlahPanitia, true); 
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                }

                case 4 -> {
                    System.out.println("\nProgram selesai. Terima kasih!");
                    isRunning = false;
                }

                default -> System.out.println("Pilihan menu tidak valid.");
            }
        }
        scanner.close();
    }
}