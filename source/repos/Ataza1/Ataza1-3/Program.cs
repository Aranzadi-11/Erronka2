using System;
using System.IO;

class Program
{
    static void GehituErreserba(string izena, int pertsonaKop, string data)
    {
        using (StreamWriter fitxategia = new StreamWriter("zerrenda.txt", true))
        {
            fitxategia.WriteLine(izena + ", " + pertsonaKop + ", " + data);
        }
    }

    static void Main(string[] args)
    {
        try
        {
            Console.Write("Sartu izena: ");
            string izena = Console.ReadLine();

            Console.Write("Sartu pertsona kopurua: ");
            int pertsonaKop = int.Parse(Console.ReadLine());

            Console.Write("Sartu data (adib: 2025-10-01): ");
            string data = Console.ReadLine();

            GehituErreserba(izena, pertsonaKop, data);

            Console.WriteLine(" " +  "Erreserba ondo gehitu da!");
        }
        catch (Exception e)
        {
            Console.WriteLine("Errorea gertatu da: " + e.Message);
        }
    }
}
