package Main;
import java.util.*;
import model.*;
import Entity.*;

public class Crud extends MethodDataKaryawan{
    String email, password;

    Scanner input = new Scanner(System.in);
    Entity.Login data1 = new Entity.Login();
    Entity.Login data11 = new Entity.Login();
    ArrayList<Login> data = new ArrayList<>();
    public void menulogin() {
        String pilihan;
        do {
            System.out.println("");
            System.out.println("1. Daftar ");
            System.out.println("2. Login Karyawan");
            System.out.println("3. Login Admin");
            System.out.println("4. Keluar");

            System.out.print("Masukkan Pilihan :");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1" -> akunBaru();
                case "2" -> login();
                case "3" -> inputadmin();
                case "4"-> System.out.println("program selesai");
                default -> System.out.print("inputan tidak ada");
            }
        }while (!pilihan .equals("4"));
    }

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
    public void akunBaru() {
        System.out.println();
        System.out.println("Menu Daftar");
        System.out.print("Masukkan email     :");
        email = input.nextLine();
        System.out.print("Masukkan Password  :");
        password = input.nextLine();
        data11 = new Login(email,password);
        data.add(data11);

    }
    public void inputadmin(){
        System.out.println();
        System.out.println("Login Admin");
        System.out.print("Masukkan Email anda    :");
        email = input.nextLine();
        System.out.print("Masukkan Password anda :");
        password = input.nextLine();
        login(email, password);
    }
    public void login(){
        if(data.isEmpty()){
            System.out.println("Tidak Ada akun yang Akan dilogin");
        }
        else{
            System.out.println();
            System.out.println("Login Karyawan");
            System.out.print("Masukkan Email anda    :");
            email = input.nextLine();
            System.out.print("Masukkan Password anda :");
            password = input.nextLine();
            Login log = cariData(email,password);
            if (log!=null){
                System.out.println("Benar");
                menukaryawan();
            }
            else{
                System.out.println("Salah");
            }
        }
    }
    public Login cariData (String email,String pasword){
        for (Login nama1 : data){
            if(nama1.getEmail().equals(email)&&nama1.getPassword().equals(pasword)){
                return nama1;
            }
        }
        return null;
    }

    public void login(String email, String pass){
        if (data1.getEmail().equals(email)&&data1.getPassword().equals(pass)){
            menu();
        } else {
            System.out.println("Username atau Password Salah");
        }
    }

    @Override
    public void insert() {
        String email = "anang";
        String pass = "123";

        data1 = new Entity.Login(email, pass);
    }
}
