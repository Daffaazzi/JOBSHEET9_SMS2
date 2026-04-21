package LatihanPraktikum;

import java.util.Scanner;

public class SuratDemo08 {
    public static void main(String[] args) {
        StackSurat08 stack = new StackSurat08(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Lihat Semua Surat");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat    : ");
                    String id = scan.nextLine();
                    System.out.print("Nama        : ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas       : ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S=Sakit / I=Izin): ");
                    char jenis = scan.nextLine().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = scan.nextInt();
                    scan.nextLine();

                    Surat08 surat = new Surat08(id, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    break;

                case 2:
                    Surat08 diproses = stack.pop();
                    if (diproses != null) {
                        String jenisStr = (diproses.jenisIzin == 'S' || diproses.jenisIzin == 's')
                                ? "Sakit" : "Izin";
                        System.out.println("Memproses surat dari : " + diproses.namaMahasiswa);
                        System.out.println("Kelas                : " + diproses.kelas);
                        System.out.println("Jenis Izin           : " + jenisStr);
                        System.out.println("Durasi               : " + diproses.durasi + " hari");
                        System.out.println("Surat " + diproses.idSurat + " berhasil diproses.");
                    }
                    break;

                case 3:
                    Surat08 teratas = stack.peek();
                    if (teratas != null) {
                        String jenisStr = (teratas.jenisIzin == 'S' || teratas.jenisIzin == 's')
                                ? "Sakit" : "Izin";
                        System.out.println("Surat terakhir masuk dari : " + teratas.namaMahasiswa);
                        System.out.println("ID Surat                  : " + teratas.idSurat);
                        System.out.println("Kelas                     : " + teratas.kelas);
                        System.out.println("Jenis Izin                : " + jenisStr);
                        System.out.println("Durasi                    : " + teratas.durasi + " hari");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cari = scan.nextLine();
                    boolean ditemukan = stack.cariSurat(cari);
                    if (ditemukan) {
                        System.out.println("Surat izin dari " + cari + " ditemukan di dalam stack.");
                    } else {
                        System.out.println("Surat izin dari " + cari + " tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.println("Daftar semua surat izin:");
                    stack.print();
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 5);

        scan.close();
    }
}