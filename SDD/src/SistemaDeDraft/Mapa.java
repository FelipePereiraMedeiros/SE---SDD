/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaDeDraft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaspe
 */
public class Mapa {

    private String nome;

    /*Herois Disponiveis*/
    private ArrayList<Heroi> herois = null;

    /*Composição Hard Engage*/
    private ArrayList<Heroi> comp = null;

    /*Picks Vermelho*/
    private ArrayList<Heroi> PV = null;

    /*Picks Azul*/
    private ArrayList<Heroi> PA = null;

    /*Prioritários*/
    private ArrayList<Heroi> prioritarios = null;

    private int id = -1;

    public Mapa(String nome, String fileHerois, int id) throws IOException {
        this.nome = nome;
        this.id = id;
        inicializarHerois(fileHerois);
    }

    public ArrayList<Heroi> getPV() {
        return PV;
    }

    public ArrayList<Heroi> getPA() {
        return PA;
    }

    public void inicializarHerois(String fileHerois) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        String line = "";
        String csvSplitby = ";";
        int i = 0;
        Heroi tempHero = null;
        this.herois = new ArrayList<Heroi>();
        this.comp = new ArrayList<Heroi>();
        this.prioritarios = new ArrayList<Heroi>();

        try {
            br = new BufferedReader(new FileReader(fileHerois));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] h = line.split(csvSplitby);
                tempHero = new Heroi(Integer.parseInt(h[0]), h[1], h[2], h[3], h[4], Integer.parseInt(h[4 + this.id]));
                this.herois.add(tempHero);
                i++;
            }
            for (Heroi h : this.herois) {
                if (h.getPeso() == 10) {
                    this.prioritarios.add(h);
                }
            }
            for (Heroi h : this.herois) {
                if (h.getPeso() > 0) {
                    this.comp.add(h);
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

    }

    public int getIndexByName(String heroName, String vetor) {
        switch (vetor) {
            case "Comp":
                for (int i = 0; i < comp.size(); i++) {
                    if (comp.get(i) != null && comp.get(i).getNome().equals(heroName)) {
                        return i;
                    }
                }
                return -1;
            case "Herois":
                for (int i = 0; i < herois.size(); i++) {
                    if (herois.get(i) != null && herois.get(i).getNome().equals(heroName)) {
                        return i;
                    }
                }
                return -1;
            case "Prior":
                for (int i = 0; i < prioritarios.size(); i++) {
                    if (prioritarios.get(i) != null && prioritarios.get(i).getNome().equals(heroName)) {
                        return i;
                    }
                }
                return -1;
            default:
                return -1;
        }
    }

    public int getIndexByFunction(String heroFunction, String vetor) {
        switch (vetor) {
            case "Comp":
                for (int i = 0; i < comp.size(); i++) {
                    if (comp.get(i) != null && comp.get(i).getFuncao().equals(heroFunction)) {
                        return i;
                    }
                }
                return -1;
            case "Herois":
                for (int i = 0; i < herois.size(); i++) {
                    if (herois.get(i) != null && herois.get(i).getFuncao().equals(heroFunction)) {
                        return i;
                    }
                }
                return -1;
            case "Prior":
                for (int i = 0; i < prioritarios.size(); i++) {
                    if (prioritarios.get(i) != null && prioritarios.get(i).getFuncao().equals(heroFunction)) {
                        return i;
                    }
                }
                return -1;
            default:
                return -1;
        }
    }

    public void AddHeroiPV(Heroi hero) {
        PV.add(hero);
    }

    public void AddHeroiPA(Heroi hero) {
        PA.add(hero);
    }

    public Heroi GetHeroiComp(String heroName) {
        Heroi result;
        if (getIndexByName(heroName, "Comp") == -1) {
            return null;
        } else {
            result = comp.get(getIndexByName(heroName, "Comp"));
            if (getIndexByName(heroName, "Herois") > 0) {
                herois.remove(getIndexByName(heroName, "Herois"));
            }
            if (getIndexByName(heroName, "Prior") > 0) {
                prioritarios.remove(getIndexByName(heroName, "Prior"));
            }
            comp.remove(herois.get(getIndexByName(heroName, "Comp")));
            return result;
        }
    }

    public Heroi GetHeroiPrior(String heroName) {
        Heroi result;
        if (getIndexByName(heroName, "Prior") == -1) {
            return null;
        } else {
            result = prioritarios.get(getIndexByName(heroName, "Prior"));
            if (getIndexByName(heroName, "Herois") > 0) {
                herois.remove(getIndexByName(heroName, "Herois"));
            }
            if (getIndexByName(heroName, "Comp") > 0) {
                comp.remove(getIndexByName(heroName, "Comp"));
            }
            prioritarios.remove(herois.get(getIndexByName(heroName, "Herois")));
            return result;
        }
    }

    public Heroi GetHeroiHerois(String heroName) {
        Heroi result;
        if (getIndexByName(heroName, "Herois") == -1) {
            return null;
        } else {
            result = herois.get(getIndexByName(heroName, "Herois"));
            if (getIndexByName(heroName, "Prior") > 0) {
                prioritarios.remove(getIndexByName(heroName, "Prior"));
            }
            if (getIndexByName(heroName, "Comp") > 0) {
                comp.remove(getIndexByName(heroName, "Comp"));
            }
            herois.remove(herois.get(getIndexByName(heroName, "Herois")));
            return result;
        }
    }

    public Heroi GetHeroiComp(int indice) {
        if (indice >= comp.size() || indice < 0) {
            return null;
        } else {
            Heroi hero = comp.get(indice);
            herois.remove(this.getIndexByName(hero.getNome(), "Herois"));
            if (this.getIndexByName(hero.getNome(), "Prior") > 0) {
                prioritarios.remove(this.getIndexByName(hero.getNome(), "Prior"));
            }
            comp.remove(comp.get(indice));
            return hero;
        }
    }

    public Heroi GetHeroiPrior(int indice) {
        if (indice >= prioritarios.size() || indice < 0) {
            return null;
        } else {
            Heroi hero = prioritarios.get(indice);
            if (this.getIndexByName(hero.getNome(), "Herois") >= 0) {
                herois.remove(this.getIndexByName(hero.getNome(), "Herois"));
            }
            if (this.getIndexByName(hero.getNome(), "Comp") >= 0) {
                comp.remove(this.getIndexByName(hero.getNome(), "Comp"));
            }
            prioritarios.remove(prioritarios.get(indice));
            return hero;
        }
    }

    public Heroi GetHeroiHerois(int indice) {
        if (indice >= herois.size() || indice < 0) {
            return null;
        } else {
            Heroi hero = herois.get(indice);
            if (this.getIndexByName(hero.getNome(), "Prior") >= 0);
            prioritarios.remove(this.getIndexByName(hero.getNome(), "Prior"));
            if (this.getIndexByName(hero.getNome(), "Comp") >= 0) {
                comp.remove(this.getIndexByName(hero.getNome(), "Comp"));
            }
            herois.remove(herois.get(indice));
            return hero;
        }
    }

}
