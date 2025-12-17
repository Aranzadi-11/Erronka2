using NHibernate;
using Erronka1API.Data;
using Erronka1API.Models;
using System.Collections.Generic;
using System.Linq;

namespace Erronka1API.Services
{
        public class ErreserbaService
        {
            public IList<Erreserbak> GetAll()
            {
                using NHibernate.ISession session = NHibernateHelper.OpenSession();
                return session.Query<Erreserbak>().ToList();
            }

            public Erreserbak GetById(int id)
            {
                using NHibernate.ISession session = NHibernateHelper.OpenSession();
                return session.Get<Erreserbak>(id);
            }

            public void Create(Erreserbak erreserba)
            {
                using NHibernate.ISession session = NHibernateHelper.OpenSession();
                using ITransaction tx = session.BeginTransaction();
                session.Save(erreserba);
                tx.Commit();
            }

            public void Update(Erreserbak erreserba)
            {
                using NHibernate.ISession session = NHibernateHelper.OpenSession();
                using ITransaction tx = session.BeginTransaction();
                session.Update(erreserba);
                tx.Commit();
            }

            public void Delete(int id)
            {
                using NHibernate.ISession session = NHibernateHelper.OpenSession();
                using ITransaction tx = session.BeginTransaction();
                var erreserba = session.Get<Erreserbak>(id);
                if (erreserba != null)
                    session.Delete(erreserba);
                tx.Commit();
            }
        }
    }
