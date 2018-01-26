/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalVar;

/**
 *
 * @author richky
 */
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Terbilang {

    Map digits = new HashMap();
    Map orders = new HashMap();
    private String num = null;
    private String result = null;
    Class clazz = null;

    public Terbilang() {
        digits.put("0", "NOL");
        digits.put("1", "SATU");
        digits.put("2", "DUA");
        digits.put("3", "TIGA");
        digits.put("4", "EMPAT");
        digits.put("5", "LIMA");
        digits.put("6", "ENAM");
        digits.put("7", "TUJUH");
        digits.put("8", "DELAPAN");
        digits.put("9", "SEMBILAN");
        orders.put("0", "");
        orders.put("1", "PULUH");
        orders.put("2", "RATUS");
        orders.put("3", "RIBU");
        orders.put("6", "JUTA");
        orders.put("9", "MILIAR");
        orders.put("12", "TRILIUN");
        orders.put("15", "KUADRILIUN");
    }

    /**
     *
     * @param num of Object classes Integer, Long, Double, Float and String
     */
    public Terbilang(Object num) {
        this();
        this.num = convertNumToString(num);
    }

    private void init() {
        boolean is_neg = false;
        if (clazz.equals(Double.class) || clazz.equals(Float.class)) {
            Double chk = Double.parseDouble(num);
            is_neg = chk < 0;
        } else {
            is_neg = num.startsWith("-") ? true : false;
        }
        String ints = "";
        try {
            Pattern regex = Pattern.compile("^[+-]?(\\d+)");
            Matcher regexMatcher = regex.matcher(num);
            if (regexMatcher.find()) {
                ints = regexMatcher.group(1);
            }
        } catch (PatternSyntaxException ex) {
        }
        int mult = 0;
        String wint = "";
        while (!ints.isEmpty()) {
            try {
                Pattern regex = Pattern.compile("(\\d{1,3})$");
                Matcher regexMatcher = regex.matcher(ints);
                while (regexMatcher.find()) {
                    // ambil satuan, puluhan, dan ratusan
                    int m = Integer.parseInt(regexMatcher.group());
                    int s = (m % 10);
                    int p = ((m % 100 - s) / 10);
                    int r = ((m - p * 10 - s) / 100);
                    // konversi ratusan
                    String g = "";
                    if (r == 0) {
                        g = "";
                    } else if (r == 1) {
                        g = "SE" + orders.get("2");
                    } else {
                        g = digits.get("" + r + "") + " " + orders.get("2");
                    }

                    // konversi puluhan dan satuan
                    if (p == 0) {
                        if (s == 0) {
                        } else if (s == 1) {
                            g = (!g.isEmpty() ? (g + " " + digits.get("" + s + "").toString()) : (mult == 0 ? digits.get("1").toString() : "SE"));
                        } else {
                            g = (!g.isEmpty() ? g + " " : "") + digits.get("" + s + "").toString();
                        }
                    } else if (p == 1) {
                        if (s == 0) {
                            g = (!g.isEmpty() ? g + " " : "") + "SE" + orders.get("1");
                        } else if (s == 1) {
                            g = (!g.isEmpty() ? g + " " : "") + "SEBELAS";
                        } else {
                            g = (!g.isEmpty() ? g + " " : "") + digits.get("" + s + "") + " BELAS";
                        }
                    } else {
                        g = (!g.isEmpty() ? g + " " : "") + digits.get("" + p + "") + " PULUH" + (s > 0 ? " " + digits.get("" + s + "") : "");
                    }

                    // gabungkan dengan hasil sebelumnya
                    wint = (!g.isEmpty() ? (g + (g.equals("SE") ? "" : " ") + orders.get("" + mult + "")) : "") + (!wint.isEmpty() ? " " + wint : "");

                    // pangkas ribuan/jutaan/dsb yang sudah dikonversi
                    String resultString = "";
                    try {
                        Pattern tsRegex = Pattern.compile("\\d{1,3}$");
                        Matcher regexMatchers = tsRegex.matcher(ints);
                        try {
                            resultString = regexMatchers.replaceAll("");
                            ints = resultString;
                        } catch (IllegalArgumentException ex1) {
                        } catch (IndexOutOfBoundsException ex2) {
                        }
                    } catch (PatternSyntaxException ex3) {
                    }
                    mult += 3;
                }
            } catch (PatternSyntaxException ex) {
            }
        }
        if (wint.isEmpty()) {
            wint = digits.get("0").toString();
        }
        //// angka di kanan desimal
        String frac = "";
        try {
            Pattern regexf = Pattern.compile("\\.(\\d+)");
            Matcher regexMatcherf = regexf.matcher(num);
            if (regexMatcherf.find()) {
                frac = regexMatcherf.group();
            }
        } catch (PatternSyntaxException ex) {
        }
        String wfrac = "";
        for (int i = 0; i < frac.length(); i++) {
            String indexf = frac.substring(i, i + 1);
            if (digits.containsKey(indexf)) {
                wfrac += (!wfrac.isEmpty() ? " " : "") + digits.get(indexf);
            }
        }
        result = ((is_neg ? "MINUS " : "") + wint + ((!wfrac.isEmpty()) ? " KOMA " + wfrac : ""));
        result = result.replaceAll("\\s{2,}", " ");
        result = result.replaceAll("(null )|(\\s{1,}$)", "");
    }

    /**
     * @return the num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(Object num) {
        this.num = this.convertNumToString(num);
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        init();
        return getResult() + " RUPIAH";
    }

    private String convertNumToString(Object value) {
        if (null == clazz) {
            clazz = value.getClass();
        }
        String reval = null;
        if (Character.class.equals(clazz) || char.class.equals(clazz) || Double.class.equals(clazz) || Float.class.equals(clazz) || Integer.class.equals(clazz) || Long.class.equals(clazz) || Short.class.equals(clazz)) {
            reval = value.toString();
        } else {
            reval = value.toString();
            //throw new NumberFormatException("Your Input has failed! Numeric or decimal only can be process");
        }
        return (reval);
    }

    public static void main(String[] args) {
        double b = 123456789123.99;
        System.out.println(b);
        System.out.println(new Terbilang(b));
    }

}
