using Org.BouncyCastle.Pqc.Crypto.Lms;
using System;
using System.Drawing;
using System.Windows.Forms;

namespace ZinemaApp
{
    partial class AdminKudeaketa
    {
        private System.ComponentModel.IContainer components = null;
        private FlowLayoutPanel panelPelikulak;
        private Button btnZaborOntzia;
        private Button btnAtzera;

        protected override void Dispose(bool disposing)
        {
            if (disposing && components != null) components.Dispose();
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            panelPelikulak = new FlowLayoutPanel();
            btnZaborOntzia = new Button();
            btnAtzera = new Button();
            this.StartPosition = FormStartPosition.CenterScreen;
            this.WindowState = FormWindowState.Maximized;
            MinimumSize = new Size(1024, 768);
            this.FormBorderStyle = FormBorderStyle.Sizable;
            SuspendLayout();

            btnZaborOntzia.BackColor = Color.FromArgb(30, 144, 255);
            btnZaborOntzia.FlatStyle = FlatStyle.Flat;
            btnZaborOntzia.FlatAppearance.BorderSize = 0;
            btnZaborOntzia.Font = new Font("Segoe UI", 14F, FontStyle.Bold);
            btnZaborOntzia.ForeColor = Color.White;
            btnZaborOntzia.Dock = DockStyle.Top;
            btnZaborOntzia.Height = 60;
            btnZaborOntzia.Text = "Zabor Ontzia";
            btnZaborOntzia.Click += btnZaborOntzia_Click;

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
            panelPelikulak.BackColor = Color.FromArgb(245, 245, 245);
            panelPelikulak.Dock = DockStyle.Fill;
            panelPelikulak.FlowDirection = FlowDirection.TopDown;
            panelPelikulak.Padding = new Padding(20);
            panelPelikulak.WrapContents = false;

            Controls.Add(panelPelikulak);
            Controls.Add(btnAtzera);
            Controls.Add(btnZaborOntzia);

            Name = "AdminKudeaketa";
            Text = "ZINEMA";

            ResumeLayout(false);
        }
    }
}
