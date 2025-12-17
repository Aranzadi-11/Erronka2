using System;
using System.Drawing;
using System.Windows.Forms;

namespace ZinemaApp
{
    partial class Main
    {
        private System.ComponentModel.IContainer osagaiak = null;
        private FlowLayoutPanel pelikulaPanel;
        private Button btnKudeaketa;

        protected override void Dispose(bool ezaba)
        {
            if (ezaba && (osagaiak != null)) osagaiak.Dispose();
            base.Dispose(ezaba);
        }

        private void InitializeComponent()
        {
            pelikulaPanel = new FlowLayoutPanel
            {
                AutoScroll = true,
                BackColor = Color.FromArgb(240, 240, 240),
                Dock = DockStyle.Fill,
                FlowDirection = FlowDirection.TopDown,
                Padding = new Padding(20),
                WrapContents = false
            };

            btnKudeaketa = new Button
            {
                BackColor = Color.FromArgb(30, 144, 255),
                FlatStyle = FlatStyle.Flat,
                Font = new Font("Segoe UI", 14, FontStyle.Bold),
                ForeColor = Color.White,
                Dock = DockStyle.Top,
                Height = 60,
                Text = "Kudeaketa"
            };
            btnKudeaketa.FlatAppearance.BorderSize = 0;
            btnKudeaketa.Click += btnKudeaketa_Click;

            ClientSize = new Size(1200, 800);
            Controls.Add(pelikulaPanel);
            Controls.Add(btnKudeaketa);
            MinimumSize = new Size(1024, 768);
            Name = "Main";
            Text = "ZINEMA";
            StartPosition = FormStartPosition.CenterScreen;
            WindowState = FormWindowState.Maximized;
        }
    }
}
