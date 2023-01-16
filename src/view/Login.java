package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ControllerDataAdmin;
import entity.DataAdmin;
import  model.ModelDataAdmin;
import javax.swing.table.DefaultTableModel;
public class Login extends JFrame{
    JButton loginButton = new JButton("Login");
    JButton keluarButton = new JButton("Keluar");
    JTextField textField1 = new JTextField("");
    JPasswordField passwordField1 = new JPasswordField("");
    JLabel j1 = new JLabel("User");
    JLabel j2 = new JLabel("Pass");
    JLabel textdatakaryawan = new JLabel("DATA KARYAWAN");
    JLabel logo = new JLabel();
    ControllerDataAdmin admin = new ControllerDataAdmin();

    public  void MenuUtama(){
//        logo.setIcon(new ImageIcon("C:\\Users\\anang\\Downloads\\b1ff78fadd146eddb08ecbdb3b41771a (2).jpg"));
        logo.setBounds(150,50,250,250);
        loginButton.setBounds(150,460,250,25);
        keluarButton.setBounds(150,500,250,25);
        textField1.setBounds(150,350,250,25);
        passwordField1.setBounds(150,400,250,25);
        j1.setBounds(150,330,200,25);
        j1.setFont(new Font("Serif",Font.BOLD,12));
        j2.setBounds(150,380,200,25);
        j2.setFont(new Font("Serif",Font.BOLD,12));
        textdatakaryawan.setBounds(200,20,200,25);
        textdatakaryawan.setFont(new Font("Serif",Font.BOLD,18));

        add(textdatakaryawan);
        add(logo);
        add(loginButton);
        add(keluarButton);
        add(textField1);
        add(passwordField1);
        add(j1);
        add(j2);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userValue = textField1.getText();
                String passValue = passwordField1.getText();

                boolean status = admin.cari(userValue,passValue);
                if(status){
                    Menu M = new Menu();
                    M.setVisible(true);
                    dispose();
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }else{
                    System.out.println("salah");
                }
            }
        });
    }

    public Login(){
        setSize(600,600);
        setTitle("1");
        setLayout(null);
        MenuUtama();
        setResizable(false);
    }

    public static void main(String[] args){
        Login lg = new Login();
        ModelDataAdmin.dataAdmin();
        lg.setVisible(true);
    }
}
