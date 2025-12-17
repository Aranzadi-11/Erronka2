using NHibernate;
using NHibernate.Cfg;
using NHibernate.Mapping.ByCode;

namespace Erronka1API.Data
{
    public class NHibernateHelper
    {
        private static ISessionFactory _sessionFactory;

        public static ISessionFactory SessionFactory
        {
            get
            {
                if (_sessionFactory == null)
                    InitializeSessionFactory();
                return _sessionFactory;
            }
        }

        private static void InitializeSessionFactory()
        {
            var cfg = new Configuration();
            cfg.DataBaseIntegration(db =>
            {
                db.ConnectionString = "server=192.168.115.153;database=jatetxea;user=admin;password=abc123ABC@;";
                db.Dialect<NHibernate.Dialect.MySQLDialect>();
            });

            var mapper = new ModelMapper();
            mapper.AddMappings(typeof(NHibernateHelper).Assembly.GetExportedTypes());
            cfg.AddMapping(mapper.CompileMappingForAllExplicitlyAddedEntities());

            _sessionFactory = cfg.BuildSessionFactory();
        }

        public static NHibernate.ISession OpenSession()
        {
            return SessionFactory.OpenSession();
        }
    }
}
