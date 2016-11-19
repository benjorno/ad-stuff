package aufgabenblatt2;

import javax.swing.JOptionPane;


public class PrimzahlenSuche
{
    
    public void start()
    {
        Object[] possibilities = {"langsam", "schnell", "sieb", "vergleich", "primzahltest"};
        String eingabe = "";
        int n = 0;
        
        String s = (String)JOptionPane.showInputDialog(null, "Bitte ausw�hlen:\n",
                            "Primzahlensuche", JOptionPane.PLAIN_MESSAGE,
                            null, possibilities, "vergleich");
        
        if(s.equals(possibilities[4]))
        {
            eingabe = JOptionPane.showInputDialog(null, "Bitte Zahl eingeben!");
        }
        else
        {
            eingabe = JOptionPane.showInputDialog(null, "Bitte Obergrenze angeben!"); 
        }
            
        if(eingabe.matches("[0-9]*"))
        {
            n = Integer.parseInt(eingabe);          
            switch(s)
            {
                case "langsam":     langsamerAlgorithmus(n);
                                    break;
                case "schnell":     schnellerAlgorithmus(n);
                                    break;
                case "sieb":        sieb(n);
                                    break;
                case "vergleich":   vergleich(n);
                                    break;
                case "primzahltest": primzahltest(n);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ungltige Eingabe!",
                    "Warnung", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Primzahlen-Suchalgorithmus mit der komplexit�t (n - 2)^2
     * 
     * @param n Obere Grenze
     */
    private void langsamerAlgorithmus(int n)
    {
        if(n > 0)
        {
            boolean[] zahlen = new boolean[n];
            long counter = 0;
            long aufwand = 0;
            long tStart = 0;
            long tStop = 0;
            long tDiff = 0;
            
            tStart = System.nanoTime();
            
            for(int i = 0; i < n; i++)
            {
                zahlen[i] = true;
            }
            
            for(int i = 2; i < n; i++)
            {
                for(int j = 2; j < n; j++)
                {
                    if((i % j == 0) && (j != i))
                    {
                        zahlen[i] = false;
                    }
                    aufwand++;
                }
            }
            
            tStop = System.nanoTime();
            tDiff = (tStop - tStart) / 1000;
            
            for(int i = 2; i < n; i++)
            {
                if(zahlen[i] == true)
                {
                    System.out.print(i + " ");
                    counter++;
                }
                if(counter == 10)
                {
                    System.out.print("\n");
                    counter = 0;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Schleifendurchl�ufe: " + aufwand 
                    + "\n\nRechenzeit: " + tDiff + " us");
           
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Negative Zahlen sind nicht erlaubt!",
                    "Warnung", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Primzahlen-Suchalgorithmus mit der komplexit�t 1/2 * (n + 1)
     * 
     * @param n Obere Grenze
     */
    private void schnellerAlgorithmus(int n)
    {
        if(n > 0)
        {
            boolean[] zahlen = new boolean[n];
            long counter = 0;
            long aufwand = 0;
            long tStart = 0;
            long tStop = 0;
            long tDiff = 0;
            
            tStart = System.nanoTime();
            
            for(int i = 0; i < n; i++)
            {
                zahlen[i] = true;
            }
            
            for(int i = 2; i < n; i++)
            {
                for(int j = 2; j < i; j++)
                {
                    if((i % j == 0) && (j != i))
                    {
                        zahlen[i] = false;
                    }
                    aufwand++;
                }
            }
            
            tStop = System.nanoTime();
            tDiff = (tStop - tStart) / 1000;
            
            for(int i = 2; i < n; i++)
            {
                if(zahlen[i] == true)
                {
                    System.out.print(i + " ");
                    counter++;
                }
                if(counter == 10)
                {
                    System.out.print("\n");
                    counter = 0;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Schleifendurchl�ufe: " + aufwand 
                    + "\n\nRechenzeit: " + tDiff + " us");
           
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Negative Zahlen sind nicht erlaubt!",
                    "Warnung", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Primzahlen-Suchalgorithmus mit der komplexit�t ln(n)
     * 
     * @param n Obere Grenze
     */
    private void sieb(int n)
    {
        if(n > 0)
        {
            double wurzelN = Math.sqrt(n);
            boolean[] zahlen = new boolean[n];
            long counter = 0;
            long aufwand = 0;
            long tStart = 0;
            long tStop = 0;
            long tDiff = 0;
            
            tStart = System.nanoTime();
            
            for(int i = 0; i < n; i++)
            {
                zahlen[i] = true;
            }
            
            for(int i = 2; i < wurzelN; i++)
            {
                if(zahlen[i] == true)
                {
                    for(int j = 2; (i * j) < n; j++)
                    {
                        zahlen[i * j] = false;
                        aufwand++;
                    }
                }
            }
            
            tStop = System.nanoTime();
            tDiff = (tStop - tStart) / 1000;
            
            for(int i = 2; i < n; i++)
            {
                if(zahlen[i] == true)
                {
                    System.out.print(i + " ");
                    counter++;
                }
                if(counter == 10)
                {
                    System.out.print("\n");
                    counter = 0;
                }
            }
            
            JOptionPane.showMessageDialog(null, "Schleifendurchl�ufe: " + aufwand 
                    + "\n\nRechenzeit: " + tDiff + " us");
           
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Negative Zahlen sind nicht erlaubt!",
                    "Warnung", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void vergleich(int n)
    {
        if(n > 0)
        {
            double wurzelN = Math.sqrt(n);
            boolean[] zahlen = new boolean[n];
            
            long aufwandL = 0;
            long aufwandS = 0;
            long aufwandG = 0;
            
            long tStart = 0;
            long tStop = 0;
            
            long tDiffL = 0;
            long tDiffS = 0;
            long tDiffG = 0;
            
            tStart = System.nanoTime();
            
            for(int i = 0; i < n; i++)
            {
                zahlen[i] = true;
            }
            
            for(int i = 2; i < n; i++)
            {
                for(int j = 2; j < i; j++)
                {
                    if((i % j == 0) && (j != i))
                    {
                        zahlen[i] = false;
                    }
                    aufwandS++;
                }
            }
            
            tStop = System.nanoTime();
            tDiffS = (tStop - tStart) / 1000;
            
            tStart = System.nanoTime();
            
            for(int i = 0; i < n; i++)
            {
                zahlen[i] = true;
            }
            
            for(int i = 2; i < n; i++)
            {
                for(int j = 2; j < n; j++)
                {
                    if((i % j == 0) && (j != i))
                    {
                        zahlen[i] = false;
                    }
                    aufwandL++;
                }
            }
            
            tStop = System.nanoTime();
            tDiffL = (tStop - tStart) / 1000;
            
            tStart = System.nanoTime();
            
            for(int i = 0; i < wurzelN; i++)
            {
                zahlen[i] = true;
            }
            
            for(int i = 2; i < wurzelN; i++)
            {
                if(zahlen[i] == true)
                {
                    for(int j = 1; (i * j) < n; j++)
                    {
                        zahlen[i * j] = false;
                        aufwandG++;
                    }
                }
            }
            
            tStop = System.nanoTime();
            tDiffG = (tStop - tStart) / 1000;
            
            JOptionPane.showMessageDialog(null, "Langsamer Al.\nDurchl�ufe: " + aufwandL
                    + "  Zeit: " + tDiffL + "us" + "\n\nSchneller Al.\nDurchl�ufe: " + aufwandS
                    + "  Zeit: " + tDiffS + "us" + "\n\nSieb\nDurchl�ufe: " + aufwandG
                    + "  Zeit: " + tDiffG + "us");
           
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Negative Zahlen sind nicht erlaubt!",
                    "Warnung", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void primzahltest(int zahl)
    {
        boolean istPrimzahl = true;
        
        long tStart = 0;
        long tStop = 0;
        long tDiff = 0;
        
        long aufwand = 0;
        
        tStart = System.nanoTime();
        if(zahl > 1)
        {
            for(int i = 2; i <= zahl; i++)
            {
                if((zahl % i == 0) && (zahl != i))
                {
                    istPrimzahl = false;
                    break;
                }
                aufwand++;
            }
        }
        else
        {
            istPrimzahl = false;
        }
        tStop = System.nanoTime();
        tDiff = (tStop - tStart) / 1000;
        
        if(istPrimzahl)
        {    
            JOptionPane.showMessageDialog(null, zahl + " ist eine Primzahl!\n\n" + 
                    "Durchl�ufe: " + aufwand + "\n\n" + "Zeit: " + tDiff + " us");
        }
        else
        {
            JOptionPane.showMessageDialog(null, zahl + " ist keine Primzahl!\n\n" + 
                    "Durchl�ufe: " + aufwand + "\n\n" + "Zeit: " + tDiff + " us");
            
        }
    }
}
