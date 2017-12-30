package calculator.tryparse.universalcalculator_v2.ast;

import android.os.Build;
import android.support.annotation.RequiresApi;

import static java.util.Objects.requireNonNull;

public abstract class BinaryOperation implements Operation {
	final protected Operation left;
	final protected Operation right;
	
	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
	public BinaryOperation(Operation left, Operation right) {
		this.left = requireNonNull(left);
		this.right = requireNonNull(right);
	}
	
	public Operation getLeft(){
		return left;
	}
	
	public Operation getRight(){
		return right;
	}
}
