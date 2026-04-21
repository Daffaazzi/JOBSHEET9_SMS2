package LatihanPraktikum;

public class StackSurat08 {
    Surat08[] stack;
    int size;
    int top;

    public StackSurat08(int size) {
        this.size = size;
        stack = new Surat08[size];
        top = -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(Surat08 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
            System.out.println("Surat dari " + surat.namaMahasiswa + " berhasil diterima.");
        } else {
            System.out.println("Stack penuh! Tidak bisa menerima surat lagi.");
        }
    }

    public Surat08 pop() {
        if (!isEmpty()) {
            Surat08 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat08 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang masuk.");
            return null;
        }
    }

    public boolean cariSurat(String nama) {
        for (int i = 0; i <= top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada surat.");
        } else {
            System.out.printf("%-10s %-20s %-8s %-10s %-8s%n",
                    "ID Surat", "Nama Mahasiswa", "Kelas", "Jenis Izin", "Durasi");
            System.out.println("----------------------------------------------------------");
            for (int i = top; i >= 0; i--) {
                String jenis = (stack[i].jenisIzin == 'S' || stack[i].jenisIzin == 's')
                        ? "Sakit"
                        : "Izin";
                System.out.printf("%-10s %-20s %-8s %-10s %-8d%n",
                        stack[i].idSurat,
                        stack[i].namaMahasiswa,
                        stack[i].kelas,
                        jenis,
                        stack[i].durasi);
            }
            System.out.println();
        }
    }
}
