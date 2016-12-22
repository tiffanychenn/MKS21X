import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Window extends JFrame implements ActionListener{
    private Container pane;

    private JButton b, b1;
    private JTextField t;

    public void actionPerformed(ActionEvent e){
	if ("CtoF".equals(e.getActionCommand())){
	    t.setText(String.valueOf(Temp.CtoF(Integer.parseInt(t.getText()))));
	}
	else{
	    t.setText(String.valueOf(Temp.FtoC(Integer.parseInt(t.getText()))));
	}
    }
 
    //CONSTRUCTOR SETS EVERYTHING UP
    public Window() {
	this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	b = new JButton("Convert fahrenheit to celsius");
	b1 = new JButton("Convert celsius to fahrenheit");
	b.setActionCommand("FtoC");
	b1.setActionCommand("CtoF");
	t = new JTextField(12);
	pane.add(t);
	pane.add(b);
	pane.add(b1);

	b.addActionListener(this);
	b1.addActionListener(this);
    }

    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Window g = new Window();
	g.setVisible(true);
    }
}
