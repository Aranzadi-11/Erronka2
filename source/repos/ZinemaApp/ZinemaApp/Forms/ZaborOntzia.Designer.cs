using System;
using System.Drawing;
using System.Windows.Forms;
using ZinemaApp.Repoak;

namespace ZinemaApp
{
    public partial class ZaborOntzia : Form
    {
        public ZaborOntzia()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;
            MinimumSize = new Size(1024, 768);
            Load += (s, e) => KargatuPelikulak();
        }

        private void KargatuPelikulak()
        {
            panelPelikulak.Controls.Clear();
            var pelis = PelikulaRepo.GetAllDeleted();

            foreach (var p in pelis)
            {
                var karta = new Panel
                {
                    Width = panelPelikulak.ClientSize.Width - 40,
                    Height = 120,
                    BackColor = Color.White,
                    Margin = new Padding(10),
                    BorderStyle = BorderStyle.FixedSingle
                };

                var irudia = new PictureBox
                {
                    ImageLocation = p.Portada,
                    SizeMode = PictureBoxSizeMode.StretchImage,
                    Width = 80,
                    Height = 100,
                    Location = new Point(10, 10)
                };

                var etiketa = new Label
                {
                    Text = p.Izenburua.ToUpper(),
                    Location = new Point(100, 20),
                    AutoSize = true,
                    Font = new Font("Segoe UI", 14, FontStyle.Bold)
                };

                var btnBerreskuratu = new Button
                {
                    Text = "⬅",
                    Width = 40,
                    Height = 40,
                    BackColor = Color.DarkOrange,
                    ForeColor = Color.White,
                    FlatStyle = FlatStyle.Flat,
                    Location = new Point(karta.Width - 100, 40),
                    Anchor = AnchorStyles.Top | AnchorStyles.Right
                };
                btnBerreskuratu.FlatAppearance.BorderSize = 0;
                btnBerreskuratu.Click += (s, e) =>
                {
                    if (MessageBox.Show("Filma berreskuratu nahi duzu?", "", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        PelikulaRepo.Restore(p.Id);
                        KargatuPelikulak();
                    }
                };

                var btnEzabatu = new Button
                {
                    Text = "🗑",
                    Width = 40,
                    Height = 40,
                    BackColor = Color.Red,
                    ForeColor = Color.White,
                    FlatStyle = FlatStyle.Flat,
                    Location = new Point(karta.Width - 50, 40),
                    Anchor = AnchorStyles.Top | AnchorStyles.Right
                };
                btnEzabatu.FlatAppearance.BorderSize = 0;
                btnEzabatu.Click += (s, e) =>
                {
                    if (MessageBox.Show("Pelikula betiko ezabatu nahi duzu?", "", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        if (MessageBox.Show("Pelikularen erreserba guztiak ere ezbatatuko dira, zihur zaude?", "", MessageBoxButtons.YesNo) == DialogResult.Yes)
                        {
                            PelikulaRepo.HardDelete(p.Id);
                            KargatuPelikulak();
                        }
                    }
                };

                karta.Controls.Add(irudia);
                karta.Controls.Add(etiketa);
                karta.Controls.Add(btnBerreskuratu);
                karta.Controls.Add(btnEzabatu);

                panelPelikulak.Controls.Add(karta);
            }
        }

        private void btnAtzera_Click(object sender, EventArgs e)
        {
            Hide();
            new AdminKudeaketa().Show();
        }
    }
}
