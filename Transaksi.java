class Transaksi {
    public BisaDibeli[] barang;
    private Pelanggan pelanggan;
    private String nomorFaktur;
    private double totalBayar;

    public Transaksi(BisaDibeli[] barang, Pelanggan pelanggan, String nomorFaktur) {
        this.barang = barang;
        this.pelanggan = pelanggan;
        this.nomorFaktur = nomorFaktur;
        this.totalBayar = hitungTotal();
    }

    public double hitungTotal() {
        double total = 0;
        for (BisaDibeli item : barang) {
            total += item.getHarga();
        }
        return total;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public String getNomorFaktur() {
        return nomorFaktur;
    }

    public double getTotalBayar() {
        return totalBayar;
    }
}
