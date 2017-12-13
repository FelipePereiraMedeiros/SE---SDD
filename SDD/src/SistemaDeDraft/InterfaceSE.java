/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeDraft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gaspe
 */
public class InterfaceSE {

    private int resposta = -1;
    private String respostaS = "";
    private int[] respostasF = new int[2];
    private boolean firstBan = false;
    private Heroi aux;
    private Motor_De_Inferencia motor;

    public void Interface() throws IOException {
        int i = 0;
        Scanner scr = new Scanner(System.in);
        while (resposta != 1 & resposta != 2) {
            System.out.println("Quem começa banindo?\n1-Time Azul\n2-Time Vermelho\n");
            resposta = scr.nextInt();
            if (resposta == 1) {
                firstBan = true;
            }
        }
        resposta = -1;
        while (resposta != 1 &resposta != 2) {
            System.out.println("Qual Mapa esta selecionado?\n1-Baia do Coracao Negro\n2-Condado do Dragao\n");
            resposta = scr.nextInt();
            respostasF[i] = resposta;
        }
        i++;
        resposta = -1;
        while (resposta != 1) {
            System.out.println("Qual a composição que deseja montar?\n1-Hard Engage\n");
            resposta = scr.nextInt();
            respostasF[i] = resposta;
        }
        switch (respostasF[1]) {
                case 1:
                    motor = new Motor_De_Inferencia("Baia Do Coração Negro", "C:\\Users\\Gaspe\\Documents\\NetBeansProjects\\SDD\\src\\SistemaDeDraft\\HeroisTest.csv",1);
                    break;
                case 2:
                    motor = new Motor_De_Inferencia("Condado do Dragão", "C:\\Users\\Gaspe\\Documents\\NetBeansProjects\\SDD\\src\\SistemaDeDraft\\HeroisTest.csv", 2 );
                    break;
                default:
                    break;
        }
        

        if (firstBan) {
            int j = 0;
            while (j < 14) {
                if (j == 0 || j == 8) {
                    aux = motor.indicarBan(j, firstBan);
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("-> Recomendamos que o heroi: " + aux.getNome() + " seja banido");
                    System.out.println("-----------------------------------------------------------");
                    j++;
                }
                if (j == 1 || j == 7) {
                    System.out.println("Qual heroi a equipe adversaria baniu?");
                    respostaS = scr.next();
                    if ((aux = motor.GetHeroiHerois(respostaS)) != null) {
                    System.out.println("-----------------------------------------------------------");
                        System.out.println("-> Equipe adversaria baniu " + aux.getNome());
                    System.out.println("-----------------------------------------------------------");
                        j++;
                    }
                }
                if (j == 2 || j == 5 || j == 6 || j == 11 | j == 12) {
                    aux = motor.indicarHeroi();
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("-> Recomendamos que o heroi: " + aux.getNome() + " seja selecionado");
                    System.out.println("-----------------------------------------------------------");
                    j++;
                }
                if (j == 3 || j == 4 || j == 9 || j == 10 || j == 13) {
                    System.out.println("Qual heroi a equipe adversaria selecionou?");
                    respostaS = scr.next();
                    if ((aux = motor.GetHeroiHerois(respostaS)) != null) {
                    System.out.println("-----------------------------------------------------------");
                        System.out.println("-> Equipe adversaria selecionou " + aux.getNome());
                    System.out.println("-----------------------------------------------------------");
                        j++;
                    }
                }
            }
        } else {
            int j = 0;
            while (j < 14) {
                if (j == 0 || j == 8) {
                    System.out.println("Qual heroi a equipe adversaria baniu?");
                    respostaS = scr.next();
                    if ((aux = motor.GetHeroiHerois(respostaS)) != null) {
                    System.out.println("-----------------------------------------------------------");
                        System.out.println("-> Equipe adversaria baniu " + aux.getNome());
                    System.out.println("-----------------------------------------------------------");
                        j++;
                    }
                }
                if (j == 1 || j == 7) {

                    aux = motor.indicarBan(j, firstBan);
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("-> Recomendamos que o heroi: " + aux.getNome() + " seja banido");
                    System.out.println("-----------------------------------------------------------");
                    j++;
                }

                if (j == 2 || j == 5 || j == 6 || j == 11 | j == 12) {
                    System.out.println("Qual heroi a equipe adversaria selecionou?");
                    respostaS = scr.next();
                    if ((aux = motor.GetHeroiHerois(respostaS)) != null) {
                    System.out.println("-----------------------------------------------------------");
                        System.out.println("-> Equipe adversaria selecionou " + aux.getNome());
                    System.out.println("-----------------------------------------------------------");
                        j++;
                    }
                }
                if (j == 3 || j == 4 || j == 9 || j == 10 || j == 13) {
                    aux = motor.indicarHeroi();
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("-> Recomendamos que o heroi: " + aux.getNome() + " seja selecionado");
                    System.out.println("-----------------------------------------------------------");
                    j++;
                }
            }
        }
        ArrayList<Heroi> PV = motor.getPV();
        int scoreV = 0;
        for(Heroi h : PV){
            scoreV+= PV.get(i).getPeso();
        }
        ArrayList<Heroi> PA = motor.getPA();
        int scoreA = 0;
        for(Heroi h : PA){
            scoreA+= PA.get(i).getPeso();
        }
        System.out.println("Score da composicao final: " + scoreA);
                
    }
}
