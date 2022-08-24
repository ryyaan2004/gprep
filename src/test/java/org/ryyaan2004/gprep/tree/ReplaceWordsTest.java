package org.ryyaan2004.gprep.tree;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReplaceWordsTest {

    @Test
    void given_example() {
        List<String> roots = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String expected = "the cat was rat by the bat";
        ReplaceWords cut = new ReplaceWords();
        Assertions.assertEquals(expected, cut.replaceWords(roots, sentence));
    }

    @Test
    void more_complex() {
        List<String> roots = Arrays.asList("the", "fun", "thing", "about", "tiggers");
        String sentence = "thematically funderfull thingering abouts tiggershed";
        String expected = "the fun thing about tiggers";
        ReplaceWords cut = new ReplaceWords();
        Assertions.assertEquals(expected, cut.replaceWords(roots, sentence));
    }
}
