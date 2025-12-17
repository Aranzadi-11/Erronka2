Public Class Form1
    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        ' Crear y configurar los controles
        Dim textBoxInput As New TextBox()
        textBoxInput.Location = New Point(10, 10)
        textBoxInput.Name = "textBoxInput"
        Me.Controls.Add(textBoxInput)

        Dim textBoxOutput As New TextBox()
        textBoxOutput.Location = New Point(10, 40)
        textBoxOutput.Name = "textBoxOutput"
        Me.Controls.Add(textBoxOutput)

        Dim buttonChangeText As New Button()
        buttonChangeText.Location = New Point(10, 70)
        buttonChangeText.Name = "buttonChangeText"
        buttonChangeText.Text = "Cambiar Texto"
        AddHandler buttonChangeText.Click, AddressOf Me.ButtonChangeText_Click
        Me.Controls.Add(buttonChangeText)
    End Sub

    Private Sub ButtonChangeText_Click(sender As Object, e As EventArgs)
        ' Obtener los controles por su nombre
        Dim textBoxInput As TextBox = CType(Me.Controls("textBoxInput"), TextBox)
        Dim textBoxOutput As TextBox = CType(Me.Controls("textBoxOutput"), TextBox)

        ' Cambiar el texto del textBoxOutput por el texto del textBoxInput
        textBoxOutput.Text = textBoxInput.Text
    End Sub
End Class
