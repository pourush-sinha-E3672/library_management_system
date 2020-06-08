package springsconcept;




import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;



public class ExpressionUtils {

    private static boolean autoGrowNullReferences = true;
    private static boolean autoGrowCollections = true;
    private static int maximumAutoGrowSize = 268435456;

    private static SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(autoGrowNullReferences, autoGrowCollections);
    private static ExpressionParser parser = new SpelExpressionParser(spelParserConfiguration);

    public static <T> T evaluateExpression(String expression, Object object, Class<T> classOfT) {
        Expression exp = getExpression(expression);
        return exp.getValue(object, classOfT);

    }

    private static Expression getExpression(String expression) {
        return parser.parseExpression(expression);
    }

    public static void main(String[] args) {
        parser.parseExpression("{a,b,c}.contains(b)");
    }

}
