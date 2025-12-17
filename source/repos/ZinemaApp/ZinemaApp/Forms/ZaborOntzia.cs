using Org.BouncyCastle.Asn1.Crmf;
using System;
using System.Drawing;
using System.Windows.Forms;
using System.Xml.Linq;
using static System.Net.Mime.MediaTypeNames;

namespace ZinemaApp
{
    partial class ZaborOntzia
    {
        private System.ComponentModel.IContainer osagaiak = null;
        private FlowLayoutPanel panelPelikulak;
        private Button btnAtzera;

        protected override void Dispose(bool disposing)
        {
            if (disposing && osagaiak != null) osagaiak.Dispose();
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            panelPelikulak = new FlowLayoutPanel();
            btnAtzera = new Button();
            SuspendLayout();

            btnAtzera.BackColor = Color.FromArgb(30, 144, 255);
            btnAtzera.FlatStyle = FlatStyle.Flat;
            btnAtzera.FlatAppearance.BorderSize = 0;
            btnAtzera.Font = new Font("Segoe UI", 14F, FontStyle.Bold);
            btnAtzera.ForeColor = Color.White;
            btnAtzera.Dock = DockStyle.Bottom;
            btnAtzera.Height = 60;
            btnAtzera.Text = "Atzera";
            btnAtzera.Click += btnAtzera_Click;

            panelPelikulak.AutoScroll = true;
            panelPelikulak.BackColor = Color.FromArgb(240, 240, 240);
            panelPelikulak.Dock = DockStyle.Fill;
            panelPelikulak.FlowDirection = FlowDirection.TopDown;
            panelPelikulak.Padding = new Padding(20);
            panelPelikulak.WrapContents = false;
            panelPelikulak.Resize += (s, e) =>
            {
                foreach (Control c in panelPelikulak.Controls)
                {
                    if (c is Panel p) p.Width = panelPelikulak.ClientSize.Width - 40;
                }
            };

            ClientSize = new Size(1200, 800);
            Controls.Add(panelPelikulak);
            Controls.Add(btnAtzera);
            MinimumSize = new Size(1024, 768);
            Name = "ZaborOntzia";
            Text = "Zabor Ontzia";
            StartPosition = FormStartPosition.CenterScreen;
            WindowState = FormWindowState.Maximized;
            ResumeLayout(false);
        }
    }
}
