using System;
using System.Windows.Forms;
using ZinemaApp.Repoak;

namespace ZinemaApp
{
    public partial class PelikulaGestioa : Form
    {
        private Pelikula pelikula;

        public PelikulaGestioa(Pelikula p)
        {
            pelikula = p;
            InitializeComponent();

            if (pelikula != null)
            {
                txtIzenburua.Text = pelikula.Izenburua;
                txtEserlekuak.Text = pelikula.EserlekuKopurua.ToString();
                txtPortada.Text = pelikula.Portada;
                txtDeskribapena.Text = pelikula.Deskribapena;
            }

            txtEserlekuak.KeyPress += TxtEserlekuak_KeyPress;

            this.Activated += (s, e) => this.Show();
            this.Deactivate += (s, e) => this.Hide();
        }

        private void TxtEserlekuak_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsControl(e.KeyChar) && !char.IsDigit(e.KeyChar))
            {
                e.Handled = true;
            }
        }

        private void btnGorde_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtIzenburua.Text) ||
                string.IsNullOrWhiteSpace(txtEserlekuak.Text) ||
                string.IsNullOrWhiteSpace(txtPortada.Text))
            {
                MessageBox.Show("Mesedez bete lauki guztiak", "Errorea", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return; 
            }

            if (!int.TryParse(txtEserlekuak.Text, out int eserlekuKop))
            {
                MessageBox.Show("Eserleku kopurua zenbakia izan behar da", "Errorea", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (pelikula == null)
            {
                PelikulaRepo.Add(new Pelikula
                {
                    Izenburua = txtIzenburua.Text,
                    EserlekuKopurua = eserlekuKop,
                    Portada = txtPortada.Text,
                    Deskribapena = txtDeskribapena.Text
                });
            }
            else
            {
                pelikula.Izenburua = txtIzenburua.Text;
                pelikula.EserlekuKopurua = eserlekuKop;
                pelikula.Portada = txtPortada.Text;
                pelikula.Deskribapena = txtDeskribapena.Text;
                PelikulaRepo.Update(pelikula);
            }

            this.Close();
        }

        private void btnDeuseztatu_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
