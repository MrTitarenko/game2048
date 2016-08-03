import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame implements KeyListener {
    static JLabel lsumm;
    static JTextField text;
    String rezult;
    Doings handler = new Doings();
    Count nums = new Count();
    Count copy = new Count();
    JButton[] buttons = new JButton[6];
    static JTextField[][] jtfArray = new JTextField[4][4];

    public Window(String s) {
        super(s);
        setLayout(new FlowLayout());

        Font fontsum = new Font("Times New Roman", Font.ITALIC, 16);
        Font fonttf = new Font("Arial", Font.BOLD, 16);
        Font fontbut = new Font("Arial", Font.BOLD, 12);

        text = new JTextField(16);
        text.setBorder(null);
        text.setBackground(null);
        text.setEditable(false);
        add(text);

        lsumm = new JLabel("0");
        lsumm.setFont(fontsum);
        add(lsumm);

        for (int j = 0; j < 4; j++) {
            for (int t = 0; t < 4; t++) {
                jtfArray[j][t] = new JTextField(3);
                jtfArray[j][t].setEditable(false);
                jtfArray[j][t].setFont(fonttf);
                add(jtfArray[j][t]);
                jtfArray[j][t].addKeyListener(this);
            }
        }

        buttons[0] = new JButton(" new ");
        buttons[3] = new JButton(" LEFT ");
        buttons[1] = new JButton("  UP  ");
        buttons[4] = new JButton(" DOWN ");
        buttons[2] = new JButton(" help ");
        buttons[5] = new JButton(" RIGHT ");

        for (JButton b : buttons) {
            b.setFont(fontbut);
            add(b);
            b.addActionListener(handler);
            b.addKeyListener(this);
        }

        //JFrame.addKeyListener(this);

        nums.Random();
        nums.Random();
        nums.Print();
    }

    public class Doings implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            nums.equal();

            if (e.getSource() == buttons[0]) {
                nums.Moves("n");
                nums.Print();
                return;
            } else if (e.getSource() == buttons[1]) {
                nums.Moves("u");
            } else if (e.getSource() == buttons[2]) {
                nums.Moves("h");
                return;
            } else if (e.getSource() == buttons[3]) {
                nums.Moves("l");
            } else if (e.getSource() == buttons[4]) {
                nums.Moves("d");
            } else if (e.getSource() == buttons[5]) {
                nums.Moves("r");
            }

            copy.gameOver();
            if (nums.compare()) nums.Random();
            nums.Print();
            nums.win();
        }
    }

    public void keyPressed(KeyEvent e) {
        nums.equal();

        if (e.getKeyCode() == KeyEvent.VK_UP) nums.Moves("u");
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) nums.Moves("l");
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) nums.Moves("d");
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) nums.Moves("r");

        copy.gameOver();
        if (nums.compare()) nums.Random();
        nums.Print();
        nums.win();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}