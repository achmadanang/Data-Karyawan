package controller;

import model.ModelDataKaryawan;
import entity.DataKaryawan;
import view.ViewDataKaryawan;

import java.util.ArrayList;

public class ControllerDataKaryawan {

    public void toAdmin(){
        ViewDataKaryawan viewDataKaryawan = new ViewDataKaryawan();
        viewDataKaryawan.menu();
    }
    public ArrayList<DataKaryawan> all(){
        return ModelDataKaryawan.all();
    }

    public void insert(String email, String password,String nama,String alamat,int umur){
        ModelDataKaryawan.insertKaryawan(new DataKaryawan(email,password,nama,alamat,umur));
    }

    public boolean cari(String nama){
        DataKaryawan data = ModelDataKaryawan.cariData(nama);
        if(data!=null){
            return true;
        }
        else {
            return false;
        }
    }

    public void hapusKaryawan(String nama){
        ModelDataKaryawan.hapus(nama);
    }
}
