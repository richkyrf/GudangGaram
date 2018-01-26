package KomponenGUI;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class JtKoma extends JTextField {

    public JtKoma() {
        setHorizontalAlignment(4);
        setFont(new java.awt.Font("Tahoma", 0, 18));
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                selectAll();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != '\b') && (c != '')) {
                    getToolkit().beep();
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (getText().length() == 0) {
                    setText("0");
                } else if (getText().length() > 2) {
                    setText(getText().substring(0, 2));
                } else {
                    setText(getText());
                }
            }
        });

    }

    public void setint(int s) {
        if (s <= 9) {
            setText("0" + Integer.toString(s));
        } else {
            setText(Integer.toString(s));
        }
    }

    public int getint() {
        String s = getText();
        if (s.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(s);
        }
    }

    public String GetString() {
        String s = getText();
        if (s.isEmpty()) {
            return s = "0";
        } else if (s.length() == 1) {
            return "0" + s;
        } else {
            return s;
        }
    }
}
