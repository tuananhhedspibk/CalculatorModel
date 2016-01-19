package calculatormodel;

import javax.swing.JPanel;

import java.awt.Dimension;

public interface CalculatorModelInterface {
	public JPanel top = new JPanel(),bottom1 = new JPanel(),bottom2 = new JPanel(),bottom3 = new JPanel(),bottom4 = new JPanel(),bottom5 = new JPanel();

	public int[] dimW = {300,70,100,150};
	public int[] dimH = {35, 40};

	public Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
	public Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
	public Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
	public Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);
}