using System;
using System.IO;
using System.Text;


class Program

{
    static string rutaBezeroak = "../../1Ataza/bezeroak.txt";


    static void Main()
    {
        Console.OutputEncoding = Encoding.UTF8;
        Console.WriteLine(" Enpresaren bezeroak irakurtzen \n");


        IrakurriBezeroak();


        Console.WriteLine("\nIrakurketa amaitu da. Sakatu tekla bat irteteko.");
        Console.ReadKey();
    }

    static void IrakurriBezeroak()
    {
        try
        {
            if (!File.Exists(rutaBezeroak))
            {
                Console.WriteLine($"Kontrolatutako errorea: '{rutaBezeroak}' fitxategia ez da aurkitu.");
                return;
            }


            string[] lineak = File.ReadAllLines(rutaBezeroak, Encoding.UTF8);


            if (lineak.Length == 0)
            {
                Console.WriteLine("Bezeroen fitxategia hutsa dago.");
                return;
            }


            int i = 1;
            foreach (var lerro in lineak)
            {
                string edukia = string.IsNullOrWhiteSpace(lerro) ? "(lerro hutsik)" : lerro;
                Console.WriteLine($"\nBezeroa #{i}:");
                Console.WriteLine(edukia);
                i++;
            }
        }
        catch (UnauthorizedAccessException)
        {
            Console.WriteLine("Errorea: ez duzu irakurtzeko baimenik fitxategian.");
        }
        catch (IOException ioEx)
        {
            Console.WriteLine("E/S errorea fitxategia irakurtzean: " + ioEx.Message);
        }
        catch (Exception ex)
        {
            Console.WriteLine("Ukitutako errorea bezeroak irakurtzean: " + ex.Message);
        }
    }
}