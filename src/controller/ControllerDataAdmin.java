package controller;

import model.ModelDataAdmin;
import entity.DataAdmin;
import view.ViewDataAdmin;

import java.util.ArrayList;

public class ControllerDataAdmin {

    public void toMain(){
        ViewDataAdmin admin = new ViewDataAdmin();
        admin.menu();
    }
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
