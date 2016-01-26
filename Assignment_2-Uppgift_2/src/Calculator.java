import java.math.BigDecimal;

/**Class that simulates a calculator*/
public class Calculator {
	private String operator;
	private BigDecimal result;
	private BigDecimal operand;
	private BigDecimal operand2;
	
	private int operandDecimals = 0;
	public boolean operandDoFraction = false;
	//Using this when referring to instance variables makes it extra obvious that the reference 
	//is to an instance variable. Writing this.operator is the same as  just writing operator
	
	/**Creates  a new calculator instance*/
	public Calculator() {
		this.operator = "";
		this.result = BigDecimal.valueOf(0);
		this.operand = BigDecimal.valueOf(0); //http://en.wikipedia.org/wiki/Operand
		this.operand2 = BigDecimal.valueOf(0);
		operandDoFraction = false;
		operandDecimals = 0;
	}
	
	/** returns the operator */
	public String getOperator(){
		return this.operator;
	}
	
	/**returns result*/
	public double getResult(){
		return this.result.doubleValue();
	}
	
	public double getOperand(){
		return this.operand.doubleValue();	
	}
	
	/**buttonpress*/ 
	public void numberButtonPressed(int number){
		// Add selected number.
		if(!operandDoFraction){
			this.operand = this.operand.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(number));
		} else {
			// Add it as a fraction.
			operandDecimals++;
			BigDecimal decimalMul = BigDecimal.valueOf(1).movePointLeft(operandDecimals);
			this.operand = this.operand.add(BigDecimal.valueOf(number).multiply(decimalMul));
		}
	}
	
	public void decimalButtonPressed(){
		operandDoFraction = true;
	}
	
	/**clears all including operand and result*/
	public void clear(){
		this.operator = "";
		this.result = BigDecimal.valueOf(0);
		this.operand = BigDecimal.valueOf(0);
		operandDoFraction = false;
		operandDecimals = 0;
	}
	
	public void plus(){
		this.equals();
	   	this.operand = BigDecimal.valueOf(0);
	   	this.operator = "+";
	   	operandDoFraction = false;
		operandDecimals = 0;
	}
	
	public void minus(){
		this.equals();
		operand = BigDecimal.valueOf(0);
		operator = "-";
		operandDoFraction = false;
		operandDecimals = 0;
	}
	
	public void mult(){
		this.equals();
		operand = BigDecimal.valueOf(0);
		operator = "*";
		operandDoFraction = false;
		operandDecimals = 0;
	}
	
	public void div(){
		this.equals();
		operand = BigDecimal.valueOf(0);
		operator = "/";
		operandDoFraction = false;
		operandDecimals = 0;
	}
	
	public void equals(){
		if (operator.equals("*")){
			result = result.multiply(operand);
		}else if(operator.equals("-")){
			result = result.subtract(operand);
		}else if(operator.equals("+")){
			result = result.add(operand);
		}else if(operator.equals("/")){
			result = result.divide(operand);
		}
		else if(operator.isEmpty()) {
			result = operand;
		}
		operand = BigDecimal.valueOf(0);
		operandDoFraction = false;
		operandDecimals = 0;
	}
}
