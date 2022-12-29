package view;

import controller.ControllerDataAdmin;
import controller.ControllerDataKaryawan;
import entity.DataAdmin;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewDataAdmin {
    Scanner input = new Scanner(System.in);
    ArrayList<DataAdmin> data = new ArrayList<>();
    ControllerDataAdmin dataAdmin = new ControllerDataAdmin();

    public void menu() {
        String pilih;
        do {
            System.out.println("""
                    1. Daftar
                    2. Login Karyawan
                    3. Login Admin
                    4. Keluar
                    """);
            System.out.print("Masukkan Pilihan :");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> akunBaru();
                case "2" -> loginkaryawan();
                case "3" -> login();
                case "4" -> System.out.println("Exit");
                default -> System.out.print("tidak ada inputan");
            }
        }while (!pilih.equals("5"));
    }

    public void login(){
        System.out.println("Login Admin");
        System.out.print("Masukkan Email anda    :");
        String email = input.nextLine();
        System.out.print("Masukkan Password anda :");
        String password = input.nextLine();
        boolean status = dataAdmin.cari(email,password);
        if (status){
            ControllerDataKaryawan karyawan = new ControllerDataKaryawan();
            karyawan.toAdmin();
        }
        else{
            System.out.println("Salah");
        }
    }
    public void akunBaru() {
        System.out.println();
        System.out.println("Menu Daftar");
        System.out.print("Masukkan email     :");
        String email = input.nextLine();
        System.out.print("Masukkan Password  :");
        String password = input.nextLine();
        DataAdmin data11 = new DataAdmin(email,password);
        data.add(data11);

    }
    public void loginkaryawan(){
        if(data.isEmpty()){
            System.out.println("Tidak Ada akun yang Akan di login");
        }
        else{
            System.out.println();
            System.out.println("Login Karyawan");
            System.out.print("Masukkan Email anda    :");
            String email = input.nextLine();
            System.out.print("Masukkan Password anda :");
            String password = input.nextLine();
            DataAdmin log = cariData(email,password);
            if (log!=null){
                System.out.println("Benar");
                ViewDataKaryawan v = new ViewDataKaryawan();
                v.menukaryawan();
            }
            else{
                System.out.println("Salah");
            }
        }
    }
    public DataAdmin cariData (String email, String pasword){
        for (DataAdmin nama1 : data){
            if(nama1.getEmail().equals(email)&&nama1.getPassword().equals(pasword)){
                return nama1;
            }
        }
        return null;
    }
}

