package com.algo.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mkarki
 */
class SynonymousSentencesTest {
    private SynonymousSentences synonymousSentences;

    @BeforeEach
    void setup() {
        synonymousSentences = new SynonymousSentences();
    }

    @Test
    void testGenerateSentences() {
        List<List<String>> synonyms = new ArrayList<>();
        buildSynonyms(synonyms);

        List<String> expectedSentences = new ArrayList<>();
        buildExpectedSentences(expectedSentences);
        assertThat(synonymousSentences.generateSentences(synonyms, "I am happy today but was sad yesterday"),
                is(expectedSentences));
    }

    @Test
    void testGenerateSentencesII() {
        List<List<String>> synonyms = new ArrayList<>();
        buildSynonyms(synonyms);

        List<String> expectedSentences = new ArrayList<>();
        buildExpectedSentences(expectedSentences);
        assertThat(synonymousSentences.generateSentencesII(synonyms, "I am happy today but was sad yesterday"),
                is(expectedSentences));
    }

    private void buildSynonyms(List<List<String>> synonyms) {
        List<String> synonym1 = new ArrayList<>() {{
            add("happy");
            add("joy");
        }};
        List<String> synonym2 = new ArrayList<>() {{
            add("sad");
            add("sorrow");
        }};

        List<String> synonym3 = new ArrayList<>() {{
            add("joy");
            add("cheerful");
        }};
        synonyms.add(synonym1);
        synonyms.add(synonym2);
        synonyms.add(synonym3);
    }

    private void buildExpectedSentences(List<String> expectedSentences) {
        expectedSentences.add("I am cheerful today but was sad yesterday");
        expectedSentences.add("I am cheerful today but was sorrow yesterday");
        expectedSentences.add("I am happy today but was sad yesterday");
        expectedSentences.add("I am happy today but was sorrow yesterday");
        expectedSentences.add("I am joy today but was sad yesterday");
        expectedSentences.add("I am joy today but was sorrow yesterday");
    }
}