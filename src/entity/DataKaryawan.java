package entity;

public class DataKaryawan extends Data{

    private String nama,alamat;
    private int umur;
    public DataKaryawan(String email, String password,String nama,String alamat,int umur) {
        super(email, password);
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
    }

    public DataKaryawan(String nama, String alamat, int umur) {
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}