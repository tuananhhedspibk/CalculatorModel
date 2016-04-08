package calculatormodel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

import listnode.ListNode;
import linkedlist.LinkedList;
import auxiliary.Auxiliary;
import makemenu.MakeMenu;
import helpframe.HelpFrame;

public class CalculatorModel extends JFrame implements ActionListener,CalculatorModelInterface,WindowListener{
	double result;			// --- Store result of calculation ---
	double value;			// --- Store operation of calculation ---
	int lock = 0;			// --- Flag for double number (lock == 0 -> not double) ? (lock == 1 -> double) ---

	LinkedList stack = new LinkedList();		// --- Store expression ---
	Auxiliary aux = new Auxiliary();			// --- Store font of text ---
	MakeMenu makeMenu = new MakeMenu();			// --- Make menu ---
	HelpFrame helpFrame = new HelpFrame();		// --- Make help frame ---

	public JButton button;						// --- Temporary object, is used to create button in calculator ---
	public JTextArea textField;					// --- Represent for screen of calculator ---

	public CalculatorModel(String title){
		super(title);

		textField = new JTextArea("",2,18);
		textField.setFont(aux.font);

		setJMenuBar(makeMenu.menubar);

		makeMenu.exit.addActionListener(this);		// * Add listener to menu 's item
		makeMenu.help.addActionListener(this);		// *
		makeMenu.info.addActionListener(this);		// *
	
		top.add(textField);
		setLayout(new GridLayout(7,5));

		bottom1.add(button = new JButton("0"));		// --- Make button for each panel ---
		button.setFont(aux.font);
		button.setPreferredSize(zeroButDimension);
		button.addActionListener(this);
		bottom1.add(button = new JButton("."));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom1.add(button = new JButton("/"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom1.add(button = new JButton("="));
		button.setFont(aux.font);
		button.setPreferredSize(rColumnDimension);
		button.addActionListener(this);
		
		bottom2.add(button = new JButton("1"));		// --- Make button for each panel ---
		button.setPreferredSize(regularDimension);
		button.setFont(aux.font);
		button.addActionListener(this);
		bottom2.add(button = new JButton("2"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom2.add(button = new JButton("3"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom2.add(button = new JButton("*"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom2.add(button = new JButton("nega"));
		button.setFont(aux.font);
		button.addActionListener(this);
		button.setPreferredSize(rColumnDimension);

		bottom3.add(button = new JButton("4"));		// --- Make button for each panel ---
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom3.add(button = new JButton("5"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom3.add(button = new JButton("6"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom3.add(button = new JButton("-"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom3.add(button = new JButton("√"));
		button.setFont(aux.font);
		button.setPreferredSize(rColumnDimension);
		button.addActionListener(this);


		bottom4.add(button = new JButton("7"));		// --- Make button for each panel ---
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom4.add(button = new JButton("8"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom4.add(button = new JButton("9"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom4.add(button = new JButton("+"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this); 
		bottom4.add(button = new JButton("C"));
		button.setFont(aux.font);
		button.setPreferredSize(rColumnDimension);
		button.addActionListener(this);

		bottom5.add(button = new JButton("sin"));		// --- Make button for each panel ---
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom5.add(button = new JButton("cos"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom5.add(button = new JButton("tan"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this);
		bottom5.add(button = new JButton("PI"));
		button.setFont(aux.font);
		button.setPreferredSize(regularDimension);
		button.addActionListener(this); 
		bottom5.add(button = new JButton("1/x"));
		button.setFont(aux.font);
		button.setPreferredSize(rColumnDimension);
		button.addActionListener(this);				

		add(top);
		add(bottom5);
		add(bottom4);
		add(bottom3);
		add(bottom2);
		add(bottom1);
		setSize(450,450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		String string = e.getActionCommand();			// --- Return command string associated action ---
		char c = string.charAt(0);
		char c1 = ';';
		if(string.length() >= 2){
			c1 = string.charAt(1);
		}
		if(c == 'E'){									// --- Exit func handler ---
			Runtime run = Runtime.getRuntime();
			try{
				run.exec("/bin/sh shell.sh");			// --- Execute the specific string command in a separate process ---
			}
			catch(Exception exp){
				exp.printStackTrace();
			}
			System.exit(0);
		}
		else if(c == 'I'){								// --- Display infor about app handler ---
			String msg = new String();
			msg = "This Is My Calculator Application. I used Java Language To Wrote It.\nYou Can Use It Like Many Popular Calculators.\nCreated By AnhTT - HUST\nCopyRight © 2015. Contact Me At :tuananhhedspibk@gmail.com For More Details\nHelp Fun !!!";
			JOptionPane.showMessageDialog(this,msg,"Help",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(c == 'H'){								// --- Display help frame ---
			helpFrame.setVisible(true);
		}
		else if(c == '+'){								// --- Make expression for plus operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == '-' ){								// --- Make expression for minus operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == '*'){								// --- Make expression for multiple operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == '/'){								// --- Make expression for divide operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == '√'){								// --- Make expression for √ opearator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == 's'){								// --- Make expression for sin operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == 'c'){								// --- Make expression for cos operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == 't'){								// --- Make expression for tan operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == 'n'){								// --- Make expression for negative operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
		}
		else if(c == '1' && c1 == '/'){					// --- Make expression for inverse operator ---
			lock = 0;
			if(!textField.getText().equals("")){
				getValue();
				textField.setText("");
				stack.addLastDouble(value);
			}
			stack.addLastChar(c);
			c1 = ';';
		}
		else if(c >= '0' && c <= '9' && c1 == ';'){			// --- Set number to screen ---
			textField.append(Integer.toString(c - '0'));
		}
		else if(c == '.'){									// --- Make double number ---
			if(lock == 0){
				lock = 1;
				char value[] = new char[1];
				value[0] = c;
				String str = new String(value);
				textField.append(str);
			}	
		}
		else if(c == 'P'){									// --- Get PI value ---
			getPI();
		}
		else if(c == '='){									// --- Compute expression ---
			try{ 
				lock = 0;
				if(!textField.getText().equals("")){
					getValue();
					textField.setText("");
					stack.addLastDouble(value);
				}
				if(stack.isEmpty()){						// --- Handle when expression doesn't exist ---
					if(!textField.getText().equals("")){
						result = Double.parseDouble(textField.getText());
						textField.setText(Double.toString(result));
					}
				}
				else{
					compute();
				}
			}
			catch(NumberFormatException nfe){
				nfe.printStackTrace();
			}
		}
		else if(c == 'C'){									// --- Reset all variables ---
			clear();
			textField.setText("");
		}
	}

	public void compute(){
		double value0 = 0.0,value1 = 0.0;
		int error = 0;						// --- If have syntax error , error will equals to 1 ---
		char c = ';';
		ListNode runner = stack.firstNode; 
		while(runner != null){				// --- After calculate, push result to stack ---
			if(runner.string.equals("Char")){
				error = 1;							
				break;
			}
			else{
				value0 = runner.d;
				stack.removeFirst();
				if(!stack.isEmpty()){ 
					runner = stack.firstNode;
					if(runner.string.equals("Double")){
						error = 1;
						break;
					}
					else{
						if(runner.c == '√'){				// --- Handle operator for each case (unary operator) --- 
							stack.removeFirst();
							value0 = Math.sqrt(value0);
							if(stack.isEmpty()){
								break;
							}
							stack.addFirstDouble(value0);
							runner = stack.firstNode;
						}
						else if(runner.c == 's'){			// --- Handle operator for each case (unary operator) ---
							stack.removeFirst();
							value0 = Math.sin(value0);
							if(stack.isEmpty()){
								break;
							}
							stack.addFirstDouble(value0);
							runner = stack.firstNode;
						}
						else if(runner.c == 'c'){			// --- Handle operator for each case (unary operator) ---
							stack.removeFirst();
							value0 = Math.cos(value0);
							if(stack.isEmpty()){
								break;
							}
							stack.addFirstDouble(value0);
							runner = stack.firstNode;
						}
						else if(runner.c == 't'){			// --- Handle operator for each case (unary operator) ---
							stack.removeFirst();
							value0 = Math.tan(value0);
							if(stack.isEmpty()){
								break;
							}
							stack.addFirstDouble(value0);
							runner = stack.firstNode;
						}
						else if(runner.c == 'n'){			// --- Handle operator for each case (unary operator) ---
							stack.removeFirst();
							value0 = value0 * -1;
							if(stack.isEmpty()){
								break;
							}
							stack.addFirstDouble(value0);
							runner = stack.firstNode;
						}
						else if(runner.c == '1'){			// --- Handle operator for each case (unary operator) ---
							stack.removeFirst();
							value0 = 1 / value0;
							if(stack.isEmpty()){
								break;
							}
							stack.addFirstDouble(value0);
							runner = stack.firstNode;
						}
						else if(runner.c == '+'){			// --- Handle operator for each case (Binary operator) ---
							stack.removeFirst();
							if(stack.isEmpty()){
								error = 1;
								break;
							}
							runner = stack.firstNode;
							if(runner.string.equals("Char")){
								error = 1;
								break;
							}
							else{
								value1 = runner.d;
								stack.removeFirst();
								value0 = value0 + value1;
								if(stack.isEmpty()){
									break;
								}
								stack.addFirstDouble(value0);
								runner = stack.firstNode;
							}
						}
						else if(runner.c == '-'){			// --- Handle operator for each case (Binary operator) ---
							stack.removeFirst();
							if(stack.isEmpty()){
								error = 1;
								break;
							}
							runner = stack.firstNode;
							if(runner.string.equals("Char")){
								error = 1;
								break;
							}
							else{
								value1 = runner.d;
								stack.removeFirst();
								value0 = value0 - value1;
								if(stack.isEmpty()){
									break;
								}
								stack.addFirstDouble(value0);
								runner = stack.firstNode;
							}
						}
						else if(runner.c == '*'){			// --- Handle operator for each case (Binary operator) ---
							stack.removeFirst();
							if(stack.isEmpty()){
								error = 1;
								break;
							}
							runner = stack.firstNode;
							if(runner.string.equals("Char")){
								error = 1;
								break;
							}
							else{
								value1 = runner.d;
								stack.removeFirst();
								value0 = value0 * value1;
								if(stack.isEmpty()){
									break;
								}
								stack.addFirstDouble(value0);
								runner = stack.firstNode;
							}
						}
						else if(runner.c == '/'){			// --- Handle operator for each case (Binary operator) ---
							stack.removeFirst();
							if(stack.isEmpty()){
								error = 1;
								break;
							}
							runner = stack.firstNode;
							if(runner.string.equals("Char")){
								error = 1;
								break;
							}
							else{
								value1 = runner.d;
								stack.removeFirst();
								value0 = value0 / value1;
								if(stack.isEmpty()){
									break;
								}
								stack.addFirstDouble(value0);
								runner = stack.firstNode;
							}
						}
					}
				}
				else{
					break;
				}
			}
		}
		if(!stack.isEmpty()){
			stack.clear();
		}
		stack = new LinkedList();
		if(error == 0){
			result = value0;								// --- Set value for result ---
			textField.setText(Double.toString(result));		// --- Display result on screen ---
		}
		else{
			textField.setText("Syntax Error");				// --- Notice error ---
		}
	}

	public void getValue(){
		// --- Get number in screen ---
		value = Double.parseDouble(textField.getText());
	}

	public void getPI(){
		textField.setText(Double.toString(Math.PI));
	}

	public void clear(){
		// --- Reset value of all variables ---
		value = 0;
		lock = 0;
		result = 0;
	}
	
	public void windowOpened(WindowEvent we){
		
	}
	
	public void windowClosing(WindowEvent we){
		Runtime run = Runtime.getRuntime();
		try{
			run.exec("/bin/sh shell.sh");		// --- Execute the specific string command in a separate process ---
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}

	public void windowClosed(WindowEvent we){
		Runtime run = Runtime.getRuntime();
		try{
			run.exec("/bin/sh shell.sh");		// --- Execute the specific string command in a separate process ---
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public void windowIconified(WindowEvent we){
	
	}
	
	public void windowDeiconified(WindowEvent we){
	
	}
	public void windowActivated(WindowEvent we){

	}
	
	public void windowDeactivated(WindowEvent we){
	
	}
}