using Erronka1API.Models;
using Erronka1API.Services;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;


namespace YourNamespace.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class ErreserbaController : ControllerBase
    {
        private readonly ErreserbaService _service = new();

        [HttpGet]
        public IList<Erreserbak> Get() => _service.GetAll();

        [HttpGet("{id}")]
        public Erreserbak Get(int id) => _service.GetById(id);

        [HttpPost]
        public void Post([FromBody] Erreserbak erreserba) => _service.Create(erreserba);

        [HttpPut]
        public void Put([FromBody] Erreserbak erreserba) => _service.Update(erreserba);

        [HttpDelete("{id}")]
        public void Delete(int id) => _service.Delete(id);
    }
}
