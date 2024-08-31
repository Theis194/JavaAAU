import java.io.IOException;
import java.util.Map;

public class Lexer {
    public enum Token {
        EOF(-1),
        LPAREN(0), 
        RPAREN(1), 
        PLUS(2), 
        MINUS(3), 
        TIMES(4), 
        DIVIDE(5), 
        NUMBER(6);

        private final int value;

        Token(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private String identifier;
    private double numVal;
    private final int EOF = -1;
    private StringBuilder identifierBuilder = new StringBuilder();
    private StringBuilder numberBuilder = new StringBuilder();
    private Map<Character, Integer> binopPrecedence;

    public String getLastIdentifier() {
        return identifier;
    }

    public double getLastNumber() {
        return numVal;
    }

    public int getNextTokenImpl() {
        int c = ' ';
        while (Character.isWhitespace(c)) {
            try {
                c = System.in.read();
            } catch (IOException e) {
                // Handle the IOException here
                e.printStackTrace();
            }
        }

        // Finds a string
        if (Character.isLetter(c)) {
            identifierBuilder.append((char) c);
            try {
                while (Character.isLetterOrDigit(c = System.in.read())) { // This is very cursed
                    identifierBuilder.append((char) c);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            identifier = identifierBuilder.toString();
            identifierBuilder.setLength(0);

            /* switch (identifier) {
                case "def":
                    return Token.DEF;
                case "extern":
                    return Token.EXTERN;
                default:
                    return Token.IDENTIFIER;
            } */
        }

        if (Character.isDigit(c) || c == '.') {
            do {
                numberBuilder.append((char) c);
                try {
                    c = System.in.read();
                } catch (IOException e) {
                    // Handle the IOException here
                    e.printStackTrace();
                }
            } while (Character.isDigit(c) || c == '.');

            numVal = Double.parseDouble(numberBuilder.toString());
            numberBuilder.setLength(0);
            return Token.NUMBER.getValue();
        }

        if (c == EOF) {
            return Token.EOF.getValue();
        }

        return c;
    }
}