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
public class AutoSalone 
{
    private int contaAutoAggiunte=0;
    private Auto[] auto;
    private final int MAX_NUM_AUTO=10;
    
    
    public AutoSalone()
    {
        auto=new Auto[MAX_NUM_AUTO];
    }
    
    //return 1 : numero massimo di auto raggiunto
    //return 0 : auto aggiunta correttamente
    public int nuovoNoleggio(Auto a1)
    {
        if(contaAutoAggiunte==9)
        {
            return 1;
        }
        
        else
        {
            auto[contaAutoAggiunte]=a1;
            contaAutoAggiunte++;
            return 0;
        }
    }
    
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
    
    public void eliminaNoleggio()
    {
        
    }
    
    public void visualizzaAutoDiUnaPersona()
    {
        
    }
    
    public void visualizzaNoleggiDiUnaAutoInverso()
    {
        
    }
    
    public void esportaInCSV()
    {
        
    }
    
    public void salvaDati()
    {
        
    }

    public int getContaAutoAggiunte() 
    {
        return contaAutoAggiunte;
    }
    
}
