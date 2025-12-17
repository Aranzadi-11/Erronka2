using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using ZinemaApp.DatuBasea;

namespace ZinemaApp
{
    public class PelikulaRepo
    {
        public static List<Pelikula> GetAllActive()
        {
            var list = new List<Pelikula>();
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = "SELECT * FROM pelikulak WHERE ezabatuta = 0";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                using (var reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        list.Add(new Pelikula
                        {
                            Id = reader.GetInt32("id"),
                            Izenburua = reader.GetString("izenburua"),
                            EserlekuKopurua = reader.GetInt32("eserleku_kopurua"),
                            Portada = reader.GetString("portada"),
                            Deskribapena = reader.GetString("deskribapena"),
                            Ezabatuta = reader.GetInt32("ezabatuta"),
                            SorreraData = reader.GetDateTime("sorrera_data"),
                            EguneratzeAzkenData = reader.GetDateTime("eguneratze_azken_data")
                        });
                    }
                }
            }
            return list;
        }

        public static void SoftDelete(int id)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = $"UPDATE pelikulak SET ezabatuta = 1 WHERE id = {id}";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                {
                    cmd.ExecuteNonQuery();
                }
            }
        }

        public static void Restore(int id)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = $"UPDATE pelikulak SET ezabatuta = 0 WHERE id = {id}";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                {
                    cmd.ExecuteNonQuery();
                }
            }
        }

        public static void Add(Pelikula p)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = $"INSERT INTO pelikulak (izenburua, eserleku_kopurua, portada, deskribapena, ezabatuta, sorrera_data, eguneratze_azken_data) " +
                               $"VALUES ('{p.Izenburua}', {p.EserlekuKopurua}, '{p.Portada}', '{p.Deskribapena}', 0, NOW(), NOW())";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                {
                    cmd.ExecuteNonQuery();
                }
            }
        }
        public static List<Pelikula> GetAllDeleted()
        {
            var list = new List<Pelikula>();

            using (var conn = DBKonexioa.GetConnection())
            {
                string query = "SELECT * FROM pelikulak WHERE ezabatuta = 1 ORDER BY id DESC";

                using (var cmd = new MySqlCommand(query, conn))
                using (var reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        list.Add(new Pelikula
                        {
                            Id = reader.GetInt32("id"),
                            Izenburua = reader.GetString("izenburua"),
                            EserlekuKopurua = reader.GetInt32("eserleku_kopurua"),
                            Portada = reader.GetString("portada"),
                            Deskribapena = reader.GetString("deskribapena"),
                            Ezabatuta = reader.GetInt32("ezabatuta"),
                            SorreraData = reader.GetDateTime("sorrera_data"),
                            EguneratzeAzkenData = reader.GetDateTime("eguneratze_azken_data")
                        });
                    }
                }
            }

            return list;
        }

        public static void HardDelete(int id)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = "DELETE FROM pelikulak WHERE id = @id";

                using (var cmd = new MySqlCommand(query, conn))
                {
                    cmd.Parameters.AddWithValue("@id", id);
                    cmd.ExecuteNonQuery();
                }
            }
        }

        public static void Update(Pelikula p)
        {
            using (var conn = DBKonexioa.GetConnection())
            {
                string query = $"UPDATE pelikulak SET izenburua='{p.Izenburua}', eserleku_kopurua={p.EserlekuKopurua}, portada='{p.Portada}', deskribapena='{p.Deskribapena}', eguneratze_azken_data=NOW() WHERE id={p.Id}";
                FitxategiSorkuntza.Log(query);
                using (var cmd = new MySqlCommand(query, conn))
                {
                    cmd.ExecuteNonQuery();
                }
            }
        }
    }
}