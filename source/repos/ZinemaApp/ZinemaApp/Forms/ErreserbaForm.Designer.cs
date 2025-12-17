using System;
using System.Drawing;
using System.Windows.Forms;

namespace ZinemaApp
{
    partial class ErreserbaForm
    {
        private TableLayoutPanel nagusiaLayout;
        private Label lblIzenburua, lblDeskribapena, lblLibre;
        private PictureBox imgPortada;
        private Button btnAtzera, btnErosi;
        private ComboBox comboKopurua;
        private TextBox txtIzena, txtAbizena, txtTelefonoa, txtEmaila;
        private Label lblIzena, lblAbizena, lblTelefonoa, lblEmaila, lblKopurua;

        private void InitializeComponent()
        {
            this.Text = "ZINEMA";
            this.StartPosition = FormStartPosition.CenterScreen;
            this.WindowState = FormWindowState.Maximized;
            this.MinimumSize = new Size(900, 650);
            this.BackColor = Color.White;
            this.FormBorderStyle = FormBorderStyle.Sizable;

            nagusiaLayout = new TableLayoutPanel
            {
                Dock = DockStyle.Fill,
                ColumnCount = 1,
                RowCount = 4,
                Padding = new Padding(20),
                AutoSize = true
            };
            nagusiaLayout.RowStyles.Add(new RowStyle(SizeType.AutoSize));
            nagusiaLayout.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            nagusiaLayout.RowStyles.Add(new RowStyle(SizeType.Percent, 50F));
            nagusiaLayout.RowStyles.Add(new RowStyle(SizeType.Absolute, 80F));
            this.Controls.Add(nagusiaLayout);

            lblIzenburua = new Label
            {
                Font = new Font("Segoe UI", 28F, FontStyle.Bold),
                Dock = DockStyle.Fill,
                TextAlign = ContentAlignment.MiddleLeft,
                ForeColor = Color.FromArgb(20, 50, 120),
                AutoSize = true,
                MaximumSize = new Size(0, 80)
            };
            nagusiaLayout.Controls.Add(lblIzenburua, 0, 0);

            var erdikoPanel = new TableLayoutPanel
            {
                Dock = DockStyle.Fill,
                ColumnCount = 2,
                RowCount = 1,
                Padding = new Padding(0),
                AutoSize = true
            };
            erdikoPanel.ColumnStyles.Add(new ColumnStyle(SizeType.AutoSize));
            erdikoPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100F));
            nagusiaLayout.Controls.Add(erdikoPanel, 0, 1);

            imgPortada = new PictureBox
            {
                Size = new Size(300, 420),
                SizeMode = PictureBoxSizeMode.Zoom,
                Margin = new Padding(0, 0, 20, 0),
                Dock = DockStyle.Left
            };
            erdikoPanel.Controls.Add(imgPortada, 0, 0);

            var xehetasunakFlow = new FlowLayoutPanel
            {
                Dock = DockStyle.Fill,
                FlowDirection = FlowDirection.TopDown,
                AutoSize = true,
                WrapContents = false
            };
            lblDeskribapena = new Label
            {
                Font = new Font("Segoe UI", 12F),
                AutoSize = true,
                MaximumSize = new Size(0, 0)
            };
            lblLibre = new Label
            {
                Font = new Font("Segoe UI", 12F, FontStyle.Bold),
                AutoSize = true,
                ForeColor = Color.Green,
                Margin = new Padding(0, 8, 0, 0)
            };
            xehetasunakFlow.Controls.Add(lblDeskribapena);
            xehetasunakFlow.Controls.Add(lblLibre);
            erdikoPanel.Controls.Add(xehetasunakFlow, 1, 0);

            var sarreraPanel = new TableLayoutPanel
            {
                Dock = DockStyle.None,
                ColumnCount = 2,
                RowCount = 5,
                AutoSize = true,
                Margin = new Padding(0, 20, 0, 20)
            };
            sarreraPanel.ColumnStyles.Add(new ColumnStyle(SizeType.AutoSize));
            sarreraPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Absolute, 300F));

            lblIzena = new Label { Text = "Izena (derrigorrezkoa):", Anchor = AnchorStyles.Left, AutoSize = true };
            txtIzena = new TextBox { Width = 300 };
            lblAbizena = new Label { Text = "Abizena (derrigorrezkoa):", Anchor = AnchorStyles.Left, AutoSize = true };
            txtAbizena = new TextBox { Width = 300 };
            lblTelefonoa = new Label { Text = "Telefonoa (derrigorrezkoa):", Anchor = AnchorStyles.Left, AutoSize = true };
            txtTelefonoa = new TextBox { Width = 300 };
            lblEmaila = new Label { Text = "Emaila (aukerakoa):", Anchor = AnchorStyles.Left, AutoSize = true };
            txtEmaila = new TextBox { Width = 300 };
            lblKopurua = new Label { Text = "Sarrerak (1-5):", Anchor = AnchorStyles.Left, AutoSize = true };
            comboKopurua = new ComboBox { Width = 300, DropDownStyle = ComboBoxStyle.DropDownList };
            for (int i = 1; i <= 5; i++) comboKopurua.Items.Add(i);
            comboKopurua.SelectedIndex = 0;

            sarreraPanel.Controls.Add(lblIzena, 0, 0); sarreraPanel.Controls.Add(txtIzena, 1, 0);
            sarreraPanel.Controls.Add(lblAbizena, 0, 1); sarreraPanel.Controls.Add(txtAbizena, 1, 1);
            sarreraPanel.Controls.Add(lblTelefonoa, 0, 2); sarreraPanel.Controls.Add(txtTelefonoa, 1, 2);
            sarreraPanel.Controls.Add(lblEmaila, 0, 3); sarreraPanel.Controls.Add(txtEmaila, 1, 3);
            sarreraPanel.Controls.Add(lblKopurua, 0, 4); sarreraPanel.Controls.Add(comboKopurua, 1, 4);

            var sarreraContainer = new FlowLayoutPanel
            {
                Dock = DockStyle.Fill,
                FlowDirection = FlowDirection.TopDown,
                AutoSize = true,
                WrapContents = false,
                Anchor = AnchorStyles.None
            };
            sarreraContainer.Controls.Add(sarreraPanel);
            nagusiaLayout.Controls.Add(sarreraContainer, 0, 2);

            var botoiPanel = new TableLayoutPanel
            {
                Dock = DockStyle.Fill,
                ColumnCount = 2,
                RowCount = 1
            };
            botoiPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));
            botoiPanel.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 50F));

            btnAtzera = new Button { Text = "Atzera", BackColor = Color.Gray, ForeColor = Color.White, Padding = new Padding(10), Width = 140, Height = 44, Anchor = AnchorStyles.Left };
            btnErosi = new Button { Text = "Erosi", BackColor = Color.FromArgb(20, 50, 120), ForeColor = Color.White, Padding = new Padding(10), Width = 140, Height = 44, Anchor = AnchorStyles.Right };

            btnAtzera.Click += btnAtzera_Click;
            btnErosi.Click += btnErosi_Click;

            var leftHolder = new Panel { Dock = DockStyle.Fill, Padding = new Padding(10) };
            var rightHolder = new Panel { Dock = DockStyle.Fill, Padding = new Padding(10) };
            leftHolder.Controls.Add(btnAtzera);
            rightHolder.Controls.Add(btnErosi);
            botoiPanel.Controls.Add(leftHolder, 0, 0);
            botoiPanel.Controls.Add(rightHolder, 1, 0);

            nagusiaLayout.Controls.Add(botoiPanel, 0, 3);
        }
    }
}
