package lambda;

/**
 * Project: AdvancedJava
 * Author: AFIF AL MAMUN
 * Created in 10/11/20
 * Web: https://afifaniks.me
 */

@FunctionalInterface
interface Converter {
    String apply(String string);
}

@FunctionalInterface
interface MessageTranslator {
    String translate(String msg);
}

public class LambdaTest {
    public void send(MessageTranslator translator, String msg) {
        String translated = translator.translate(msg);
        System.out.println("Translated: " + translated);
    }

    public static void main(String[] args) {
        Converter upperCaseConverter = string -> string.toUpperCase();
        System.out.println(upperCaseConverter.apply("teSt StrInG"));

        String msg1 = "বাংলাদেশ";
        String msg2 = "Bangladesh";

        MessageTranslator translator = msg -> msg1.equals(msg) ? msg2 : "Unknown";

        new LambdaTest().send(translator, "বাংলাদেশ");

        Converter a = (String c) -> {
            c += "Test";
            c += "Tasty";

            c = c.toLowerCase();
            return c;
        };

        System.out.println(a.apply("Boom"));
    }
}
