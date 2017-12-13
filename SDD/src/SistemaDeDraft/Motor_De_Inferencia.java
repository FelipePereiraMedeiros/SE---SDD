/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeDraft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Gaspe
 */
public class Motor_De_Inferencia extends Mapa {

    private final ArrayList<String> TipoHE;

    /*private final ArrayList<String> TipoSP;    
    private final ArrayList<String> TipoPO;    
    private final ArrayList<String> TipoSF;
     */

    public Motor_De_Inferencia(String nome, String fileHerois,int id) throws IOException {
        super(nome, fileHerois,id);
        String[] TipoHE = new String[]{"Tank Dedicado", "Healer Dedicado", "Dano Primario", "Utilidade", "Finisher"};
        String[] TipoSP = new String[]{"Tank Dedicado", "Healer Dedicado", "Dano Primario", "Bruiser", "Split-Push"};
        String[] TipoPO = new String[]{"Tank Dedicado", "Healer Dedicado", "Dano Primario", "Bruiser", "Dano-Primario"};
        String[] TipoSF = new String[]{"Tank Dedicado", "Healer Dedicado", "Dano Primario", "Bruiser", "Utilidade"};
        this.TipoHE = new ArrayList<String>(Arrays.asList(TipoHE));
        /*this.TipoSP = Arrays.asList(TipoSP);
        this.TipoPO = Arrays.asList(TipoPO);
        this.TipoSF = Arrays.asList(TipoSF);
         */
    }

    public Heroi indicarHeroi() {
        
        boolean contains = false;
        int indexHero = -1;
        int indexFunc = -1;
        
        for (int i = 0; i < TipoHE.size(); i++) {
            if (this.getIndexByFunction(TipoHE.get(i), "Prior") != -1) {
                contains = true;
                indexHero = this.getIndexByFunction(TipoHE.get(i), "Prior");
                indexFunc = i;
            }
        }
        
        Heroi aux = this.GetHeroiPrior(indexHero);
        if (aux != null) {
            TipoHE.remove(indexFunc);
            return aux;
        } else {
            for (int i = 0; i < TipoHE.size(); i++) {
                if (this.getIndexByFunction(TipoHE.get(i), "Comp") != -1) {
                    contains = true;
                    indexHero = this.getIndexByFunction(TipoHE.get(i), "Comp");
                    indexFunc = i;
                }

            }
            aux = this.GetHeroiComp(indexHero);
            if (aux != null) {
                TipoHE.remove(indexFunc);
                return aux;
            } else {
                for (int i = 0; i < TipoHE.size(); i++) {
                    if (this.getIndexByFunction(TipoHE.get(i), "Herois") != -1) {
                        contains = true;
                        indexHero = this.getIndexByFunction(TipoHE.get(i), "Herois");
                        indexFunc = i;
                    }
                }
                if (aux != null) {
                    TipoHE.remove(indexFunc);
                    return aux;
                } else {
                    return null;
                }
            }
        }
    }

    public Heroi indicarBan(int state, boolean firstBan) {
        boolean contains = false;

        if (state == 0 && firstBan) {
            for (int i = 0; i < 5; i++) {
                if (this.getIndexByFunction(TipoHE.get(i), "Prior") != -1) {
                    contains = true;
                }
            }
            if (contains == true) {
                Heroi aux = this.GetHeroiPrior(1);
                if (aux != null) {
                    return aux;
                } else {
                    aux = this.GetHeroiComp(0);
                    if (aux != null) {
                        return aux;
                    } else {
                        aux = this.GetHeroiHerois(0);
                        if (aux != null) {
                            return aux;
                        } else {
                            return null;
                        }
                    }
                }
            } else {
                Heroi aux = this.GetHeroiPrior(0);
                if (aux != null) {
                    return aux;
                } else {
                    aux = this.GetHeroiComp(0);
                    if (aux != null) {
                        return aux;
                    } else {
                        aux = this.GetHeroiHerois(0);
                        if (aux != null) {
                            return aux;
                        } else {
                            return null;
                        }
                    }
                }
            }
        } else if ((state == 0 && !firstBan) || state == 1) {
            Heroi aux = this.GetHeroiPrior(0);
            if (aux != null) {
                return aux;
            } else {
                aux = this.GetHeroiComp(0);
                if (aux != null) {
                    return aux;
                } else {
                    aux = this.GetHeroiHerois(0);
                    if (aux != null) {
                        return aux;
                    } else {
                        return null;
                    }
                }
            }
        }

        if (state == 8);

        Heroi aux = this.GetHeroiPrior(0);
        if (aux != null) {
            return aux;
        }
        return null;
    }

    public boolean banHeroi(String heroName) {

        return false;
    }

    public boolean pickHeroi(String heroName) {
        return false;
    }
}
