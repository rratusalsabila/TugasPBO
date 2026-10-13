/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class PanitiaInti extends AnggotaPanitia implements DapatMemimpin, DapatLaporan {
    private String jabatan;

    public PanitiaInti(String nama, String npm, String divisi, String jabatan) {
        super(nama, npm, divisi);
        this.jabatan = jabatan;
    }

    public void tampilkanInfo() {
        System.out.println("[Panitia Inti] Nama: " + nama + " | NPM: " + npm + " | Divisi: " + divisi + " | Jabatan: " + jabatan);
    }

    public void jalankanTugas() {
        System.out.println("   -> Tugas: Mengoordinasikan rangkaian acara dan mengambil keputusan strategis.");
    }

    public void hitungInsentif() {
        System.out.println("   -> Insentif Panitia Inti: Rp 500.000");
    }

    public void koordinasiProgram() {
        System.out.println("   -> [KONTRAK MEMIMPIN] Memimpin rapat pleno panitia inti.");
    }

    public void buatLaporan() {
        System.out.println("   -> [KONTRAK LAPORAN] Menyusun laporan pertanggungjawaban akhir acara.");
    }
}