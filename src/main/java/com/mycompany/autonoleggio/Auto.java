/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autonoleggio;

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
    
    public Auto(int codiceUnivoco, int codiceFiscale, String cognome, String noe, String targa, String marca, String modello)
    {
        setCodiceUnivoco(codiceUnivoco);
        setCodiceFiscale(codiceFiscale);
        setCognome(cognome);
        setNome(nome);
        setTarga(targa);
        setMarca(marca);
        setModello(modello);
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
}
