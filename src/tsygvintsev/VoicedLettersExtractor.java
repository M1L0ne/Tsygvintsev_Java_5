package tsygvintsev;

import java.util.*;

public class VoicedLettersExtractor {

    private static final Set<Character> VOICED_CONSONANTS = Set.of(
            'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
    );

    public static List<Character> extract(String text) {
        if (text == null) {
            return Collections.emptyList();
        }

        Set<Character> found = new TreeSet<>();

        for (char c : text.toLowerCase().toCharArray()) {
            if (VOICED_CONSONANTS.contains(c)) {
                found.add(c);
            }
        }

        return new ArrayList<>(found);
    }
}
