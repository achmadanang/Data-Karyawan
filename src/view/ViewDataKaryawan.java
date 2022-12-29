package view;
import entity.DataKaryawan;
import model.ModelDataKaryawan;
import controller.ControllerDataKaryawan;
import java.util.Scanner;

public class ViewDataKaryawan implements ClassInterface{
    Scanner input = new Scanner(System.in);
    ControllerDataKaryawan dataKaryawan = new ControllerDataKaryawan();

    public void menu() {
        String pilih;
        do {
            System.out.println("""
                    1. Tambah data
                    2. Lihat data
                    3. Edit data
                    4. Hapus data
                    5. Keluar
                    """);
            System.out.print("Masukkan Pilihan :");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> input();
                case "2" -> lihatdata();
                case "3" -> editDataNama();
                case "4" -> menuHapus();
                case "5" -> System.out.println("Exit");
                default -> System.out.print("tidak ada inputan");
            }
        }while (!pilih.equals("5"));
    }

    public void input(){
        int umur;
        try {
            System.out.println();
            System.out.print("masukkan email        : ");
            String email = input.nextLine();
            System.out.print("masukkan password     : ");
            String password = input.nextLine();
            System.out.print("masukkan nama         : ");
            String nama = input.nextLine();
            System.out.print("masukan alamat        : ");
            String alamat = input.nextLine();
            System.out.print("masukan umur          : ");
            umur = input.nextInt();
            input.nextLine();
            dataKaryawan.insert(email,password,nama,alamat,umur);
        }catch (Exception e){
            System.out.println("Data Tidak Bisa Di Inputkan");
            input.nextLine();
        }
    }

    public void lihatdata (){
        if(dataKaryawan.all().isEmpty()){
            System.out.println("Tidak ada data");
        }
        else{
            for(DataKaryawan viewdata : dataKaryawan.all()){
                System.out.println();
                System.out.println("=============");
                System.out.println("Nama    = " + viewdata.getNama());
                System.out.println("Alamat  = " + viewdata.getAlamat());
                System.out.println("Umur    = " + viewdata.getUmur());
                System.out.println("=============");
            }
        }
    }

    public void editDataNama() {
        String nama,alamat;
        int umur;

        System.out.print("masukan nama : ");
        nama = input.nextLine();
        input.nextLine();
        DataKaryawan data = ModelDataKaryawan.cariData(nama);
        if(data!=null){
            try {
                System.out.print("Nama   : ");
                nama = input.nextLine();
                System.out.print("Alamat : ");
                alamat = input.nextLine();
                System.out.print("Umur   : ");
                umur = input.nextInt();
                input.nextLine();

                data.setNama(nama);
                data.setAlamat(alamat);
                data.setUmur(umur);
                System.out.println("Data Berhasil Ditambah");
            }catch (Exception e){
                System.out.println("Gagal Edit");
            }
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
    }
    public void menuHapus() {
        String nama;
        System.out.print("masukan nama : ");
        nama = input.nextLine();
        boolean status = dataKaryawan.cari(nama);
        if(status){
            dataKaryawan.hapusKaryawan(nama);
            System.out.println("data berhasil di hapus");
        }
        else{
            System.out.println("Data tidak ditemukan");
        }
    }
    public void menukaryawan() {
        String pilih;
        do {
            System.out.println("""
                    1. Tambah data
                    2. Keluar
                    """);
            System.out.print("Masukkan Pilihan :");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> input();
                case "2" -> System.out.println("Exit");
                default -> System.out.print("tidak ada inputan");
            }
        }while (!pilih.equals("2"));
    }
}
