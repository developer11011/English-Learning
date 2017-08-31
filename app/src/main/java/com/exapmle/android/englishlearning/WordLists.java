package com.exapmle.android.englishlearning;

import android.widget.Switch;

import java.util.ArrayList;

/**
 * Created by mikig on 31.08.2017.
 */

public class WordLists {
    String name;
    public ArrayList getEasyList(int position)
    {
        ArrayList<Word> easyList = new ArrayList<Word>();
        switch (position)
        {
            case 0:
                easyList.add(new Word("", "", ""));
                easyList.add(new Word("", "", ""));
                easyList.add(new Word("", "", ""));
                easyList.add(new Word("", "", ""));
                name="At the Airport";
                break;
        }
        return easyList;
    }



     public ArrayList getMediumList(int position)
    {
        ArrayList<Word> mediumList = new ArrayList<Word>();
        switch (position)
        {
            case 0:
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                name = "Crime";
                break;
            case 1:
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                name = "City slang";
                break;
            case 2:
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                mediumList.add(new Word("", "", ""));
                name = "Medicines";
                break;
        }
        return mediumList;
    }



    public ArrayList getHardList(int position)
    {
        ArrayList<Word> hardList = new ArrayList<Word>();
        switch (position)
        {
            case 0:
                hardList.add(new Word("chairman", "prezes", "czerman"));
                hardList.add(new Word("board of directors", "zarząd", "bord of dajrektors"));
                hardList.add(new Word("manageable", "wykonalny", "manedżebul"));
                hardList.add(new Word("expertise", "wiedza, doświadczenie", "ekspertis"));
                hardList.add(new Word("trainee", "praktykant(-ka), stażysta", "czrajni"));
                hardList.add(new Word("to establish", "zakładać", "tu establisz"));
                hardList.add(new Word("principles", "zasady", "principles"));
                hardList.add(new Word("commitment", "zaangażowanie osobiste", "komitment"));
                hardList.add(new Word("increasing profits", "wzrastające zyski", "inkrising profits"));
                hardList.add(new Word("to maintain", "utrzymywać", "mejtejn"));
                hardList.add(new Word("autonomous", "niezależny, autonomiczny", "otonomus"));
                hardList.add(new Word("to report to", "podlegać komuś", "tu riport tu"));
                hardList.add(new Word("subordinates", "podwładni", "sabordinejt"));
                hardList.add(new Word("superior", "przełożony", "supirja"));
                hardList.add(new Word("to diminish", "zmniejszać się, maleć", "diminisz"));
                hardList.add(new Word("division", "oddział, dział", "diwiżyn"));
                hardList.add(new Word("to split up", "rozdzielać, dzielić", "tu split ap"));
                hardList.add(new Word("to run the risk", "narażać się na ryzyko", "tu ran de risk"));
                hardList.add(new Word("internally", "wewnętrznie", "internali"));
                hardList.add(new Word("to promote", "awansować", "tu promołt"));
                hardList.add(new Word("employee", "pracownik", "emploji"));
                hardList.add(new Word("employer", "pracodawca", "emplojer"));
                hardList.add(new Word("employment", "zatrudnienie", "emplojment"));
                hardList.add(new Word("to sign a deal", "podpisać transakcję", "tu sajn e dil"));
                name = "Business words";
                break;
            case 1:
                hardList.add(new Word("tissue", "tkanka", "tiszju"));
                hardList.add(new Word("artery", "tętnica", "artri"));
                hardList.add(new Word("vein", "żyła", "wein"));
                hardList.add(new Word("respiratory system", "układ oddechowy", "respiratori system"));
                hardList.add(new Word("trachea", "tchawica", "czrakija"));
                hardList.add(new Word("larynx", "krtań", "larynks"));
                hardList.add(new Word("pharynx", "gardło", "ffariks"));
                hardList.add(new Word("digestive system", "układ pokarmowy", "dajdżestiw system"));
                hardList.add(new Word("anus", "odbyt", "ejnus"));
                hardList.add(new Word("lung", "płuco", "lang"));
                hardList.add(new Word("liver", "wątroba", "liewr"));
                hardList.add(new Word("spleen", "śledziona", "splin"));
                hardList.add(new Word("oesophagus", "przełyk", "osofekus"));
                hardList.add(new Word("vermiform appendix", "wyrostek robaczkowy", "wermiform apendiks"));
                hardList.add(new Word("small intestine", "jelito cienkie", "smal intestin"));
                hardList.add(new Word("large intestine", "jelito gróbe", "lardż intestin"));
                hardList.add(new Word("urinary system", "układ moczowy", "jurinari system"));
                hardList.add(new Word("kidney", "nerka", "kidni"));
                hardList.add(new Word("bladder", "pęcherz moczowy", "blader"));
                hardList.add(new Word("gland", "gruczoł", "gland"));
                hardList.add(new Word("testis", "jądro", "testis"));
                hardList.add(new Word("thyroid", "tarczyca", "fajrojd"));
                hardList.add(new Word("nervous system", "układ nerwowy", "nerwys system"));
                hardList.add(new Word("spinal cord", "rdzeń kręgowy", "spajnal kord"));
                hardList.add(new Word("reproductive system", "układ rozrodczy", "riprodaktiw"));
                hardList.add(new Word("ovary", "jajnik", "ołwari"));
                hardList.add(new Word("sperm cell", "plemnik", "sperm cel"));
                name = "Human organs";
                break;
            case 2:
                hardList.add(new Word("prism", "graniastosłup", "prizim"));
                hardList.add(new Word("polyhedron", "wielościan", "polihejton"));
                hardList.add(new Word("division", "dzielenie", "diwiżyn"));
                hardList.add(new Word("involution", "potęgowanie", "inwoluszyn(?)"));
                hardList.add(new Word("to raise to a power", "podnieść do potęgi", "tu rejs tu e pałer"));
                hardList.add(new Word("protractor", "kątomierz", "proczaktor"));
                hardList.add(new Word("set square", "ekierka", "set skłer"));
                hardList.add(new Word("pair of compasses", "cyrkiel", "per of kompases"));
                hardList.add(new Word("odd number", "liczba nieparzysta", "od number"));
                hardList.add(new Word("even number", "liczba parzysta", "iwin number"));
                hardList.add(new Word("rule", "działanie", "rul"));
                hardList.add(new Word("decimal point", "miejsce dziesiętne", "desimal pojnt"));
                hardList.add(new Word("angle", "kąt", "andżel"));
                hardList.add(new Word("axis", "oś", "aksis"));
                hardList.add(new Word("plain", "płaszczyzna", "plain"));
                hardList.add(new Word("to reduce a fraction", "skrócić ułamek", "tu redjus frakszyn"));
                hardList.add(new Word("fraction", "ułamek", "frakszyn"));
                hardList.add(new Word("diameter", "średnica", "dajamiter"));
                hardList.add(new Word("root", "pierwiastek", "ruut"));
                hardList.add(new Word("power", "potęga", "pałer"));
                hardList.add(new Word("units", "jedności", "junits"));
                hardList.add(new Word("positive number", "liczba dodania", "pozitiw namber"));
                hardList.add(new Word("negative number", "liczba ujemna", "negatiw namber"));
                hardList.add(new Word("subtraction", "odejmowanie", "sabtrakszyn"));
                hardList.add(new Word("perpendicular", "prostopadły", "perpendikjular"));
                hardList.add(new Word("parallel", "równoległy", "paralel"));
                hardList.add(new Word("numerator", "licznik", "numerejtor"));
                hardList.add(new Word("denominator", "mianowanik", "denominejter"));
                hardList.add(new Word("mean", "średnia", "min"));
                hardList.add(new Word("sphere", "kula", "sfer"));
                hardList.add(new Word("volume", "objętość", "woljum"));
                hardList.add(new Word("perimeter", "obwód", "peremiter"));
                hardList.add(new Word("chord", "cięciwa", "kord"));
                hardList.add(new Word("radius", "promień", "rejdjus"));
                name = "Math";
                break;
            case 3:
                hardList.add(new Word("alacrity", "ochota", "alakriti"));
                hardList.add(new Word("connive", "spiskować", "konwajn"));
                hardList.add(new Word("nuance", "szczegół", "njuans"));
                hardList.add(new Word("staid", "poważny", "stejd"));
                hardList.add(new Word("inhibit", "powstrzymać się", "inhibit"));
                hardList.add(new Word("sweltering", "parno", "słeltering"));
                hardList.add(new Word("forthright", "jawny", "forfrajt"));
                hardList.add(new Word("fissure", "pęknięcie", "fiszjer"));
                hardList.add(new Word("intrepid", "nieustraszony", "inczrepid"));
                hardList.add(new Word("covet", "pragnąć", "kawet"));
                hardList.add(new Word("discernible", "zauważalny", "disernibyl"));
                hardList.add(new Word("arcane", "tajemniczy", "arkejn"));
                hardList.add(new Word("candor", "szczerość", "kandor"));
                hardList.add(new Word("debilitating", "osłabiający", "debilitejting"));
                hardList.add(new Word("concussion", "wstrząs", "konkaszyn"));
                hardList.add(new Word("marvel", "cud", "marwel"));
                hardList.add(new Word("precariously", "niepewnie", "prekerysli"));
                hardList.add(new Word("gale", "wichura", "gejl"));
                hardList.add(new Word("hastily", "nierozważnie", "hejskili"));
                hardList.add(new Word("dowse", "gasić", "dałs"));
                hardList.add(new Word("crisp", "kruchy", "krisp"));
                hardList.add(new Word("rattling", "enegriczny", "ratlin"));
                hardList.add(new Word("fathom", "zrozumieć", "fatom"));
                name = "Most useful";
                break;

        }
        return hardList;
    }


    public String getCategoryName()
    {
        return name;
    }
}
