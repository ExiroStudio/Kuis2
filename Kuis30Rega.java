import java.util.Scanner;

public class Kuis30Rega {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Jumlah pengunjung: ");
        int n = sc.nextInt();
        int totalPendapatan = 0;
        int totalUsia = 0;
        int totalAnak = 0;
        int usiaTertua = 0;
        int nim2 = 32;
        int kuotaDewasa = (nim2 % 3) + 2;
        int pengujungDitolak = 0;

        for (int i = 0; i < n;) {
            System.out.print("Usia pengunjung ke-" + (i + 1) + ": ");
            int usia = sc.nextInt();
            if (usia < 1 || usia > 80) {
                System.out.println("Input tidak valid, ulangi.");
                continue;
            }

            // Harga tiket: usia di bawah 12 tahun Rp 25000, selain itu Rp 40000
            int harga;
            if (usia < 12) {
                totalAnak++;
                harga = 25000;
            } else {
                if (kuotaDewasa <= 0) {
                    System.out.println("Kuota dewasa habis, pengunjung ke-" + (i + 1) + " ditolak");
                    i++;
                    pengujungDitolak++;
                    continue;
                }
                if (usia > usiaTertua) {
                    usiaTertua = usia;
                }
                kuotaDewasa--;
                harga = 40000;
            }
            totalPendapatan += harga;
            totalUsia += usia;
            System.out.println("  Harga tiket: Rp " + harga);
            i++;
        }
        sc.close();

        double rataUsia = (double) totalUsia / n;
        System.out.println("=== REKAP HARIAN ===");
        System.out.println("Total pendapatan\t   : Rp " + totalPendapatan);
        System.out.println("Rata-rata usia \t\t   : " + rataUsia + " tahun");
        System.out.println("Total pengunjung anak-anak : " + totalAnak + " pengunjung");
        System.out.println("Usia pengunjung tertua     : " + usiaTertua + " tahun");
        System.out.println("Pengunjung ditolak         : " + pengujungDitolak);
    }
}
