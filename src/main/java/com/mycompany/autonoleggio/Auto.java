/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autonoleggio;

import java.time.LocalDate;

/**
 *
 * @author ripristino1
 */
public class Auto 
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
    

    public Auto(int codiceUnivoco, int codiceFiscale, String cognome, String noe, String targa, String marca, String modello,int anno, int mese, int giorno)
    {
        setCodiceUnivoco(codiceUnivoco);
        setCodiceFiscale(codiceFiscale);
        setCognome(cognome);
        setNome(nome);
        setTarga(targa);
        setMarca(marca);
        setModello(modello);
        inizioNoleggio=LocalDate.of(anno, mese, giorno);
        fineNoleggio=null;
    }
    
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
    
    public int getCodiceUnivoco()
    {
        return codiceUnivoco;
    }
    
    public void setCodiceUnivoco(int codiceUnivoco)
    {
        this.codiceUnivoco=codiceUnivoco;
    }
    
    public int getCodiceFiscale()
    {
        return codiceFiscale;
    }
    
    public void setCodiceFiscale(int codiceFiscale)
    {
        this.codiceFiscale=codiceFiscale;
    }
    
    public String getCognome()
    {
        return cognome;
    }
    
    public void setCognome(String cognome)
    {
        this.cognome=cognome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome(String nome)
    {
        this.nome=nome;
    }
    
    public String getTarga()
    {
        return targa;
    }
    
    public void setTarga(String targa)
    {
        this.targa=targa;
    }
    
    public String getMarca()
    {
        return marca;
    }
    
    public void setMarca(String marca)
    {
        this.marca=marca;
    }
    
    public String getModello()
    {
        return modello;
    }
    
    public void setModello(String modello)
    {
        this.modello=modello;
    }

    public LocalDate getInizioNoleggio() 
    {
        return inizioNoleggio;
    }

    public void setInizioNoleggio(int giorno,int mese, int anno) 
    {
        this.inizioNoleggio = LocalDate.of(anno, mese, giorno);
    }

    public LocalDate getFineNoleggio() 
    {
        return fineNoleggio;
    }

    //return 1 : auto gia consegnata
    //return 0 : auto riconsegnata
    public int setFineNoleggio(int giorno,int mese, int anno) 
    {
        if(consegna==false)
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
    public String toString() 
    {
        return "Auto{" + " codiceUnivoco=" + getCodiceUnivoco() + ", codiceFiscale=" + getCodiceFiscale() + ", cognome=" + getCognome() + ", nome=" + getNome() + ", targa=" + getTarga() + ", marca=" + getMarca() + ", modello=" + getModello() + '}';
    }
    
    
}
