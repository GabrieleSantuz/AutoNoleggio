/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.autonoleggio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ripristino1
 */
public class Main 
{
    public static void main(String[] args) throws FileException 
    {
        AutoSalone a1= new AutoSalone();
        String[] vociMenu=new String[8];
        Scanner tastiera=new Scanner(System.in);
        int sceltaUtente=0;
        Auto auto;
        String targa;
        int giorno=0,mese=0,anno=0;
        LocalDate dataEliminaNoleggio;
    
        vociMenu[0]="Esci";
        vociMenu[1]="Registrare l’inizio di un nuovo noleggio";
        vociMenu[2]="Registrare la riconsegna di un’auto noleggiata";
        vociMenu[3]="Eliminare un noleggio in base alla data e alla targa dell’auto";
        vociMenu[4]="Visualizzare tutte le auto noleggiate da una determinata persona";
        vociMenu[5]="Visualizzare tutti i noleggi relativi ad una delle 10 automobili (inserita dall’utente) in ordine cronologico inverso (dal più recente al più vecchio)";
        vociMenu[6]="Esportare in formato CSV i dati di tutti i noleggi";
        vociMenu[7]="Salvare i dati su un file binario";
        
        a1.caricaDati();
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione e' terminata");
                    break;
                }
                case 1:
                {
                    auto=new Auto();
                    System.out.println("CodiceUnivoco-->");
                    auto.setCodiceUnivoco(tastiera.nextInt());
                    
                    System.out.println("CodiceFiscale-->");
                    auto.setCodiceFiscale(tastiera.nextInt());
                    
                    tastiera.nextLine();
                    
                    System.out.println("Cognome-->");
                    auto.setCognome(tastiera.nextLine());
                    
                    System.out.println("Nome-->");
                    auto.setNome(tastiera.nextLine());
                    
                    System.out.println("Targa-->");
                    auto.setTarga(tastiera.nextLine());
                    
                    System.out.println("Marca-->");
                    auto.setMarca(tastiera.nextLine());
                    
                    System.out.println("Modello-->");
                    auto.setModello(tastiera.nextLine());
                    
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    try
                    {
                        auto.setInizioNoleggio(giorno,mese,anno);
                    }
                    catch(DateTimeException d1)
                    {
                        System.out.println("Inserimento data di inizio errato");
                    }
                    
                    a1.nuovoNoleggio(auto);
                    
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 2:
                {      
                    System.out.println("Inserisci codice univoco dell'auto da riconsegnare-->");
                    int c1= tastiera.nextInt();
                    int risultato;
                    
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    
                    risultato=a1.riconsegnaAuto(giorno,mese,anno,c1);
                    
                    if(risultato==1)
                    {
                        System.out.println("Auto già riconsegnata");
                    }
                    else if(risultato==0)
                    {
                        System.out.println("Auto riconsgnata correttamente");
                    }
                    else
                    {
                        System.out.println("Il codice univoco inserito non è presente");
                    }
                    
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    System.out.println("Inserisci la data e la targa dell'auto da eliminare");
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    
                    tastiera.nextLine();
                    
                    System.out.println("Targa-->");
                    targa=tastiera.nextLine();
                    
                    dataEliminaNoleggio=LocalDate.of(anno,mese,giorno);
                    a1.eliminaNoleggio(dataEliminaNoleggio,targa);
                    
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 4:
                {
                    String nome,cognome;
                    System.out.println("Inserisci nome e cognome: ");
                    
                    System.out.println("Nome-->");
                    nome=tastiera.nextLine();
                    
                    System.out.println("Cognome-->");
                    cognome=tastiera.nextLine();
                    
                    a1.visualizzaAutoDiUnaPersona(nome,cognome);
                    
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 5:
                {
                    Auto[] a2;
 
                    System.out.println("Inserisci la targa dell'auto");
                    
                    System.out.println("Targa-->");
                    targa=tastiera.nextLine();
                    
                    
                    a2=a1.visualizzaNoleggiDiUnaAutoInverso(targa);
                    
                    for(int i=0;i<a2.length;i++)
                    {
                        if(a2[i]==null)
                        {
                            System.out.println("targa errata");
                            break;
                        }
                        System.out.println(a2[i]);
                    }
                    
                    tastiera.nextLine();
                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 6:
                {
                    
                    try
                    {
                        a1.esportaInCSV();
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Impossibile accedere al file, i libri non sono stati salvati");
                    }
                   

                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                case 7:
                {
                    try
                    {
                        a1.salvaDati();
                        System.out.println("salvataggio avvenuto correttamente");
                    }
                    catch(IOException e5)
                    {
                        System.out.println("impossibile accedere al file binario, le revisioni non sono state salvate");
                    }

                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    break;
                }
                
            }
                
         }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
        
        
        }while(sceltaUtente!=0);
    }
            
}
