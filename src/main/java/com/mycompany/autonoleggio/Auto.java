/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autonoleggio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * è la classe che contiene tutte le informazioni
 * su un auto noleggiata
 * @author ripristino1
 */
public class Auto implements Serializable
{
    private int codiceUnivoco;
    private int codiceFiscale;
    private String cognome;
    private String nome; 
    private String targa;
    private String marca;
    private String modello;
    private LocalDate inizioNoleggio;
    private LocalDate fineNoleggio;
    private boolean consegna=false;

    /**
     * Costruttore di default (istanzia gli oggetti)
     * @param codiceUnivoco del noleggio
     * @param codiceFiscale il codice fiscale di colui che noleggia un auto
     * @param cognome il cognome di colui che noleggia un auto
     * @param nome il nome di colui che noleggia un auto
     * @param targa la targa dell'auto noleggiata
     * @param marca la marca dell'auto noleggiata
     * @param modello il modello dell'auto noleggiaata
     * @param anno l'anno dell'inizio del noleggio
     * @param mese il mese dell'inizio del noleggio
     * @param giorno il giorno dell'inizio del noleggio
     */
    public Auto(int codiceUnivoco, int codiceFiscale, String cognome, String nome, String targa, String marca, String modello,int anno, int mese, int giorno)
    {
        setCodiceUnivoco(codiceUnivoco);
        setCodiceFiscale(codiceFiscale);
        setCognome(cognome);
        setNome(nome);
        setTarga(targa);
        setMarca(marca);
        setModello(modello);
        setInizioNoleggio(giorno,mese,anno);
        fineNoleggio=null;
    }
    
    /**
     * Costruttore di copia (istanzia oggetti)
     * @param a è un oggetto di tipo auto
     */
    public Auto (Auto a)
    {
        codiceFiscale=a.getCodiceFiscale();
        codiceUnivoco=a.getCodiceUnivoco();
        cognome=a.getCognome();
        nome=a.getNome();
        targa=a.getTarga();
        marca=a.getMarca();
        modello=a.getModello();
    }
    
    /**
     * Costruttore vuoto 
     * istanzia oggetti vuoti
     */
    public Auto()
    {
        this.codiceFiscale=0;
        this.codiceUnivoco=0;
        this.cognome=null;
        this.nome=null;
        this.targa=null;
        this.marca=null;
        this.modello=null;
        inizioNoleggio=null;
        fineNoleggio=null;
    }
    
    /**
     * Restituisce il codice univoco dell'auto
     * @return il codice univoco dell'auto
     */
    public int getCodiceUnivoco()
    {
        return codiceUnivoco;
    }
    
    /**
     * Definisce il codice univoco di un auto noleggiata
     * @param codiceUnivoco è il codice univoco dell'auto
     */
    public void setCodiceUnivoco(int codiceUnivoco)
    {
        this.codiceUnivoco=codiceUnivoco;
    }
    
    /**
     * Restituisce il codice fiscale della persona che noleggia l'auto
     * @return il codice fiscale
     */
    public int getCodiceFiscale()
    {
        return codiceFiscale;
    }
    
    /**
     * Definisce il codice fiscale della persona che vuole noleggiare un auto
     * @param codiceFiscale è il codice fiscale inserito dall'utente
     */
    public void setCodiceFiscale(int codiceFiscale)
    {
        this.codiceFiscale=codiceFiscale;
    }
    
    /**
     * Restituisce il cognome della persona che ha noleggiato un auto
     * @return il cognome della persona che ha noleggiato un auto
     */
    public String getCognome()
    {
        return cognome;
    }
    
    /**
     * Definisce il nome di colui che vuole noleggiare  un auto
     * @param cognome è il cognome inserito dall'utente
     */
    public void setCognome(String cognome)
    {
        this.cognome=cognome;
    }
    
    /**
     * Restituisce il nome della persona che ha noleggiato un auto
     * @return il nome della persona che ha noleggiato un auto 
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     * Definisce il nome di colui che vuole noleggiare  un auto
     * @param nome è il nome inserito dall'utente
     */
    public void setNome(String nome)
    {
        this.nome=nome;
    }
    
    /**
     * Restituisce la targa di un auto
     * @return la targa di un auto
     */
    public String getTarga()
    {
        return targa;
    }
    
    /**
     * Definisce la targa di un auto
     * @param targa è la targa inserita dall'utente
     */
    public void setTarga(String targa)
    {
        this.targa=targa;
    }
    
    /**
     * Restituisce la marca di un auto
     * @return la marca di un auto
     */
    public String getMarca()
    {
        return marca;
    }
    /**
     * Definisce la marca di un auto
     * @param marca è la marca inserita dall'utente
     */
    public void setMarca(String marca)
    {
        this.marca=marca;
    }
    
    /**
     * Restituisce il modello di un auto
     * @return il modello di un auto
     */
    public String getModello()
    {
        return modello;
    }
    
    /**
     * Definisce il modello di un auto
     * @param modello è il modello inserito dall'utente
     */
    public void setModello(String modello)
    {
        this.modello=modello;
    }
    
    /**
     * Restituisce la data di inizio di un noleggio di un auto
     * @return la data di inizio di un noleggio di un auto
     */
    public LocalDate getInizioNoleggio() 
    {
        return inizioNoleggio;
    }

    /**
     * Definisce la data di inizio noleggio di un auto
     * @param giorno è il giorno di inizio noleggio
     * @param mese è il mese di inizio noleggio
     * @param anno è l'anno di inizio noleggio
     */
    public void setInizioNoleggio(int giorno,int mese, int anno) 
    {
            this.inizioNoleggio = LocalDate.of(anno, mese, giorno);
        
    }
    
    /**
     * la data di inizio di un noleggio di un auto
     * @return la data di fine di un noleggio di un auto
     */
    public LocalDate getFineNoleggio() 
    {
        return fineNoleggio;
    }

    /**
     * Definisce la data di fine noleggio di un auto
     * @param giorno è il giorno di fine noleggio
     * @param mese è il mese di fine noleggio
     * @param anno è l'anno di fine noleggio
     * @return 1 : auto gia consegnata, 0 : auto riconsegnata
     */
    public int setFineNoleggio(int giorno,int mese, int anno) 
    {
        if(consegna)
        {
            return 1;
        }
        else
        {
            this.fineNoleggio = LocalDate.of(anno, mese, giorno);
            consegna=true;
            return 0;
        }
        
    }

    @Override
    public String toString() {
        return "Auto{" + "codiceUnivoco=" + codiceUnivoco + ", codiceFiscale=" + codiceFiscale + ", cognome=" + cognome + ", nome=" + nome + ", targa=" + targa + ", marca=" + marca + ", modello=" + modello + ", inizioNoleggio=" + inizioNoleggio + ", fineNoleggio=" + fineNoleggio + '}';
    }  
    
}
