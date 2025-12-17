using System;
using System.Windows.Forms;
using System.Drawing;

namespace ZinemaApp
{
    partial class PelikulaGestioa
    {
        private System.ComponentModel.IContainer osagaiak = null;
        private TableLayoutPanel egitura;
        private Label lblIzenburua, lblEserlekuak, lblPortada, lblDeskribapena;
        private TextBox txtIzenburua, txtEserlekuak, txtPortada, txtDeskribapena;
        private Panel panelBotak;
        private Button btnGorde, btnDeuseztatu;

        protected override void Dispose(bool dispose)
        {
            if (dispose && (osagaiak != null)) osagaiak.Dispose();
            base.Dispose(dispose);
        }

        private void InitializeComponent()
        {
            egitura = new TableLayoutPanel();
            lblIzenburua = new Label(); txtIzenburua = new TextBox();
            lblEserlekuak = new Label(); txtEserlekuak = new TextBox();
            lblPortada = new Label(); txtPortada = new TextBox();
            lblDeskribapena = new Label(); txtDeskribapena = new TextBox();
            panelBotak = new Panel();
            btnGorde = new Button(); btnDeuseztatu = new Button();

            this.Text = "ZINEMA - Pelikula Gestioa";
            this.WindowState = FormWindowState.Maximized;
            this.MinimumSize = new Size(900, 600);
            this.StartPosition = FormStartPosition.CenterScreen;

            egitura.Dock = DockStyle.Fill;
            egitura.ColumnCount = 2;
            egitura.RowCount = 5;
            egitura.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 30));
            egitura.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 70));

            for (int i = 0; i < 4; i++) egitura.RowStyles.Add(new RowStyle(SizeType.Absolute, 60));
            egitura.RowStyles.Add(new RowStyle(SizeType.Percent, 100));

            Labela(lblIzenburua, "Izenburua:"); Testua(txtIzenburua);
            Labela(lblEserlekuak, "Eserleku kopurua:"); Testua(txtEserlekuak);
            Labela(lblPortada, "Portada URL:"); Testua(txtPortada);
            Labela(lblDeskribapena, "Deskribapena:");
            txtDeskribapena.Multiline = true; txtDeskribapena.Dock = DockStyle.Fill;
            txtDeskribapena.Font = new Font("Segoe UI", 12); txtDeskribapena.ScrollBars = ScrollBars.Vertical;

            panelBotak.Dock = DockStyle.Fill; panelBotak.Padding = new Padding(20);
            panelBotak.BackColor = Color.Transparent;

            btnGorde.Text = "Gorde"; BotonEstiloa(btnGorde);
            btnGorde.Anchor = AnchorStyles.Bottom | AnchorStyles.Right;
            btnGorde.Click += btnGorde_Click;

            btnDeuseztatu.Text = "Deuseztatu"; BotonEstiloa(btnDeuseztatu);
            btnDeuseztatu.Anchor = AnchorStyles.Bottom | AnchorStyles.Left;
            btnDeuseztatu.Click += btnDeuseztatu_Click;

            panelBotak.Controls.Add(btnDeuseztatu); panelBotak.Controls.Add(btnGorde);

            egitura.Controls.Add(lblIzenburua, 0, 0); egitura.Controls.Add(txtIzenburua, 1, 0);
            egitura.Controls.Add(lblEserlekuak, 0, 1); egitura.Controls.Add(txtEserlekuak, 1, 1);
            egitura.Controls.Add(lblPortada, 0, 2); egitura.Controls.Add(txtPortada, 1, 2);
            egitura.Controls.Add(lblDeskribapena, 0, 3); egitura.Controls.Add(txtDeskribapena, 1, 3);
            egitura.Controls.Add(panelBotak, 1, 4);

            this.Controls.Add(egitura);
        }

        private void Labela(Label lbl, string text)
        {
            lbl.Text = text; lbl.Font = new Font("Segoe UI", 12, FontStyle.Bold);
            lbl.Dock = DockStyle.Fill; lbl.TextAlign = ContentAlignment.MiddleLeft;
        }

        private void Testua(TextBox tb)
        {
            tb.Font = new Font("Segoe UI", 12); tb.Dock = DockStyle.Fill;
        }

        private void BotonEstiloa(Button b)
        {
            b.Font = new Font("Segoe UI", 12, FontStyle.Bold);
            b.Size = new Size(150, 45); b.Margin = new Padding(10);
        }
    }
}
