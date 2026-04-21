package Percobaan;
public class Mahasiswa08 {
    String nim;
    String nama;
    String kelas;
    int nilai;

    public Mahasiswa08() {
    }

    public Mahasiswa08(String nama, String nim, String kelas) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        nilai = -1;
    }

    void tugasDinilai(int nilai) {
        this.nilai = nilai;
    }
}