/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemkepanitiaan;

/**
 *
 * @author ASUS
 */
public class Volunter extends AnggotaPanitia {
    private String areaPenugasan;

    public Volunter(String nama, String npm, String divisi, String areaPenugasan) throws Exception {
        super(nama, npm, divisi);
        this.areaPenugasan = areaPenugasan;
    }

    public void tampilkanInfo() {
        System.out.println("[Volunter]     Nama: " + nama + " | NPM: " + npm + " | Divisi: " + divisi + " | Area Penugasan: " + areaPenugasan);
    }

    public void jalankanTugas() {
        System.out.println("   -> Tugas: Membantu operasional di area " + areaPenugasan + ".");
    }

    public void hitungInsentif() {
        System.out.println("   -> Insentif Volunter: Rp 150.000 (Uang Saku)");
    }
}
