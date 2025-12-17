using Erronka1API.Models;
using NHibernate.Mapping.ByCode;
using NHibernate.Mapping.ByCode.Conformist;

namespace Erronka1API.Maps
{
    public class ErreserbaMap : ClassMapping<Erreserbak>
    {
        public ErreserbaMap()
        {
            Table("erreserbak");
            Id(x => x.Id, m => m.Generator(Generators.Identity));
            Property(x => x.MahaiaId);
            Property(x => x.Izena);
            Property(x => x.Telefonoa);
            Property(x => x.ErreserbaData);
            Property(x => x.PertsonaKop);
            Property(x => x.Egoera);
            Property(x => x.Oharrak);
        }
    }
}
