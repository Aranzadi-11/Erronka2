using NHibernate.Mapping.ByCode;
using NHibernate.Mapping.ByCode.Conformist;
using ErronkaAPI.Modeloak;

namespace ErronkaAPI.Mapeoak
{ 
    public class RolakMap : ClassMapping<Rolak>
    {
        public RolakMap()
        {
            Table("rolak");

            Id(x => x.Id, m =>
            {
                m.Column("id");
                m.Generator(Generators.Identity);
            });

            Property(x => x.Izena, m =>
            {
                m.Column("izena");
                m.Length(100);
                m.NotNullable(true);
            });
        }
    }

}
