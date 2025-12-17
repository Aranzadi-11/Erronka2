using System;
using System.Drawing;
using System.Windows.Forms;
using ZinemaApp.Repoak;

namespace ZinemaApp
{
    public partial class AdminKudeaketa : Form
    {
        public AdminKudeaketa()
        {
            InitializeComponent();
            KargatuPelikulak();
        }

        private void KargatuPelikulak()
        {
            panelPelikulak.Controls.Clear();
            var pelikulak = PelikulaRepo.GetAllActive();

            foreach (var p in pelikulak)
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

                var izenburua = new Label
                {
                    Text = p.Izenburua.ToUpper(),
                    Location = new Point(100, 20),
                    AutoSize = true,
                    Font = new Font("Segoe UI", 14, FontStyle.Bold)
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
                    if (MessageBox.Show("Zihur zaude pelikula ezabatu nahi duzula?", "", MessageBoxButtons.YesNo) == DialogResult.Yes)
                    {
                        PelikulaRepo.SoftDelete(p.Id);
                        KargatuPelikulak();
                    }
                };

                karta.MouseEnter += (s, e) => karta.BackColor = Color.FromArgb(235, 245, 255);
                karta.MouseLeave += (s, e) => karta.BackColor = Color.White;

                karta.Controls.Add(irudia);
                karta.Controls.Add(izenburua);
                karta.Controls.Add(btnEzabatu);

                karta.Click += (s, e) =>
                {
                    var kudeaketa = new PelikulaGestioa(p);
                    kudeaketa.ShowDialog();
                    KargatuPelikulak();
                };

                panelPelikulak.Controls.Add(karta);
            }

            var btnGehitu = new Button
            {
                Text = "+",
                Font = new Font("Segoe UI", 26, FontStyle.Bold),
                Size = new Size(90, 90),
                BackColor = Color.FromArgb(0, 120, 215),
                ForeColor = Color.White,
                FlatStyle = FlatStyle.Flat
            };
            btnGehitu.FlatAppearance.BorderSize = 0;

            btnGehitu.Click += (s, e) =>
            {
                new PelikulaGestioa(null).ShowDialog();
                KargatuPelikulak();
            };

            var panelGehitu = new Panel
            {
                Width = panelPelikulak.ClientSize.Width - 40,
                Height = 120,
                BackColor = Color.Transparent
            };
            btnGehitu.Location = new Point((panelGehitu.Width - btnGehitu.Width) / 2,
                                           (panelGehitu.Height - btnGehitu.Height) / 2);
            btnGehitu.Anchor = AnchorStyles.Top;

            panelGehitu.Controls.Add(btnGehitu);
            panelPelikulak.Controls.Add(panelGehitu);

            panelPelikulak.Resize += (s, e) =>
            {
                foreach (Control c in panelPelikulak.Controls)
                {
                    if (c is Panel p && p.Controls.Contains(btnGehitu))
                    {
                        p.Width = panelPelikulak.ClientSize.Width - 40;
                        btnGehitu.Location = new Point((p.Width - btnGehitu.Width) / 2,
                                                       (p.Height - btnGehitu.Height) / 2);
                    }
                    else if (c is Panel px)
                    {
                        px.Width = panelPelikulak.ClientSize.Width - 40;
                    }
                }
            };
        }

        private void btnZaborOntzia_Click(object sender, EventArgs e)
        {
            Hide();
            new ZaborOntzia().ShowDialog();
        }

        private void btnAtzera_Click(object sender, EventArgs e)
        {
            Hide();
            new Main().Show();
        }
    }
}
