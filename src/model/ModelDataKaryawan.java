package model;
import entity.DataKaryawan;
import java.util.ArrayList;

public class ModelDataKaryawan {
    static ArrayList<DataKaryawan> arrayDataKar = new ArrayList<>();

    public static ArrayList<DataKaryawan> all(){
        return arrayDataKar;
    }

    public static void insertKaryawan(DataKaryawan data){
        arrayDataKar.add(data);
    }

    public static DataKaryawan cariData (String nama){
        for (DataKaryawan objek : arrayDataKar){
            if(objek.getNama().equals(nama)){
                return objek;
            }
        }
        return null;
    }

    public static int index(String nama){
        DataKaryawan data = cariData(nama);
        return arrayDataKar.indexOf(data);
    }

    public static void hapus(String nama){
        int index = index(nama);

        if(index != -1){
            arrayDataKar.remove(index);
        }
    }
}
