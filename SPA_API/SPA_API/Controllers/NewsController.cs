using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using SPA_API.Models;

namespace SPA_API.Controllers
{
    [Route("api/[controller]")]
    [AllowAnonymous]
    [ApiController]
    public class NewsController : ControllerBase
    {
        /* private readonly IF4101_BeatySolutions_API_ISem_2020Context _context;

         public NewsController(IF4101_BeatySolutions_API_ISem_2020Context context)
         {
             _context = context;
         }*/


        IF4101_BeatySolutions_API_ISem_2020Context _context = new IF4101_BeatySolutions_API_ISem_2020Context ();


        // GET: api/News
        [HttpGet]
        public async Task<ActionResult<IEnumerable<News>>> GetNews()
        {
            try
            {
                return await _context.News.ToListAsync();
            }
            catch
            {
                throw;
            }
        }
        [EnableCors("AllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public IActionResult GetAllNewsSP()
        {
            try
            {
                var news = _context.News
                         .FromSqlRaw($"BS_API_ISem_2020.SelectNews")
                         .AsEnumerable();

            return Ok(news);
            }
            catch
            {
                throw;
            }

        }
        [EnableCors("AllPolicy")]
        [Route("[action]")]
        [HttpPost]
        public IActionResult PostNews(News news)
        {
            try
            {
                var result = _context.Database.ExecuteSqlRaw("BS_API_ISem_2020.InsertUpdateNews {0}, {1}, {2}, {3}, {4}, {5}, {6}",
                                news.IdNews,
                                news.IdUserCreator,
                                news.Description,
                                news.Documentation,
                                news.NewsType,
                                news.Image,
                                "Insert");
            if (result == 0)
            {
                return null;
            }

            return Ok(result);
            }
            catch
            {
                throw;
            }
        }
        [EnableCors("AllPolicy")]
        [Route("[action]")]
        [HttpPut]
        public IActionResult PutNews(News news)
        {
            try
            {


                var result = _context.Database.ExecuteSqlRaw("BS_API_ISem_2020.InsertUpdateNews {0}, {1}, {2}, {3}, {4}, {5}, {6}",
                                news.IdNews,
                                news.IdUserCreator,
                                news.Description,
                                news.Documentation,
                                news.NewsType,
                                news.Image,
                                "Update");
            if (result == 0)
            {
                return null;
            }

            return Ok(result);
            }
            catch
            {
                throw;
            }

        }
        [EnableCors("AllPolicy")]
        [Route("[action]/{id}")]
        [HttpDelete]

        public IActionResult DeleteNews(int id)
        {
            try
            {
                var result = _context.Database.ExecuteSqlRaw("BS_API_ISem_2020.DeleteSNews {0}", id);
            if (result == 0)
            {
                return null;
            }

            return Ok(result);
            }
            catch
            {
                throw;
            }
        }
        [EnableCors("AllPolicy")]
        [Route("[action]/{id}")]
        [HttpGet]
        public IActionResult GetNews(int id)
        {
            try
            {
                var IdNews = new SqlParameter("@IdNews", id);
            var news = _context.News
                           .FromSqlRaw($"BS_API_ISem_2020.GetByIdNews @IdNews", IdNews)
                           .AsEnumerable().Single();

            if (news == null)
            {
                return NotFound();
            }

            return Ok(news);
            }
            catch
            {
                throw;
            }

        }
}
}