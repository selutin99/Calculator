package calculator.tryparse.universalcalculator_v2;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import com.fathzer.soft.javaluator.Parameters;

import java.util.Iterator;

class ExtendedDoubleEvaluator extends DoubleEvaluator {

    private static final Function SQRT = new Function("sqrt", 1);
    private static final Function PERCENT = new Function("percent", 1);
    private static Parameters PARAMS = null;

    static {
        PARAMS = DoubleEvaluator.getDefaultParameters();
        PARAMS.add(SQRT);
        PARAMS.add(PERCENT);
    }

    public ExtendedDoubleEvaluator (){
        super(PARAMS);
    }

    @Override
    protected Double evaluate(Function function, Iterator<Double> arguments, Object evaluationContext) {
        if (function == SQRT) {
            return Math.sqrt(arguments.next());
        }
        else if(function == PERCENT){
            return arguments.next()/100;
        }
        else
            return super.evaluate(function, arguments, evaluationContext);
    }
}