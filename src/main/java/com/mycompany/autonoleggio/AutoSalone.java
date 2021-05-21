/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autonoleggio;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;



/**
 * è la classe che contiene l'array di tipo auto
 * contiene i metodi necessari per gestire un noleggio
 * @author ripristino1
 */
public class AutoSalone implements Serializable
{
    private int contaAutoAggiunte=0;
    private Auto[] auto;
    private final int MAX_NUM_AUTO=100;
    
    /**
     * Costruttore di default(istanzia un array di tipo auto)
     */
    public AutoSalone()
    {
        auto=new Auto[MAX_NUM_AUTO];
    }
    
    //return 1 : numero massimo di auto raggiunto
    //return 0 : auto aggiunta correttamente
    
    /**
     * Aggiunge un ogetto istanziato di tipo auto all'array
     * @param a1 a1 è l'oggetto istanziato che sarà aggiunto all'array
     */
    public void nuovoNoleggio(Auto a1)
    {
            auto[contaAutoAggiunte]=a1;
            contaAutoAggiunte++;
    }
    
    /**
     * è il metodo che permettono di riconsegnare un auto 
     * @param giorno è il giorno di riconsegna dell'auto
     * @param mese è il mese di riconsegna dell'auto
     * @param anno è l'anno di riconsegna dell'auto
     * @param c1 è il codice che permette di definire quale auto va riconsegnata
     * @return 
     */
    public int riconsegnaAuto(int giorno, int mese, int anno, int c1)
    {
        int risultato;
        
        for(int i=0;i<contaAutoAggiunte;i++)
            {
                if(auto[i].getCodiceUnivoco()==c1)
                {
                    risultato=auto[i].setFineNoleggio(giorno,mese,anno);
                    
                    if(risultato==1)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                        
                }
                        
            }
        return 2;
         
    }
    
    /**
     * Elimina il noleggio di un auto
     * @param data è la data del noleggio da eliminare
     * @param targa è la targa dell'auto noleggiata da eliminare
     */
    public void eliminaNoleggio(LocalDate data,String targa)
    {
        int c=0;
        
        for(int i=0;i<contaAutoAggiunte;i++)
        {
            if(auto[i].getInizioNoleggio().isEqual(data)==true && auto[i].getTarga().compareToIgnoreCase(targa)==0 )
            {
                auto[i]=null;
                aggiornaPosizione(i);
                c++;
            }
        }
        
        if(c==0)
        {
            System.out.println("Rimozione non effettuata");
        }
        
        else
        {
            System.out.println("Rimozione effettuata correttamene");
        }
    }
    /**
     * aggiorna la posizione dei noleggi effettuati nell'array
     * @param posizione la posizione serve per modificare l'ordine dei noleggi
     */
    private void aggiornaPosizione(int posizione)
    {
        for (int i=posizione;i<contaAutoAggiunte-1;i++)
        {
            auto[i]=auto[i+1];
        }
        auto[contaAutoAggiunte-1]=null;      //se ne elimini uno, sicuramente l'ultimo deve contenere null ( lo faccio per togliere dall'array la revisione eliminata)
        contaAutoAggiunte--;
    }
    
    /**
     * Visualizza i noleggi effettuati da una persona
     * @param nome è il nome della persona di cui si vuole visualizzare i noleggi effettuati
     * @param cognome è il cognome della persona di cui si vuole visualizzare i noleggi effettuati
     */
    public void visualizzaAutoDiUnaPersona(String nome,String cognome)
    {
        System.out.println("Auto noleggiate: ");
        for (int i=0;i<contaAutoAggiunte;i++)
        {
            if(auto[i].getNome().compareToIgnoreCase(nome)==0 && auto[i].getCognome().compareToIgnoreCase(cognome)==0)
            {
                System.out.println("targa: "+auto[i].getTarga()+" , "+"modello: "+auto[i].getModello()+" , "+"marca: "+auto[i].getMarca()+";");
            }
        }
    }
    
    /**
     * Visualizza tutti i noleggi relativi ad un' auto
     * @param targa serve per identificare l'auto
     * @return Restituisce un array ordinato
     */
    public Auto[] visualizzaNoleggiDiUnaAutoInverso(String targa)
    {
        Auto[] arrayDecrescente=new Auto[getContaAutoAggiunte()];
        Auto auto;
        int x=0;
        
        for (int i=0;i<contaAutoAggiunte;i++)
        {
            if(this.auto[i].getTarga().compareToIgnoreCase(targa)==0)
            {
                auto=this.auto[i];
                arrayDecrescente[x]=auto;
                x++;
            }
        }
        arrayDecrescente=Ordinatore.selectionSortDecrescente(arrayDecrescente);
        return arrayDecrescente;
    }
    
    /**
     * Esporta in file di testo, in formato csv, tutti i noleggi effettuati
     * @throws IOException
     * @throws FileException 
     */
    public void esportaInCSV()throws IOException,FileException
    {
        TextFile f1=new TextFile("Salvataggio.txt",'W',true);

        for(int i=0;i<getContaAutoAggiunte();i++)
        {
            if(auto[i]!=null)
            {
                f1.toFile(auto[i].getCodiceUnivoco()+";"+auto[i].getCodiceFiscale()+";"+auto[i].getCognome()+";"+auto[i].getNome()+";"+auto[i].getMarca()+";"+auto[i].getModello()+";"+auto[i].getInizioNoleggio()+";"+auto[i].getFineNoleggio()+";\n");
            }
        } 
        f1.close();
    }
    
    /**
     * Salva i dati su un file binario
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void salvaDati() throws FileNotFoundException, IOException
    {
       
        FileOutputStream f1=new FileOutputStream("Bin/ Auto.bin");
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();          
                
    }
    
    /**
     * Carica i dati nel progetto
     */
    public void caricaDati()
    {
        try
        {
            FileInputStream f1=new FileInputStream("Bin/ Auto.bin");
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {  
                auto=(Auto[])reader.readObject();
                reader.close();
                System.out.println("Lettura da file avvevuta correttamente");

            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
    }
    
    /**
     * Restituisce il numero di noleggi agiunti all'array
     * @return 
     */
    public int getContaAutoAggiunte() 
    {
        return contaAutoAggiunte;
    }
    
}
