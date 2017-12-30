package calculator.tryparse.universalcalculator_v2.ast;

public interface Operation {
	Double getNumericResult(Double val);
	Operation getDerivative();
}
