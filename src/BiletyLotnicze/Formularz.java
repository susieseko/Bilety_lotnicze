package BiletyLotnicze;

import javax.swing.*;

public class Formularz extends JFrame{
    private JPanel rootPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JRadioButton takRadioButton;
    private JRadioButton nieRadioButton;
    private JCheckBox przystawkaCheckBox;
    private JCheckBox obiadCheckBox;
    private JCheckBox deserCheckBox;
    private JTextArea textArea1;
    private JTable table1;
    private JButton dodajRezerwacjęButton;
    private JButton usuńRezerwacjęButton;

    public Formularz(){
        add(rootPanel);
        setTitle("Formularz rezerwacji");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
