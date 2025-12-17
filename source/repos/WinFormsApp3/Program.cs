using System;
using System.Drawing;
using System.Windows.Forms;

namespace WinFormsApp3
{
    public class Program1 : Form
    {
        private TextBox textBoxInput;
        private TextBox textBoxOutput;
        private Button buttonChangeText;

        public Program1()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            // Crear y configurar los controles
            textBoxInput = new TextBox
            {
                Location = new Point(10, 10),
                Name = "textBoxInput"
            };
            Controls.Add(textBoxInput);

            textBoxOutput = new TextBox
            {
                Location = new Point(10, 40),
                Name = "textBoxOutput"
            };
            Controls.Add(textBoxOutput);

            buttonChangeText = new Button
            {
                Location = new Point(10, 70),
                Name = "buttonChangeText",
                Text = "Cambiar Texto"
            };
            buttonChangeText.Click += ButtonChangeText_Click;
            Controls.Add(buttonChangeText);
        }

        private void ButtonChangeText_Click(object sender, EventArgs e)
        {
            try
            {
                // Validar que el textBoxInput no esté vacío
                if (string.IsNullOrWhiteSpace(textBoxInput.Text))
                {
                    MessageBox.Show("El campo de entrada no puede estar vacío.", "Advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                // Cambiar el texto del textBoxOutput por el texto del textBoxInput
                textBoxOutput.Text = textBoxInput.Text;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Ocurrió un error: {ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new Form1());
        }
    }
}
