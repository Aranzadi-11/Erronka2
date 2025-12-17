using MySql.Data.MySqlClient;
using System;

namespace ZinemaApp
{
    public class DBKonexioa
    {
        private static string connectionString = "Server=localhost;Database=Zinema;Uid=root;Pwd=abc123ABC;";
        public static MySqlConnection GetConnection()
        {
            var conn = new MySqlConnection(connectionString);
            conn.Open();
            return conn;
        }
    }
}
