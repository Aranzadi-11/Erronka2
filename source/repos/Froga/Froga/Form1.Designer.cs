
namespace WinFormsApp
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            leftPanel = new Panel();
            btnProdIkusi = new Button();
            panel2 = new Panel();
            leftPanel.SuspendLayout();
            SuspendLayout();
            // 
            // leftPanel
            // 
            leftPanel.BackColor = Color.LightSlateGray;
            leftPanel.Controls.Add(btnProdIkusi);
            leftPanel.Dock = DockStyle.Left;
            leftPanel.Location = new Point(0, 0);
            leftPanel.Name = "leftPanel";
            leftPanel.Size = new Size(200, 579);
            leftPanel.TabIndex = 0;
            // 
            // btnProdIkusi
            // 
            btnProdIkusi.BackColor = Color.GhostWhite;
            btnProdIkusi.Dock = DockStyle.Top;
            btnProdIkusi.Location = new Point(0, 0);
            btnProdIkusi.Name = "btnProdIkusi";
            btnProdIkusi.Size = new Size(200, 50);
            btnProdIkusi.TabIndex = 0;
            btnProdIkusi.Text = "Produktuak ikusi";
            btnProdIkusi.UseVisualStyleBackColor = false;
            btnProdIkusi.Click += btnProdIkusi_Click;
            // 
            // panel2
            // 
            panel2.BackColor = Color.WhiteSmoke;
            panel2.Dock = DockStyle.Fill;
            panel2.Location = new Point(200, 0);
            panel2.Name = "panel2";
            panel2.Size = new Size(940, 579);
            panel2.TabIndex = 1;
            panel2.Paint += panel1_Paint;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1140, 579);
            Controls.Add(panel2);
            Controls.Add(leftPanel);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            leftPanel.ResumeLayout(false);
            ResumeLayout(false);
        }

        #endregion

        private Panel leftPanel;
        private Panel panel2;
        private Button btnProdIkusi;
    }
}
