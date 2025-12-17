using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ZinemaApp.DatuBasea
{    
    public static class FitxategiSorkuntza
    {
        private static string filePath = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.Desktop), "DB-Kontsultak.txt");
        public static void Log(string query)
        {
            File.AppendAllText(filePath, $"[{DateTime.Now}] {query}{Environment.NewLine}");
        }
    }  
}
