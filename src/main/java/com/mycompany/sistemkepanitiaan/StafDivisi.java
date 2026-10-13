/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class StafDivisi extends AnggotaPanitia implements DapatLaporan {
    private String tugasSpesifik;

    public StafDivisi(String nama, String npm, String divisi, String tugasSpesifik) {
        super(nama, npm, divisi);
        this.tugasSpesifik = tugasSpesifik;
    }

    public void tampilkanInfo() {
        System.out.println("[Staf Divisi]  Nama: " + nama + " | NPM: " + npm + " | Divisi: " + divisi + " | Tugas: " + tugasSpesifik);
    }

    public void jalankanTugas() {
        System.out.println("   -> Tugas: Eksekusi lapangan -> " + tugasSpesifik);
    }

    public void hitungInsentif() {
        System.out.println("   -> Insentif Staf Divisi: Rp 300.000");
    }

    public void buatLaporan() {
        System.out.println("   -> [KONTRAK LAPORAN] Menyusun laporan progres divisi harian.");
    }
}

