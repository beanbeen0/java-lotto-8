package lotto.messge;

import java.util.List;

public class Formatter {

    public static String blocks(String... blocks) {
        return String.join("\n", blocks);
    }

    public static String inlines(List<String> inlines) {
        return String.join("\n", inlines);
    }

    public static String spans(String... spans) {
        return String.join(" ", spans);
    }
}
