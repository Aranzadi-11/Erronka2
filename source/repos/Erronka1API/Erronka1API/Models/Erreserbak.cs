using System;

namespace Erronka1API.Models
{
    public class Erreserbak
    {
        public virtual int Id { get; set; }
        public virtual int MahaiaId { get; set; }
        public virtual string Izena { get; set; }
        public virtual int Telefonoa { get; set; }
        public virtual DateTime? ErreserbaData { get; set; }
        public virtual int? PertsonaKop { get; set; }
        public virtual string Egoera { get; set; }
        public virtual string Oharrak { get; set; }
    }
}
