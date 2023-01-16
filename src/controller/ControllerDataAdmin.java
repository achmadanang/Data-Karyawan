package controller;

import model.ModelDataAdmin;
import entity.DataAdmin;
//import view.ViewDataAdmin;
//import view.ViewDataKaryawan;

import java.util.ArrayList;

public class ControllerDataAdmin {
//    public void toomain(){
//        ViewDataAdmin main = new ViewDataAdmin();
//        main.menu();
//    }

//    public void toMain(){
//        ViewDataKaryawan admin = new ViewDataKaryawan();
//        admin.menu();
//    }
    public boolean cari(String email,String password){
        DataAdmin data = ModelDataAdmin.cari(email, password);
        if(data!=null){
            return true;
        }
        else {
            return false;
        }
    }

    public ArrayList<DataAdmin> all(){
        return ModelDataAdmin.all();
    }
}
