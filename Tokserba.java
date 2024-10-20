/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan.pkg8;

/**
 *
 * @author 62859
 */
import java.util.Scanner;

public class Tokserba {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kodeBarang = {"001", "002", "003", "004", "005"};
        String[] namaBarang = {"Penghapus", "Buku", "Pensil", "Pulpen", "Spidol"};
        int[] hargaBarang = {2000, 3000, 4000, 5000, 6000};
        String[] inputNamaBarang = new String[5];  // For inputting item names
        int[] jumlahBeli = new int[5];
        int[] jumlahBayar = new int[5];
        int totalBayar = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Data ke-" + (i + 1));
            System.out.print("Masukkan Nama Barang yang ingin dibeli(Penghapus, Buku, Pensil, Pulpen, Spidol): ");
            inputNamaBarang[i] = scanner.next();
            System.out.print("Masukkan Jumlah barang yang ingin Beli: ");
            jumlahBeli[i] = scanner.nextInt();
            int index = -1;
            for (int j = 0; j < namaBarang.length; j++) {
                if (namaBarang[j].equalsIgnoreCase(inputNamaBarang[i])) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                jumlahBayar[i] = hargaBarang[index] * jumlahBeli[i];
                totalBayar += jumlahBayar[i];
            } else {
                System.out.println("Nama barang tidak valid!");
                i--; 
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int indexI = findIndex(namaBarang, inputNamaBarang[i]);
                int indexJ = findIndex(namaBarang, inputNamaBarang[j]);
                
                if (hargaBarang[indexI] > hargaBarang[indexJ]) {
                    String tempNama = inputNamaBarang[i];
                    inputNamaBarang[i] = inputNamaBarang[j];
                    inputNamaBarang[j] = tempNama;
                    int tempJumlahBeli = jumlahBeli[i];
                    jumlahBeli[i] = jumlahBeli[j];
                    jumlahBeli[j] = tempJumlahBeli;
                    int tempJumlahBayar = jumlahBayar[i];
                    jumlahBayar[i] = jumlahBayar[j];
                    jumlahBayar[j] = tempJumlahBayar;
                }
            }
        }
        System.out.println("\nTOKO SERBA ADA");
        System.out.println("************************");
        System.out.println("No\tKode Barang\tNama Barang\tHarga\tJumlah Beli\tJumlah Bayar");
        System.out.println("==============================================================");

        for (int i = 0; i < 5; i++) {
            int index = findIndex(namaBarang, inputNamaBarang[i]);
            System.out.println((i + 1) + "\t" + kodeBarang[index] + "\t\t" + namaBarang[index] + "\t\t" + hargaBarang[index] + "\t" + jumlahBeli[i] + "\t\t" + jumlahBayar[i]);
        }

        System.out.println("==============================================================");
        System.out.println("Total Bayar: " + totalBayar);

        scanner.close();
    }
    public static int findIndex(String[] namaBarang, String nama) {
        for (int i = 0; i < namaBarang.length; i++) {
            if (namaBarang[i].equalsIgnoreCase(nama)) {
                return i;
            }
        }
        return -1; 
    }
}
