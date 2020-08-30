import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.border.LineBorder;
public class GUIProject implements ActionListener, MouseListener{
	JFrame frame;
	int width = 1500;
	int height = 800;
	JPanel buttonPanel;
	JPanel bigPanel;

	JButton north;
	JButton south;
	JButton east;
	JButton west;
	JButton reset;

	JMenuBar menuBar;

	JMenu font;
	JMenu fontSize;
	JMenu textColor;
	JMenu bgColor;
	JMenu borderColor;

	JMenuItem[] fontOptions;
	JMenuItem[] fontSizeOptions;
	JMenuItem[] textColorOptions;
	JMenuItem[] bgColorOptions;
	JMenuItem[] borderColorOptions;

	JTextArea textArea;

	Font currentFont;
	int currentFontSize;

	Font[] fontTypes;
	int[] fontSizes;


	Color[] textColors;
	Color[] outlineColors;
	Color[] textBgColors;
	Color[] borderColors;

	String[] fontNames;
	String[] bgColorNames;
	String[] textColorNames;
	String[] outlineColorNames;

	GridLayout buttonGridLayout;
	GridLayout menuGridLayout;
	GridLayout bigGridLayout;


	public GUIProject() {

		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		font = new JMenu("Font");
		fontSize = new JMenu("Font Size");
		textColor = new JMenu("Text Color");
		bgColor = new JMenu("Background Color");
		borderColor = new JMenu("Border Color");

		fontOptions = new JMenuItem[3];
		fontSizeOptions = new JMenuItem[3];
		textColorOptions = new JMenuItem[3];
		bgColorOptions = new JMenuItem[3];
		borderColorOptions = new JMenuItem[3];

		menuGridLayout = new GridLayout(1, 6);
		menuBar.setLayout(menuGridLayout);
		menuBar.add(font); menuBar.add(fontSize); menuBar.add(textColor); menuBar.add(bgColor); menuBar.add(borderColor);

		fontNames = new String[3];
		fontNames[0] = "Arial";
		fontNames[1] = "Times New Roman";
		fontNames[2] = "Consolas";
		fontTypes = new Font[3];
		currentFontSize = 18;
		for(int x=0; x<3; x++){
			fontTypes[x] = new Font(fontNames[x], Font.PLAIN, currentFontSize);
			fontOptions[x] = new JMenuItem(fontNames[x]);
			fontOptions[x].setFont(new Font(fontNames[x], Font.PLAIN, currentFontSize));
			fontOptions[x].addActionListener(this);
			font.add(fontOptions[x]);
		}
		currentFont = fontTypes[0];

		fontSizes = new int[3];
		fontSizes[0] = 18;
		fontSizes[1] = 24;
		fontSizes[2] = 30;
		for(int x=0; x<3; x++){
			fontSizeOptions[x] = new JMenuItem(""+fontSizes[x]);
			fontSizeOptions[x].setFont(new Font(""+currentFont, Font.PLAIN, fontSizes[x]));
			fontSizeOptions[x].addActionListener(this);
			fontSize.add(fontSizeOptions[x]);
		}

		textColors = new Color[3];
		textColors[0] = Color.BLACK;
		textColors[1] = Color.BLUE;
		textColors[2] = Color.YELLOW;
		textColorNames = new String[3];
		textColorNames[0] = "BLACK";
		textColorNames[1] = "BLUE";
		textColorNames[2] = "YELLOW";
		for(int x=0; x<3; x++){
			textColorOptions[x] = new JMenuItem(textColorNames[x]);
			textColorOptions[x].setFont(new Font(""+currentFont, Font.PLAIN, currentFontSize));
			textColorOptions[x].setForeground(textColors[x]);
			textColorOptions[x].addActionListener(this);
			textColor.add(textColorOptions[x]);
		}


		textBgColors = new Color[3];
		textBgColors[0] = Color.WHITE;
		textBgColors[1] = Color.RED;
		textBgColors[2] = Color.BLACK;
		bgColorNames = new String[3];
		bgColorNames[0] = "WHITE";
		bgColorNames[1] = "RED";
		bgColorNames[2] = "BLACK";
		for(int x=0; x<3; x++){
			bgColorOptions[x] = new JMenuItem(""+bgColorNames[x]);
			bgColorOptions[x].setFont(new Font(""+currentFont, Font.PLAIN, currentFontSize));
			bgColorOptions[x].setForeground(textBgColors[x]);
			bgColorOptions[x].addActionListener(this);
			bgColor.add(bgColorOptions[x]);
		}


		borderColors = new Color[3];
		borderColors[0] = Color.GREEN;
		borderColors[1] = Color.MAGENTA;
		borderColors[2] = Color.CYAN;
		outlineColorNames = new String[3];
		outlineColorNames[0] = "GREEN";
		outlineColorNames[1] = "MAGENTA";
		outlineColorNames[2] = "CYAN";
		for(int x=0; x<3; x++){
			borderColorOptions[x] = new JMenuItem(outlineColorNames[x]);
			borderColorOptions[x].setFont(new Font(""+currentFont, Font.PLAIN, currentFontSize));
			borderColorOptions[x].setForeground(borderColors[x]);
			borderColorOptions[x].addActionListener(this);
			borderColor.add(borderColorOptions[x]);
		}

		reset = new JButton("RESET");
		reset.addActionListener(this);
		menuBar.add(reset);

		north = new JButton("NORTH");
		north.addActionListener(this);
		south = new JButton("SOUTH");
		south.addActionListener(this);
		east  = new JButton("EAST");
		east.addActionListener(this);
		west  = new JButton("WEST");
		west.addActionListener(this);

		bigPanel = new JPanel();
		bigGridLayout = new GridLayout(1 , 2);
		bigPanel.setLayout(bigGridLayout);

		buttonPanel = new JPanel();
		buttonGridLayout = new GridLayout(1, 4);
		buttonPanel.setLayout(buttonGridLayout);
		buttonPanel.add(north); buttonPanel.add(south); buttonPanel.add(east); buttonPanel.add(west);

		outlineColors = new Color[3];
		outlineColors[0] = Color.GREEN;
		outlineColors[1] = Color.MAGENTA;
		outlineColors[2] = Color.CYAN;

		north.setBorder(new LineBorder(outlineColors[0]));
		south.setBorder(new LineBorder(outlineColors[0]));
		east.setBorder(new LineBorder(outlineColors[0]));
		west.setBorder(new LineBorder(outlineColors[0]));
		reset.setBorder(new LineBorder(outlineColors[0]));

		textArea = new JTextArea();
		textArea.setBackground(textBgColors[0]);
		textArea.setForeground(textColors[0]);
		textArea.setFont(currentFont);

		bigPanel.add(buttonPanel);
		bigPanel.add(menuBar);

		frame.add(bigPanel, BorderLayout.NORTH);
		frame.add(textArea, BorderLayout.CENTER);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == north){
			frame.remove(bigPanel);
			buttonGridLayout = new GridLayout(1, 4);
			bigGridLayout = new GridLayout(1,2);
			bigPanel.setLayout(bigGridLayout);
			bigPanel.remove(menuBar);
			bigPanel.remove(buttonPanel);
			buttonPanel.setLayout(buttonGridLayout);
			bigPanel.add(buttonPanel);
			menuBar.setLayout(new GridLayout(1, 6));
			menuBar.remove(font);
			menuBar.remove(fontSize);
			menuBar.remove(textColor);
			menuBar.remove(bgColor);
			menuBar.remove(borderColor);
			menuBar.remove(reset);
			menuBar.add(font);
			menuBar.add(fontSize);
			menuBar.add(textColor);
			menuBar.add(bgColor);
			menuBar.add(borderColor);
			menuBar.add(reset);
			bigPanel.add(menuBar);
			frame.add(bigPanel, BorderLayout.NORTH);
		}
		if(e.getSource() == south){
			frame.remove(bigPanel);
			buttonGridLayout = new GridLayout(1, 4);
			bigGridLayout = new GridLayout(1,2);
			bigPanel.setLayout(bigGridLayout);
			bigPanel.remove(menuBar);
			bigPanel.remove(buttonPanel);
			buttonPanel.setLayout(buttonGridLayout);
			bigPanel.add(buttonPanel);
			menuBar.setLayout(new GridLayout(1, 6));
			menuBar.remove(font);
			menuBar.remove(fontSize);
			menuBar.remove(textColor);
			menuBar.remove(bgColor);
			menuBar.remove(borderColor);
			menuBar.remove(reset);
			menuBar.add(font);
			menuBar.add(fontSize);
			menuBar.add(textColor);
			menuBar.add(bgColor);
			menuBar.add(borderColor);
			menuBar.add(reset);
			bigPanel.add(menuBar);
			frame.add(bigPanel, BorderLayout.SOUTH);
		}
		if(e.getSource() == east){
			frame.remove(bigPanel);
			buttonGridLayout = new GridLayout(4, 1);
			bigGridLayout = new GridLayout(2,1);
			bigPanel.setLayout(bigGridLayout);
			bigPanel.remove(menuBar);
			bigPanel.remove(buttonPanel);
			buttonPanel.setLayout(buttonGridLayout);
			bigPanel.add(buttonPanel);
			menuBar.setLayout(new GridLayout(6, 1));
			menuBar.remove(font);
			menuBar.remove(fontSize);
			menuBar.remove(textColor);
			menuBar.remove(bgColor);
			menuBar.remove(borderColor);
			menuBar.remove(reset);
			menuBar.add(font);
			menuBar.add(fontSize);
			menuBar.add(textColor);
			menuBar.add(bgColor);
			menuBar.add(borderColor);
			menuBar.add(reset);
			bigPanel.add(menuBar);
			frame.add(bigPanel, BorderLayout.EAST);
		}
		if(e.getSource() == west){
			frame.remove(bigPanel);
			buttonGridLayout = new GridLayout(4, 1);
			bigGridLayout = new GridLayout(2,1);
			bigPanel.setLayout(bigGridLayout);
			bigPanel.remove(menuBar);
			bigPanel.remove(buttonPanel);
			buttonPanel.setLayout(buttonGridLayout);
			bigPanel.add(buttonPanel);
			menuBar.setLayout(new GridLayout(6, 1));
			menuBar.remove(font);
			menuBar.remove(fontSize);
			menuBar.remove(textColor);
			menuBar.remove(bgColor);
			menuBar.remove(borderColor);
			menuBar.remove(reset);
			menuBar.add(font);
			menuBar.add(fontSize);
			menuBar.add(textColor);
			menuBar.add(bgColor);
			menuBar.add(borderColor);
			menuBar.add(reset);
			bigPanel.add(menuBar);
			frame.add(bigPanel, BorderLayout.WEST);
		}
		for(int x=0; x<3; x++){
			if(e.getSource() == fontOptions[x]){
				currentFont = fontTypes[x];
				textArea.setFont(new Font(fontNames[x], Font.PLAIN, currentFontSize));
			}
			if(e.getSource() == fontSizeOptions[x])
			{
				currentFontSize = fontSizes[x];
				textArea.setFont(new Font(""+textArea.getFont(), Font.PLAIN, currentFontSize));
			}
			if(e.getSource() == textColorOptions[x]){
				textArea.setForeground(textColors[x]);
			}
			if(e.getSource() == bgColorOptions[x]){
				textArea.setBackground(textBgColors[x]);
			}
			if(e.getSource() == borderColorOptions[x]){
				north.setBorder(new LineBorder(outlineColors[x]));
				south.setBorder(new LineBorder(outlineColors[x]));
				east.setBorder(new LineBorder(outlineColors[x]));
				west.setBorder(new LineBorder(outlineColors[x]));
				reset.setBorder(new LineBorder(outlineColors[x]));
			}
		}
		if(e.getSource() == reset)
		{
			frame.remove(bigPanel);
			buttonGridLayout = new GridLayout(1, 4);
			bigGridLayout = new GridLayout(1,2);
			bigPanel.setLayout(bigGridLayout);
			bigPanel.remove(menuBar);
			bigPanel.remove(buttonPanel);
			buttonPanel.setLayout(buttonGridLayout);
			bigPanel.add(buttonPanel);
			menuBar.setLayout(new GridLayout(1, 6));
			menuBar.remove(font);
			menuBar.remove(fontSize);
			menuBar.remove(textColor);
			menuBar.remove(bgColor);
			menuBar.remove(borderColor);
			menuBar.remove(reset);
			menuBar.add(font);
			menuBar.add(fontSize);
			menuBar.add(textColor);
			menuBar.add(bgColor);
			menuBar.add(borderColor);
			menuBar.add(reset);
			bigPanel.add(menuBar);
			frame.add(bigPanel, BorderLayout.NORTH);

			currentFont = fontTypes[0];
			currentFontSize = 12;

			north.setBorder(new LineBorder(outlineColors[0]));
			south.setBorder(new LineBorder(outlineColors[0]));
			east.setBorder(new LineBorder(outlineColors[0]));
			west.setBorder(new LineBorder(outlineColors[0]));
			reset.setBorder(new LineBorder(outlineColors[0]));

			textArea.setBackground(textBgColors[0]);
			textArea.setForeground(textColors[0]);
			textArea.setFont(currentFont);
			textArea.setText(null);
		}
		frame.revalidate();
	}
	public void mouseClicked(MouseEvent e){
	}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){
	}
	public void mouseReleased(MouseEvent e){
	}

	public static void main(String args[]){

		GUIProject app = new GUIProject();

	}
}