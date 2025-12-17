namespace ErronkaAPI.Repositorioak
{
    using ErronkaAPI.Modeloak;
    using NHibernate;
    using System.Collections.Generic;
    using System.Linq;

    namespace GastuakApi.Repositorioak
    {
        public class RolakRepository
        {
            private readonly ISession _session;

            public RolakRepository(ISessionFactory sessionFactory)
            {
                _session = sessionFactory.GetCurrentSession();
            }

            public void Add(Rolak rol)
            {
                using var tx = _session.BeginTransaction();
                _session.Save(rol);
                tx.Commit();
            }

            public Rolak? Get(int id)
            {
                return _session.Query<Rolak>()
                               .SingleOrDefault(x => x.Id == id);
            }

            public IList<Rolak> GetAll()
            {
                return _session.Query<Rolak>().ToList();
            }

            public void Update(Rolak rol)
            {
                using var tx = _session.BeginTransaction();
                _session.Update(rol);
                tx.Commit();
            }

            public void Delete(Rolak rol)
            {
                using var tx = _session.BeginTransaction();
                _session.Delete(rol);
                tx.Commit();
            }
        }
    }

}
