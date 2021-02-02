package week14d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingTest {
// sh.readFile("C:/training/training-solutions/src/main/resources/week14d02_shopList.txt");

    @Test
    void getItems() {
        Shopping sh = new Shopping();
        sh.readFile("src/main/resources/week14d02_shopList.txt");

        //A10 corn,hot_dog,rolls   K8921 wine,soda
        assertEquals("[corn, hot_dog, rolls]", sh.getItems("A10").toString());
        assertEquals(2, sh.getItems("K8921").size());
    }

    @Test
    void sumOfDelivered() {
        Shopping sh = new Shopping();
        sh.readFile("src/main/resources/week14d02_shopList.txt");

        //A10 corn,hot_dog,rolls   K8921 wine,soda
        assertEquals(3, sh.itemsOnList("A10"));
        assertEquals(2, sh.itemsOnList("K8921"));
    }

    @Test
    void itemsOnList() {
        Shopping sh = new Shopping();
        sh.readFile("src/main/resources/week14d02_shopList.txt");

        //{apple=1, basil=1, bbq_sauce=1, beer=2, bread=1, carrot=1, cheese=2,
        // chips=1, cola=1, corn=1, flour=1, hot_dog=1, meet=2, oregano=1,
        // passata=2, pasta=2, pear=1, pepper=1, pizza_dough=1, potato=1,
        // rolls=1, rosmary=2, salt=1, soda=2, sugar=3, tomato=2, wine=1}
        assertEquals(1, sh.statistics().get("potato"));
        assertEquals(1, sh.statistics().get("wine"));
        assertEquals(3, sh.statistics().get("sugar"));
    }

    @Test
    void statistics() {
        Shopping sh = new Shopping();
        sh.readFile("src/main/resources/week14d02_shopList.txt");

        assertEquals(1, sh.sumOfDelivered("corn"));
        assertEquals(2, sh.sumOfDelivered("rosmary"));
        assertEquals(3, sh.sumOfDelivered("sugar"));
    }
}