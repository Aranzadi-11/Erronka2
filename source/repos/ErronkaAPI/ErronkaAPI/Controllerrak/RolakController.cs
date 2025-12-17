using ErronkaAPI.DTOak;
using ErronkaAPI.Modeloak;
using Microsoft.AspNetCore.Mvc;

namespace ErronkaAPI.Controllerrak
{
    [ApiController]
    [Route("api/[controller]")]
    public class RolakController : ControllerBase
    {
        private readonly ISession _session;

        public RolakController(ISession session)
        {
            _session = session;
        }

        [HttpGet]
        public IActionResult Get()
        {
            var lista = _session.Query<Rolak>().ToList();
            return Ok(lista);
        }

        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var rol = _session.Get<Rolak>(id);
            if (rol == null) return NotFound();
            return Ok(rol);
        }

        [HttpPost]
        public IActionResult Create(RolakDto dto)
        {
            var rol = new Rolak
            {
                Izena = dto.Izena
            };

            using (var tx = _session.BeginTransaction())
            {
                _session.Save(rol);
                tx.Commit();
            }

            return Ok(rol);
        }
    }
}