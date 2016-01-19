package makemenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import auxiliary.Auxiliary;

public class MakeMenu {
	public Auxiliary aux = new Auxiliary();
	public JMenuBar menubar;
	public JMenu menu;
	public JMenuItem exit,info,help;

	public MakeMenu(){
		menubar = new JMenuBar();
		menu = new JMenu("Menu");

		exit = new JMenuItem("Exit");
		info = new JMenuItem("Information");
		help = new JMenuItem("Help");

		menu.setFont(aux.font);
		menu.add(exit);
		menu.add(info);
		menu.add(help);
		menubar.add(menu);
	}
}