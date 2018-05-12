/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

/**
 *
 * @author richk
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 10;
        boolean c = true;
        for (int i = a; i <= b; i++) {
            if (i != 1) {
                c = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        c = false;
                    }
                }
                if (c) {
                    System.out.println(i);
                }
            }
        }
    }

}
