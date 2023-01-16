package view;

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
    JTable table1 = new JTable();
    DefaultTableModel model;


    public void menu() {
        tambahDataButton.setBounds(50, 130, 80, 25);
        updateDataButton.setBounds(150, 130, 80, 25);
        hapusDataButton.setBounds(250, 130, 80, 25);
        textField1.setBounds(70, 30, 200, 25);
        textField2.setBounds(70, 60, 200, 25);
        textField3.setBounds(70, 90, 200, 25);
        j1.setBounds(25, 30, 200, 25);
        j2.setBounds(25, 60, 200, 25);
        j3.setBounds(25, 90, 200, 25);
        table1.setBounds(20, 300, 550, 200);

        table1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [] []{
                },
                new String [] {
                        "Nama", "alamat", "umur"
                }
        ));


        add(table1);
        add(j1);
        add(j2);
        add(j3);
        add(textField3);
        add(textField2);
        add(textField1);
        add(hapusDataButton);
        add(updateDataButton);
        add(tambahDataButton);

        model=(DefaultTableModel)table1.getModel();

        tambahDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.insertRow(model.getRowCount(),new Object[]{
                        textField1.getText(),textField2.getText(),textField3.getText()
                });
//                DefaultTableModel model = (DefaultTableModel) table1.getModel();
//                model.addRow(new Object[]{
//                        table1.getRowCount()+1, textField1.getText(), textField2.getText(), textField3.getText()});
            }
        });
    }


        Menu() {
            menu();
            setTitle("2");
            setSize(600, 600);
            setLayout(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}



