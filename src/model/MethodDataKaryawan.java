package model;
import  java.util.*;
import Entity.DataKaryawan;
import Main.Crud;

public class MethodDataKaryawan {
    String nama, alamat;
    int umur;

    ArrayList <DataKaryawan> data1 = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public MethodDataKaryawan() {
        super();
    }

    public void input(){
        System.out.println();
        System.out.print("masukkan nama  : ");
        nama = in.nextLine();
        System.out.print("masukan alamat : ");
        alamat = in.nextLine();
        System.out.print("masukan umur   : ");
        umur = in.nextInt();
        in.nextLine();

        DataKaryawan data = new DataKaryawan(nama,alamat,umur);
        data1.add(data);
    }

    public void lihatdata (){
        if(data1.isEmpty()){
            System.out.println("Tidak ada data");
        }
        else{
            for(DataKaryawan viewdata : data1){
                System.out.println();
                System.out.println("=============");
                System.out.println("Nama    = " + viewdata.getNama());
                System.out.println("Alamat  = " + viewdata.getAlamat());
                System.out.println("Umur    = " + viewdata.getUmur());
                System.out.println("=============");
            }
        }
    }

    public DataKaryawan cariData (String nama){
        for (DataKaryawan databuku : data1){
            if(databuku.getNama().equals(nama)){
                return databuku;
            }
        }
        return null;
    }

    public void caridata(DataKaryawan dataCari) {
        int index = indexData(dataCari);
        data1.get(index).setNama(dataCari.getNama());
        data1.get(index).setAlamat(dataCari.getAlamat());
        data1.get(index).setUmur(dataCari.getUmur());
    }

    public void editDataNama() {
        String pilih;
        lihatdata();
        System.out.print("masukan nama : ");
        pilih = in.nextLine();
        in.nextLine();
        DataKaryawan data = cariData(pilih);
        if(data!=null){
            System.out.print("Nama   : ");
            nama = in.nextLine();
            System.out.print("Alamat : ");
            alamat = in.nextLine();
            System.out.print("Umur   : ");
            umur = in.nextInt();
            data.setNama(nama);
            data.setAlamat(alamat);
            data.setUmur(umur);
            caridata(data);
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
    }

    public void menuHapus() {
        String pilih;
        System.out.print("masukan nama : ");
        pilih = in.nextLine();
        DataKaryawan dataCari = cariData(pilih);
        if(dataCari!=null){
            hapus(dataCari);
            System.out.println("data " +dataCari.getNama()+ " berhasil di hapus");
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
    }

    public void hapus(DataKaryawan dataCari){
        data1.remove(dataCari);
    }

    public void insert(){
        //alt+j
    }

    public int indexData(DataKaryawan dataCari){
        return data1.indexOf(dataCari);
    }
}
