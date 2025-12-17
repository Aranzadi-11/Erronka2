using Microsoft.EntityFrameworkCore;

public class AppDbContext : DbContext
{
    public AppDbContext(DbContextOptions<AppDbContext> options)
        : base(options)
    {
    }

    // Aquí defines tus tablas, por ejemplo:
    public DbSet<Usuario> Usuarios { get; set; }
}

public class Usuario
{
    public int Id { get; set; }
    public string Nombre { get; set; }
}
