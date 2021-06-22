package BiletyLotnicze;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formularz extends JFrame{
    private JPanel rootPanel;
    private JTextField imie;
    private JTextField nazwisko;
    private JComboBox wylotZ;
    private JComboBox przylotDo;
    private JRadioButton takRadioButton;
    private JRadioButton nieRadioButton;
    private JCheckBox przystawkaCheckBox;
    private JCheckBox obiadCheckBox;
    private JCheckBox deserCheckBox;
    private JTextArea uwagi;
    private JTable tabelaRezerwacji;
    private JButton dodajRezerwacjęButton;
    private JButton usuńRezerwacjęButton;
    private JButton zakończProgramButton;

    //zmienne pomocnicze
    public ArrayList<Rezerwacja> listaRezerwacji = new ArrayList<>();
    public ArrayList<String> listaPosilkow = new ArrayList<>();
    public String selectedVIP = "";

    public Formularz(){
        add(rootPanel);
        setTitle("Formularz rezerwacji");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //definicja tabeli
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Imię");
        model.addColumn("Nazwisko");
        model.addColumn("Wylot z");
        model.addColumn("Przylot do");
        model.addColumn("VIP");
        model.addColumn("Posiłek");
        model.addColumn("Uwagi");
        tabelaRezerwacji.setModel(model);


        zakończProgramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        takRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(takRadioButton.isSelected()){
                  nieRadioButton.setSelected(false);
                  selectedVIP = "TAK";
              } else{
                  takRadioButton.setSelected(true);
              }
            }
        });

        nieRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nieRadioButton.isSelected()){
                    takRadioButton.setSelected(false);
                    selectedVIP = "NIE";
                } else{ //zablokowanie możliwości odznaczenia
                    nieRadioButton.setSelected(true);
                }
            }
        });

        przystawkaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(przystawkaCheckBox.isSelected()){
                    listaPosilkow.add("przystawka");
                } else{
                    listaPosilkow.remove("przystawka");
                }
            }
        });

        obiadCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obiadCheckBox.isSelected()){
                    listaPosilkow.add("obiad");
                } else{
                    listaPosilkow.remove("obiad");
                }
            }
        });

        deserCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(deserCheckBox.isSelected()){
                    listaPosilkow.add("deser");
                } else{
                    listaPosilkow.remove("deser");
                }
            }
        });

        dodajRezerwacjęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(imie.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPanel, "Proszę wypełnić pole 'Imię'.");
                } else if(nazwisko.getText().equals("")){
                    JOptionPane.showMessageDialog(rootPanel, "Proszę wypełnić pole 'Nazwisko'.");
                } else if(selectedVIP.equals("")){
                    JOptionPane.showMessageDialog(rootPanel, "Proszę zaznaczyć opcję dla 'VIP'.");
                } else if(listaPosilkow.size() == 0){
                    JOptionPane.showMessageDialog(rootPanel, "Proszę wybrać przynajmniej jeden posiłek.'");
                } else{
                    Rezerwacja rezerwacja = new Rezerwacja(imie.getText(), nazwisko.getText(), wylotZ.getSelectedItem().toString(), przylotDo.getSelectedItem().toString(), selectedVIP, uwagi.getText(), listaPosilkow);
                    listaRezerwacji.add(rezerwacja);
                    wyswietlListeRezerwacji(model);

                    //czyszczenie pól formularza
                    imie.setText("");
                    nazwisko.setText("");
                    wylotZ.setSelectedIndex(0);
                    przylotDo.setSelectedIndex(0);
                    takRadioButton.setSelected(false);
                    nieRadioButton.setSelected(false);
                    przystawkaCheckBox.setSelected(false);
                    obiadCheckBox.setSelected(false);
                    deserCheckBox.setSelected(false);
                    uwagi.setText("");

                    selectedVIP = "";
                    listaPosilkow = new ArrayList<>();
                }
            }
        });
        usuńRezerwacjęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tabelaRezerwacji.getSelectedRow() == -1){
                    JOptionPane.showMessageDialog(rootPanel, "Proszę zaznaczyć element do usunięcia.");
                } else{
                    listaRezerwacji.remove(tabelaRezerwacji.getSelectedRow());
                    wyswietlListeRezerwacji(model);
                }
            }
        });
    }

    public void wyswietlListeRezerwacji(DefaultTableModel model){
        for(int i = model.getRowCount()-1; i>=0; i--){
            model.removeRow(i);
        }
        for(Rezerwacja x : listaRezerwacji){
            model.addRow(new Object[]{x.imie, x.nazwisko, x.wylotZ, x.przylotDo, x.VIP, x.posilki, x.uwagi});
        }
    }
}
