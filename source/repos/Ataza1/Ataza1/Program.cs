using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System;
using System.IO;
using System.Text;


class Program
{
    static string rutaMaskotak = "maskotak.txt";


    static void Main()
    {
        Console.OutputEncoding = Encoding.UTF8;
        Console.WriteLine("=== Maskoten erregistroa ===\n");

        GordeMaskotak();

        Console.WriteLine("\nPrograma amaitu da. Sakatu tekla bat irteteko.");
        Console.ReadKey();
    }

    static void GordeMaskotak()
    {
        try
        {
            using (var idazlea = new StreamWriter(rutaMaskotak, append: true, encoding: Encoding.UTF8))
            {
                bool jarraitu = true;
                while (jarraitu)
                {
                    Console.Write("Maskotaren izena: ");
                    string izena = (Console.ReadLine() ?? "").Trim();

                    Console.Write("Arraza: ");
                    string arraza = (Console.ReadLine() ?? "").Trim();

                    Console.Write("Jabea (izena): ");
                    string jabea = (Console.ReadLine() ?? "").Trim();

                    int adina = IrakurriZenbakia("Adina (urte): ");

                    string lerroa = $"{Escapatu(izena)};{Escapatu(arraza)};{Escapatu(jabea)};{adina}";
                    idazlea.WriteLine(lerroa);

                    Console.Write("Beste maskota bat gehitu nahi duzu? (bai/ez): ");
                    string erantzuna = (Console.ReadLine() ?? "").Trim().ToLower();
                    if (erantzuna != "bai" && erantzuna != "baizik") jarraitu = false;


                    Console.WriteLine();
                }
            }


            Console.WriteLine($"Maskotak gordeta: '{rutaMaskotak}' fitxategian.");
        }
        catch (UnauthorizedAccessException)
        {
            Console.WriteLine("Errorea: ez duzu idazteko baimenik fitxategian.");
        }
        catch (Exception ex)
        {
            Console.WriteLine("Ukitutako errorea maskotak gordetzean: " + ex.Message);
        }
    }

    static int IrakurriZenbakia(string mezua)
    {
        while (true)
        {
            Console.Write(mezua);
            string s = Console.ReadLine() ?? "";
            if (int.TryParse(s, out int balioa) && balioa >= 0) return balioa;
            Console.WriteLine("Sartu zenbaki oso eta baliogarria (0 edo gehiagokoa).\n");
        }
    }

    static string Escapatu(string s)
    {
        return s.Replace(";", ","); 
    }
}