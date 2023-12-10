class BarangDiskon extends Barang {
    private double diskon;

    public BarangDiskon(String nama, double harga, int jumlah, double diskon) {
        super(nama, harga, jumlah);
        this.diskon = diskon;
    }

    public double getTotalSetelahDiskon() {
        double totalSebelumDiskon = super.getHarga();
        double potongan = totalSebelumDiskon * (diskon / 100);
        return totalSebelumDiskon - potongan;
    }
}
