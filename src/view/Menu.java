package view;

import entity.DataKaryawan;
import model.ModelDataKaryawan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    JButton tambahDataButton = new JButton("tambah data");
    JButton lihatDataButton = new JButton("lihat data");
    JButton updateDataButton = new JButton("update data");
    JButton hapusDataButton = new JButton("hapus data");
    JTextField textField1 = new JTextField("");
    JTextField textField2 = new JTextField("");
    JTextField textField3 = new JTextField("");
    JLabel j1 = new JLabel("Nama");
    JLabel j2 = new JLabel("Alamat");
    JLabel j3 = new JLabel("Umur");

    public void menu() {
        tambahDataButton.setBounds(50, 160, 80, 25);
        updateDataButton.setBounds(150, 160, 80, 25);
        hapusDataButton.setBounds(250, 160, 80, 25);
        textField1.setBounds(70, 30, 200, 25);
        textField2.setBounds(70, 60, 200, 25);
        textField3.setBounds(70, 90, 200, 25);
        j1.setBounds(25, 30, 200, 25);
        j2.setBounds(25, 60, 200, 25);
        j3.setBounds(25, 90, 200, 25);

        JTable dataKamar = new JTable();
        TableModel model1 =createTableModel();
        dataKamar.setModel(model1);
        JScrollPane scrollPane = new JScrollPane(dataKamar);
        scrollPane.setBounds(32,300,500,250);

        add(scrollPane);
        add(j1);
        add(j2);
        add(j3);
        add(textField3);
        add(textField2);
        add(textField1);
        add(hapusDataButton);
        add(updateDataButton);
        add(tambahDataButton);

        tambahDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama= textField1.getText();
                String alamat=textField2.getText();
                int umur = Integer.parseInt(textField3.getText());

                DataKaryawan karyawan = new DataKaryawan(nama,alamat,umur);
                ModelDataKaryawan.insertKaryawan(karyawan);
                dispose();
                new Menu();
                }
        });
    }
    private TableModel createTableModel(){
        DefaultTableModel dataKamar = new DefaultTableModel();
        Object[] kolom ={"NO","nama","alamat","umur"};
        dataKamar.setColumnIdentifiers(kolom);
        int i=0;
        for(DataKaryawan dataKaryawan: ModelDataKaryawan.all()){
            Object[] data= new String[]{
                    String.valueOf(i+1),

                    dataKaryawan.getNama(),
                    dataKaryawan.getAlamat(),
                    String.valueOf(dataKaryawan.getUmur())
            };
            i++;
            dataKamar.addRow(data);
        }
        return dataKamar;
    }

        Menu() {
            menu();
            setTitle("2");
            setSize(600, 600);
            setLayout(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
}



