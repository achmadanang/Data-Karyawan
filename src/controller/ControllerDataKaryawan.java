package controller;

import model.ModelDataKaryawan;
import entity.DataKaryawan;
//import view.ViewDataKaryawan;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ControllerDataKaryawan {

//    public void toAdmin(){
//        ViewDataKaryawan viewDataKaryawan = new ViewDataKaryawan();
//        viewDataKaryawan.menukaryawan();
//    }
    public ArrayList<DataKaryawan> all(){
        return ModelDataKaryawan.all();
    }

    public void insert(String nama,String alamat,int umur){
        ModelDataKaryawan.insertKaryawan(new DataKaryawan(nama,alamat,umur));
    }

    public boolean cari(String nama,String password){
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
