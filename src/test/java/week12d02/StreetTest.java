package week12d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    void getLastHouseNr() {
        Street street = new Street();
        street.sellSite(new Site(true, 1, FenceType.PERFECT));
        street.sellSite(new Site(true, 2, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(false, 3, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(true, 4, FenceType.PERFECT));
        street.sellSite(new Site(true, 5, FenceType.NO_FENCE));

        assertEquals(8, street.getLastHouseNr());

        street.sellSite(new Site(false, 6, FenceType.PERFECT));

        assertEquals(3, street.getLastHouseNr());
    }

    @Test
    void makeStatistic() {
        Street street = new Street();
        street.sellSite(new Site(true, 1, FenceType.PERFECT));
        street.sellSite(new Site(true, 2, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(false, 3, FenceType.NEED_UPGRADE));
        street.sellSite(new Site(true, 4, FenceType.PERFECT));
        street.sellSite(new Site(true, 5, FenceType.NO_FENCE));
        street.sellSite(new Site(false, 6, FenceType.PERFECT));

        assertEquals(3, street.makeStatistic().size());
        assertEquals(3, street.getStatistics().get(0).getCount());
        assertEquals(2, street.getStatistics().get(1).getCount());
    }
}
//Készítsd el a Site (telek) nevű osztályt. Egy telek jellemzői, páros vagy páratlan oldalon található,
// (0 = páros oldal 1 = páratlan oldal), a telek hossza méterben. Illetve egy Fence enum, ami a kerítés
// állapotát írja le. A kerités állapota lehet, PERFECT, NEED_UPGRADE, NO_FENCE. (konstruktor, getterek)
//Készítsd el a Street neű osztályt, melyben eladott telkek listája található. Kezdetben ez egy üres lista.
//Készíts egy sellSite(Site site) metódust, ami egy telek eladását reprezentálja, vagyis hozzádunk egy telket
// a listához.
//Határozd meg az utoljára eladott telek (lista utolsó eleme) házszámát, ha tudjuk, hogy a telkeket a két
// oldalon egymás után adták el! (páros oldalon kettőtől, páratlan oldalon 1-től indul a számozás) pl:
//        0 10 PERFECT
//        0 7 NEED_UPGRADE
//        1 12 NEED_UPGRADE
//        0 9 PERFECT
//        0 11 NO_FENCE
//        1 13 PERFECT
//        A példában a házszámok rendre: 2,4,1,6,8,3
//Készíts statisztikát, ami a kerítés állapota alapján visszaadja, hogy mennyi telket adtak el kerítésfajtánként! (Egy metódus legyen, a visszatérési értéket ti döntitek el, de abból legyen egyértelmű, hogy melyikből mennyit adtak el.)
