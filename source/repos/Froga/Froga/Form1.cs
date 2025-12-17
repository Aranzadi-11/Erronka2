using WinFormsApp.Controllerak;

namespace WinFormsApp
{
    public partial class Form1 : Form
    {
        Panel panelMenu;
        Panel panelContenido;
        Label lblTitulo;

        public Form1()
        {
            InitializeComponent();

            this.WindowState = FormWindowState.Maximized; // Maximizatuta hasteko
            this.MinimumSize = new Size(800, 600); // Pantaila tamaina minimoa ezartzen da
            this.Text = "Inbentario kudeaketa"; // Leihoaren izena

            //Ezkerreko panela pantailaren arabera moldatzeko
            this.Resize += new EventHandler(MainForm_Resize);
            UpdateLeftPanelSize();

            //InterfazeaSortu();

        }

        private void MainForm_Resize(object sender, EventArgs e)
        {
            UpdateLeftPanelSize();
        }

        private void UpdateLeftPanelSize()
        {
            // Adibidez, zabaleraren %20 izango da leftPanel
            int width = (int)(this.ClientSize.Width * 0.2);
            leftPanel.Size = new Size(width, this.ClientSize.Height);
        }

        private void InterfazeaSortu()
        {

            // Ezkerreko menua
            panelMenu = new Panel();
            panelMenu.Dock = DockStyle.Left;
            panelMenu.Width = 200;
            panelMenu.BackColor = Color.LightSlateGray;
            this.Controls.Add(panelMenu);

            // Botoia
            Button btnVerProductos = new Button();
            btnVerProductos.Text = "Produktuak ikusi";
            btnVerProductos.Dock = DockStyle.Top;
            btnVerProductos.Height = 50;
            btnVerProductos.Click += BtnVerProductos_Click;
            panelMenu.Controls.Add(btnVerProductos);

            // Erdiko panela
            panelContenido = new Panel();
            panelContenido.Dock = DockStyle.Fill;
            panelContenido.BackColor = Color.WhiteSmoke;
            this.Controls.Add(panelContenido);

            // Titulua
            lblTitulo = new Label();
            lblTitulo.Text = "Ongi etorri aplikaziora";
            lblTitulo.Font = new Font("Segoe UI", 20, FontStyle.Bold);
            lblTitulo.Dock = DockStyle.Top;
            lblTitulo.Height = 80;
            lblTitulo.TextAlign = ContentAlignment.MiddleCenter;
            panelContenido.Controls.Add(lblTitulo);

        }

        private void BtnVerProductos_Click(object? sender, EventArgs e)
        {
            ProduktuakErakutsi(panelContenido);
        }

        private void ProduktuakErakutsi(Panel panel)
        {
            panel.Controls.Clear();

            var grid = new DataGridView();
            grid.Dock = DockStyle.Fill;
            grid.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            grid.DataSource = ProduktuakController.DenakLortu();

            panel.Controls.Add(grid);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //System.Windows.Forms.MessageBox.Show("Nire mezua");
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void btnProdIkusi_Click(object sender, EventArgs e)
        {
            ProduktuakErakutsi(panel2);
        }
    }

}