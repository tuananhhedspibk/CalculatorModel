package helpframe;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

import auxiliary.Auxiliary;

public class HelpFrame extends JFrame{
	JTextArea textHelp = new JTextArea();
	Auxiliary aux = new Auxiliary();

	public HelpFrame(){
		super("Help");
		textHelp.setFont(aux.font);
		textHelp.setEditable(false);
		try{
			BufferedReader input = new BufferedReader(new FileReader("helpInfo.dat"));
			StringBuffer buffer = new StringBuffer();
			String text;
			while((text = input.readLine()) != null){
				buffer.append(text + "\n");
			}
			input.close();
			textHelp.append(buffer.toString());
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}	
		add(textHelp);
		setSize(660,500);
	}
}