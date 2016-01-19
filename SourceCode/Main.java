import javax.swing.SwingUtilities;

import calculatormodel.CalculatorModel;

public class Main{
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				CalculatorModel cal = new CalculatorModel("Caculator");
			}
		});
	}
}