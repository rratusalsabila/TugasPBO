/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner; 
/**
 *
 * @author ASUS
 */
public class SistemKepanitiaan {
    
    public static void cariPanitia(String nama, ArrayList<AnggotaPanitia> daftar) throws PanitiaTidakDitemukanException {
        System.out.println("\n=== Hasil Pencarian Nama: \"" + nama + "\" ===");
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.get(i).tampilkanInfo(); 
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PanitiaTidakDitemukanException("Gagal: Panitia dengan nama \"" + nama + "\" tidak ditemukan di sistem.");
        }
    }

    public static void simulasiTugas(AnggotaPanitia panitia) {
        panitia.jalankanTugas();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<AnggotaPanitia> daftarPanitia = new ArrayList<>(); 
        HashMap<String, String> dataLogistik = new HashMap<>();
        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("   SISTEM MANAJEMEN KEPANITIAAN EVENT MAHASISWA   ");
        System.out.println("==================================================");

        while (isRunning) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Tambah Panitia Baru");
            System.out.println("2. Tampilkan Seluruh Daftar Panitia");
            System.out.println("3. Cari Panitia (Demo Custom Exception)");
            System.out.println("4. Kelola Logistik (Demo HashMap)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            try {
                if (!scanner.hasNextInt()) {
                    System.out.println("Input harus angka!");
                    scanner.nextLine();
                    continue;
                }

                int pilihan = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (pilihan) {
                    case 1 -> {
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
                            daftarPanitia.add(new PanitiaInti(nama, npm, divisi, jabatan));
                            System.out.println("Sukses: Panitia Inti berhasil ditambahkan!");
                        } else if (tipe == 2) {
                            System.out.print("Masukkan Tugas Spesifik: ");
                            String tugas = scanner.nextLine();
                            daftarPanitia.add(new StafDivisi(nama, npm, divisi, tugas));
                            System.out.println("Sukses: Staf Divisi berhasil ditambahkan!");
                        } else if (tipe == 3) {
                            System.out.print("Masukkan Area Penugasan: ");
                            String area = scanner.nextLine();
                            daftarPanitia.add(new Volunter(nama, npm, divisi, area));
                            System.out.println("Sukses: Volunter berhasil ditambahkan!");
                        } else {
                            System.out.println("Pilihan tipe tidak valid.");
                        }
                    }

                    case 2 -> {
                        System.out.println("\n--- DAFTAR PANITIA EVENT ---");

                        if (daftarPanitia.isEmpty()) {
                            System.out.println("Daftar panitia tidak tersedia."); 
                        } else {
                            for (int i = 0; i < daftarPanitia.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarPanitia.get(i).tampilkanInfo();
                                simulasiTugas(daftarPanitia.get(i));
                                daftarPanitia.get(i).hitungInsentif();

                                if (daftarPanitia.get(i) instanceof DapatMemimpin) {
                                    DapatMemimpin pimpinan = (DapatMemimpin) daftarPanitia.get(i);
                                    pimpinan.koordinasiProgram();
                                }
                                if (daftarPanitia.get(i) instanceof DapatLaporan) {
                                    DapatLaporan pelapor = (DapatLaporan) daftarPanitia.get(i);
                                    pelapor.buatLaporan();
                                }
                                System.out.println();
                            }
                        }
                        System.out.println("Total Panitia saat ini: " + AnggotaPanitia.getTotalPanitia());
                    }

                    case 3 -> {
                        System.out.println("\n--- FITUR CARI PANITIA ---");
                        System.out.print("Masukkan Nama Panitia yang dicari: ");
                        String namaCari = scanner.nextLine();
                        
                        try {
                            cariPanitia(namaCari, daftarPanitia);
                        } catch (PanitiaTidakDitemukanException e) {
                            System.out.println("PERINGATAN: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                    }

                    case 4 -> {
                        System.out.println("\n--- KELOLA LOGISTIK (HASHMAP) ---");
                        System.out.println("1. Tambah Logistik Baru");
                        System.out.println("2. Cari Logistik via Kode");
                        System.out.println("3. Tampilkan Semua Logistik");
                        System.out.print("Pilih (1-3): ");
                        int menuLogistik = scanner.nextInt();
                        scanner.nextLine();

                        if (menuLogistik == 1) {
                            System.out.print("Masukkan Kode Barang (Key): ");
                            String kode = scanner.nextLine();
                            System.out.print("Masukkan Nama Barang (Value): ");
                            String barang = scanner.nextLine();
                            dataLogistik.put(kode, barang);
                            System.out.println("Sukses: Logistik berhasil ditambahkan!");
                        } else if (menuLogistik == 2) {
                            System.out.print("Masukkan Kode Barang yang dicari: ");
                            String cariKode = scanner.nextLine();
                            if (dataLogistik.containsKey(cariKode)) {
                                System.out.println("Ditemukan! Nama Barang: " + dataLogistik.get(cariKode));
                            } else {
                                System.out.println("Barang dengan kode tersebut tidak terdaftar.");
                            }
                        } else if (menuLogistik == 3) {
                            System.out.println("Total Jenis Logistik: " + dataLogistik.size());
                            for (String key : dataLogistik.keySet()) {
                                System.out.println("- Kode: " + key + " | Barang: " + dataLogistik.get(key));
                            }
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    }

                    case 5 -> {
                        System.out.println("\nProgram selesai. Terima kasih!");
                        isRunning = false;
                    }

                    default -> System.out.println("Pilihan menu tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("TERJADI KESALAHAN: Masukkan format angka yang valid!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("TERJADI KESALAHAN SISTEM: " + e.getMessage());
            }
        }
        scanner.close();
    }
}