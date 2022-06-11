import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private FloorCell[][] cells;
	private MonsterMash dance;
	
	public GUI (MonsterMash dance) {
		super("Monster Mash");
		
		this.dance = dance;
		this.cells = new FloorCell[dance.getSize()][dance.getSize()];

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(dance.getSize(), dance.getSize()));

		setSize(700, 700);
		
		int ID = 0;
		FloorCell fcell;
		for (int i = 0; i < dance.getSize(); i++) {
			for (int j = 0; j < dance.getSize(); j++) {
				fcell = new FloorCell(dance.getCell(j, i).getElement().getMonster());
				fcell.setName("c" + String.valueOf(ID));
				fcell.setToolTipText(String.valueOf(ID));
				fcell.setBorder(BorderFactory.createLineBorder(Color.black));
				panel.add(fcell);
				cells[j][i] = fcell;
				ID++;
			}
		}
		
		this.add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

	public void updateCell (int c, int r, Monster mon) {
		String file = "";

		if (mon instanceof Blub) {
			file = "blub.png";
		} else if (mon instanceof Grink) {
			file = "grink.png";
		} else if (mon instanceof Orbin) {
			file = "orbin.png";
		}

		ImageIcon icon = new ImageIcon(file);
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);
		cells[c][r].setIcon(icon);
		cells[c][r].setHorizontalAlignment(SwingConstants.CENTER);
	}
}
