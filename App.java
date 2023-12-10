import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String username = "admin";
        String password = "admin";

        System.out.println("Selamat datang! Silakan login.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        String captcha = CaptchaGenerator.generateCaptcha(5);

        System.out.println("CAPTCHA: " + captcha);
        System.out.print("Masukkan CAPTCHA: ");
        String inputCaptcha = scanner.nextLine();

        if (checkCaptcha(inputCaptcha, captcha) && checkLogin(inputUsername, inputPassword, username, password)) {
            System.out.println("Login berhasil!");

            try {
                System.out.print("Masukkan nomor faktur: ");
                String nomorFaktur = scanner.nextLine();

                System.out.print("Masukkan nama pelanggan: ");
                String namaPelanggan = scanner.nextLine();
                Pelanggan pelanggan = new Pelanggan(namaPelanggan);

                System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
                int jumlahBarang = scanner.nextInt();
                Barang[] barang = new Barang[jumlahBarang];

                for (int i = 0; i < jumlahBarang; i++) {
                    scanner.nextLine();

                    System.out.println("\nBarang ke-" + (i + 1));
                    System.out.print("Nama barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Harga barang: ");
                    double hargaBarang = scanner.nextDouble();
                    System.out.print("Jumlah barang: ");
                    int jumlah = scanner.nextInt();
                    System.out.print("Diskon barang (%): ");
                    double diskonBarang = scanner.nextDouble();

                    barang[i] = new BarangDiskon(namaBarang, hargaBarang, jumlah, diskonBarang);
                }

                Transaksi transaksi = new Transaksi(barang, pelanggan, nomorFaktur);

                System.out.println("\nDetail Transaksi:");
                System.out.println("Nomor Faktur: " + transaksi.getNomorFaktur());
                System.out.println("Nama Pelanggan: " + transaksi.getPelanggan().getNama());
                for (int i = 0; i < jumlahBarang; i++) {
                    Barang item = (BarangDiskon) transaksi.barang[i];
                    if (item instanceof BarangDiskon) {
                        BarangDiskon barangDiskon = (BarangDiskon) item;
                        System.out.println(
                                "Barang ke-" + (i + 1) + ": " + barangDiskon.getNama()
                                        + " (Total Harga Setelah Diskon: "
                                        + barangDiskon.getTotalSetelahDiskon() + ", Jumlah: " + item.getJumlah() + ")");
                    } else {
                        System.out.println(
                                "Barang ke-" + (i + 1) + ": " + item.getNama() + " (Total Harga: " + item.getHarga()
                                        + ", Jumlah: " + item.getJumlah() + ")");
                    }
                }
                System.out.println("Total Bayar: " + transaksi.getTotalBayar());
            } catch (InputMismatchException e) {
                System.out.println("Kesalahan Input, Tipe Data Tidak Sesuai");
            }
        } else {
            System.out.println("Login gagal. Coba lagi.");
        }

        scanner.close();
    }

    public static boolean checkLogin(String inputUsername, String inputPassword, String username, String password) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public static boolean checkCaptcha(String inputCaptcha, String captcha) {
        return captcha.equalsIgnoreCase(inputCaptcha);
    }
}
