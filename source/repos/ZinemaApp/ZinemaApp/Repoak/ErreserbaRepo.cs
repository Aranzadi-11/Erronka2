using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ZinemaApp.DatuBasea;

namespace ZinemaApp.Repoak
{
    public class ErreserbaRepo
    {
        public static int GetReservedSeats(int peliculaId)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = $"SELECT IFNULL(SUM(eserleku_kopurua),0) FROM erreserbak WHERE pelikula_id = {peliculaId}";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                {
                    return Convert.ToInt32(cmd.ExecuteScalar());
                }
            }
        }

        public static void Add(Erreserba e)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = $"INSERT INTO erreserbak (pelikula_id, izena, abizena, telefonoa, email, eserleku_kopurua, erreserba_eguna) " +
                               $"VALUES ({e.PeliculaId}, '{e.Izena}', '{e.Abizena}', '{e.Telefonoa}', '{e.Email}', {e.EserlekuKopurua}, NOW())";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                {
                    cmd.ExecuteNonQuery();
                }
            }
        }
    }
}
