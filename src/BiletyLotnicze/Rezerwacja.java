package BiletyLotnicze;

import java.util.ArrayList;

public class Rezerwacja {
    public String imie, nazwisko, wylotZ, przylotDo, VIP, uwagi;
    public ArrayList<String> posilki = new ArrayList<>();

    public Rezerwacja(String imie, String nazwisko, String wylotZ, String przylotDo, String VIP, String uwagi, ArrayList<String> posilki) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wylotZ = wylotZ;
        this.przylotDo = przylotDo;
        this.VIP = VIP;
        this.uwagi = uwagi;
        this.posilki = posilki;
    }
}
