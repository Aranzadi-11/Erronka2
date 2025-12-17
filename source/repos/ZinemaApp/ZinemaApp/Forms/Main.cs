using System;
using System.Drawing;
using System.Windows.Forms;
using ZinemaApp.Repoak;

namespace ZinemaApp
{
    public partial class Main : Form
    {
        public Main()
        {
            InitializeComponent();
            pelikulaPanel.Resize += (s, e) => KargatuPelikulak();
            KargatuPelikulak();
        }

        private void btnKudeaketa_Click(object sender, EventArgs e)
        {
            var kudeaketa = new AdminKudeaketa
            {
                StartPosition = FormStartPosition.CenterScreen,
                WindowState = FormWindowState.Normal,
                MinimumSize = new Size(800, 600)
            };
            kudeaketa.Show();
            Hide();
            kudeaketa.FormClosed += (s2, e2) => Show();
        }

        private void KargatuPelikulak()
        {
            pelikulaPanel.Controls.Clear();
            var pelikulak = PelikulaRepo.GetAllActive();

            foreach (var p in pelikulak)
            {
                int zabalerak = pelikulaPanel.ClientSize.Width - 60;

                var karta = new Panel
                {
                    Width = zabalerak,
                    Height = 220,
                    BackColor = Color.White,
                    Margin = new Padding(10),
                    BorderStyle = BorderStyle.FixedSingle
                };

                var irudia = new PictureBox
                {
                    ImageLocation = p.Portada,
                    SizeMode = PictureBoxSizeMode.StretchImage,
                    Width = 160,
                    Height = 200,
                    Location = new Point(10, 10)
                };

                int libre = p.EserlekuKopurua - ErreserbaRepo.GetReservedSeats(p.Id);

                var izenLabel = new Label
                {
                    Text = p.Izenburua.ToUpper(),
                    Font = new Font("Segoe UI", 16, FontStyle.Bold),
                    Location = new Point(180, 20),
                    AutoSize = true
                };

                var libreLabel = new Label
                {
                    Text = $"Libre: {libre}",
                    Font = new Font("Segoe UI", 14, FontStyle.Italic),
                    ForeColor = Color.DarkGreen,
                    Location = new Point(180, 70),
                    AutoSize = true
                };

                karta.Controls.Add(irudia);
                karta.Controls.Add(izenLabel);
                karta.Controls.Add(libreLabel);

                karta.Click += (s, e) =>
                {
                    var xehetasuna = new ErreserbaForm(p)
                    {
                        StartPosition = FormStartPosition.CenterScreen,
                        WindowState = FormWindowState.Maximized
                    };
                    xehetasuna.Show();
                    Hide();
                    xehetasuna.FormClosed += (s2, e2) => Show();
                };

                pelikulaPanel.Controls.Add(karta);
            }
        }
    }
}
