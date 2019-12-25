package com.phicel.conversion_cf;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean rep = true;
        //Scanner scan1 = new Scanner(System.in);
        int typeConversion;
        char reponse;
        double lectureC, lectureF, resultatC, resultatF;

        while (rep) {
            System.out.println("CONVERTISSEUR DEGRES CELSIUS ET DEGRES FARHENHEIT");
            System.out.println("-------------------------------------------------");
            System.out.println("Choisissez le mode de conversion :");
            System.out.println("1 - Convertisseur Celsius - Fahrenheit");
            System.out.println("2 - Convertisseur Fahrenheit - Celsius");

            typeConversion = entreeChoix(1, 2);

            System.out.println("Temperature à convertir : ");
            Scanner scan2 = new Scanner(System.in);
            switch (typeConversion) {
                case 1 : {
                    System.out.println("choix 1 : C° -> F");
                    lectureC = scan2.nextInt();
                    resultatF = (1.8 * lectureC) + 32; // méthode conversion
                    System.out.println("resultatF = " + resultatF);
                    System.out.println("Souhaitez-vous convertir une autre température ? (O/N)");

                    reponse = entreeReponse('O', 'N');
                    if (reponse == 'N') {
                        rep = false;
                        break;
                    }

                    System.out.println("OK on continue !");

                    break;
                }
                case 2 : {
                    System.out.println("choix 2 : F -> C°");
                    lectureF = scan2.nextInt();
                    resultatC = ((lectureF - 32) * 5) / 9 ;
                    resultatC = (double)Math.round(resultatC * 100) / 100;
                    System.out.println("resultatC = " + resultatC);
                    System.out.println("Souhaitez-vous convertir une autre température ? (O/N)");

                    reponse = entreeReponse('O', 'N');
                    if (reponse == 'N') {
                        rep = false;
                        break;
                    }

                    System.out.println("OK on continue !");
                    rep = true;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + typeConversion); // par defaut
            }

        }

        System.out.println("Au revoir !");
    }

    private static char entreeReponse(char o,char n) {
        char reponse;
        Scanner scan3 = new Scanner(System.in);
        do {
            reponse = ' ';
            try {
                reponse = scan3.nextLine().charAt(0);
                }

            catch (InputMismatchException e) {
                scan3.next();
                }

            if ((reponse != 'O') || (reponse != 'N')) {
                break;
            }

            System.out.println("Recommencez svp");
        } while ((reponse != 'O') || (reponse != 'N'));

        return reponse;
    }

    public static int entreeChoix(int min, int max) { //  Celsius ou Far
        int choix;
        Scanner scan1 = new Scanner(System.in);
        do {
            choix = 0;
            try {
                choix = scan1.nextInt();
            }

            catch (InputMismatchException e) {
                scan1.next();
            }

            if ((choix < min) || (choix > max)) {
                System.out.println("Recommencez svp");
            }

        } while ((choix < min) || (choix > max));
        return choix;
    }


}
