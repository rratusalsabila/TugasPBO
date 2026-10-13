/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public abstract class AnggotaPanitia {
    protected String nama;
    protected String npm;
    protected String divisi;
    private static int totalPanitia = 0;

    public AnggotaPanitia(String nama, String npm, String divisi) {
        this.nama = nama;
        this.npm = npm;
        this.divisi = divisi;
        totalPanitia++;
    }

    public String getNama() {
        return nama;
    }

    public String getNpm() {
        return npm;
    }

    public String getDivisi() {
        return divisi;
    }

    public static int getTotalPanitia() {
        return totalPanitia;
    }

    public void tampilkanInfo() {
        System.out.print("Nama: " + nama + " | NPM: " + npm + " | Divisi: " + divisi);
    }

    public void jalankanTugas() {
        System.out.println("   -> Tugas: Melaksanakan tugas umum kepanitiaan.");
    }

    public abstract void hitungInsentif();
    
}
