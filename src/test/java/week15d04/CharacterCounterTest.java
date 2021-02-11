package week15d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCounterTest {

    @Test
    void countingEnglishCharacters() {
        CharacterCounter cc = new CharacterCounter();
        List<Integer> result = cc.countingEnglishCharacters("w15d04_char.txt");

//non space char: 15  | english wowel: 4  | consonant: 6
// A a2b á3:    //7                  //2             //1
//  ?BzZi       //5                  //1             //3
//mme           //3                  //1             //2

        assertEquals(15, result.get(0));
        assertEquals(4, result.get(1));
        assertEquals(6, result.get(2));
    }
}