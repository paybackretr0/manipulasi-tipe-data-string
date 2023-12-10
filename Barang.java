class Barang implements BisaDibeli {
    private String nama;
    private double harga;
    private int jumlah;

    public Barang(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public double getHarga() {
        return harga * jumlah;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }
}
