package KomponenGUI;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JTextField;
public class JtextF extends JTextField {

    static int MaxText = 255;

    public JtextF() {
        setText("");
        setFont(new java.awt.Font("Tahoma", 0, 18));
        setDisabledTextColor(Color.BLUE);
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                JtextF.this.setText(JtextF.this.getText());
                JtextF.this.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                JtextF.this.setText(JtextF.this.getText());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (JtextF.this.getText().length() >= MaxText) {
                    JtextF.this.getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    
    public void setribuankomaText(String s) {
        try {
            double n = Double.valueOf(s);
            DecimalFormat uang = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setCurrencySymbol("");
            symbols.setGroupingSeparator('.');
            symbols.setMonetaryDecimalSeparator(',');
            uang.setDecimalFormatSymbols(symbols);
            String S = uang.format(n);
            this.setText(S);
        } catch (Exception e) {
            System.out.println("KomponenGUI.JtextF.setribuankomaText()" + e);
            this.setText("0");
        }
    }
    
    public String getribuankomaText() {
        try {
            return this.getText().replace(".", "").replace(",", ".");
        } catch (Exception e) {
            return ("0");
        }
    }

    /*public void setribuankomaText(String s) {
        try{
        double n = Double.valueOf(s);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator(',');
DecimalFormat format = new DecimalFormat("#,###.00", symbols);
String S =String.format("%14s\n", format.format(n));
        this.setText(S);
        }
        catch (Exception e)
        {
        this.setText("0");
        }
    }
    public void setribuan(String s) {
        try{
        double n = Double.valueOf(s);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
symbols.setGroupingSeparator(',');
DecimalFormat format = new DecimalFormat("#,###", symbols);
String S =String.format("%14s\n", format.format(n));
        this.setText(S);
        }
        catch (Exception e)
        {
        this.setText("0");
        }
    }*/
    
    /*public String getribuankomaText() {
        try{
        return this.getText().replace(",", "");
        }
        catch (Exception e)
        {
        return("0");
        }
    }*/
    
    public String getribuan() {
        try{
        return this.getText().replace(",", "");
        }
        catch (Exception e)
        {
        return("0");
        }
    }
}
