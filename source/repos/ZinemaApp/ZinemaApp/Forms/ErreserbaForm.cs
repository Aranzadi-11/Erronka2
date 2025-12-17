using System;
using System.Windows.Forms;
using ZinemaApp.Repoak;

namespace ZinemaApp
{
    public partial class ErreserbaForm : Form
    {
        private Pelikula pelikula;

        public ErreserbaForm(Pelikula p)
        {
            pelikula = p;
            InitializeComponent();
            KargatuXehetasuna();
        }

        private void KargatuXehetasuna()
        {
            lblIzenburua.Text = pelikula.Izenburua?.ToUpper() ?? "TITULU GABE";
            imgPortada.ImageLocation = pelikula.Portada;
            lblDeskribapena.Text = pelikula.Deskribapena ?? "";
            EguneratuLibre();
        }

        private void EguneratuLibre()
        {
            int gordetako = ErreserbaRepo.GetReservedSeats(pelikula.Id);
            int libre = pelikula.EserlekuKopurua - gordetako;
            if (libre < 0) libre = 0;

            lblLibre.Text = $"Libre: {libre}";

            bool eskaintzenDa = libre > 0;

            comboKopurua.Enabled = eskaintzenDa;
            btnErosi.Enabled = eskaintzenDa;

            if (!eskaintzenDa)
                lblLibre.Text += " (ez dago sarrerarik)";
        }

        private void btnAtzera_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnErosi_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtIzena.Text) || string.IsNullOrWhiteSpace(txtAbizena.Text) || string.IsNullOrWhiteSpace(txtTelefonoa.Text))
            {
                MessageBox.Show("Mesedez, bete laukien guztiak.", "Errorea", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (!string.IsNullOrWhiteSpace(txtEmaila.Text) && !txtEmaila.Text.Contains("@"))
            {
                MessageBox.Show("Mesedez, sartu email baliozko formatuan.", "Errorea", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            int kop = (comboKopurua.SelectedItem != null) ? Convert.ToInt32(comboKopurua.SelectedItem) : (comboKopurua.SelectedIndex + 1);
            var erreserba = new Erreserba
            {
                PeliculaId = pelikula.Id,
                Izena = txtIzena.Text.Trim(),
                Abizena = txtAbizena.Text.Trim(),
                Telefonoa = txtTelefonoa.Text.Trim(),
                Email = txtEmaila.Text.Trim(),
                EserlekuKopurua = kop,
                ErreserbaEguna = DateTime.Now
            };

            ErreserbaRepo.Add(erreserba);

            MessageBox.Show("Erreserba egina da.", "Ondo", MessageBoxButtons.OK, MessageBoxIcon.Information);

            this.Hide();
            var nagusia = new Main();
            nagusia.Show();
            this.Close();
        }
    }
}
