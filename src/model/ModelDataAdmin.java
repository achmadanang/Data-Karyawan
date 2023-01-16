package model;
import entity.DataAdmin;
import java.util.ArrayList;

public class ModelDataAdmin {
    static ArrayList<DataAdmin> arrayAdmin = new ArrayList<>();

    public static ArrayList<DataAdmin> all(){
        return arrayAdmin;
    }

    public static void dataAdmin(){
        arrayAdmin.add(new DataAdmin("anang","123"));
    }

    public static DataAdmin cari(String email,String password){
        for (DataAdmin objek : arrayAdmin){
            if(objek.getEmail().equals(email)&&objek.getPassword().equals(password)){
                return objek;
            }
        }
        return null;
    }

}
