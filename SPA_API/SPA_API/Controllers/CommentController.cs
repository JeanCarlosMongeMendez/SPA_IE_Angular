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
    public class CommentController : ControllerBase
    {
        IF4101_BeatySolutions_API_ISem_2020Context _context = new IF4101_BeatySolutions_API_ISem_2020Context();


        // GET: api/News
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Comment>>> GetComment()
        {
            try
            {

                return await _context.Comment.ToListAsync();
            }
            catch
            {
                throw;
            }
        }
        [EnableCors("AllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public IActionResult GetAllCommentSP()
        {
            try
            {

                var students = _context.Comment
                         .FromSqlRaw($"BS_API_ISem_2020.SelectComment")
                         .AsEnumerable();

            return Ok(students);
            }
            catch
            {
                throw;
            }

        }
        [EnableCors("AllPolicy")]
        [Route("[action]")]
        [HttpPost]
        public IActionResult PostComment(Comment comment)
        {
            try
            {

                var result = _context.Database.ExecuteSqlRaw("BS_API_ISem_2020.InsertUpdateComment {0}, {1}, {2}, {3}, {4}",
                                comment.IdComment,
                                comment.IdNews,
                                comment.IdUserProfile,
                                comment.Commentary,
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
        public IActionResult PutComment(Comment comment)
        {
            try
            {
                var result = _context.Database.ExecuteSqlRaw("BS_API_ISem_2020.InsertUpdateComment {0}, {1}, {2}, {3}, {4}",
                                 comment.IdComment,
                                comment.IdNews,
                                comment.IdUserProfile,
                                comment.Commentary,
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

        public IActionResult DeleteComment(int id)
        {
            try
            {
                var result = _context.Database.ExecuteSqlRaw("BS_API_ISem_2020.DeleteComment {0}", id);
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
        public IActionResult GetComment(int id)
        {
            try
            {
                var idComment = new SqlParameter("@IdComment", id);
            var comment = _context.Comment
                           .FromSqlRaw($"BS_API_ISem_2020.GetByIComment @IdComment", idComment)
                           .AsEnumerable().Single();

            if (comment == null)
            {
                return NotFound();
            }

            return Ok(comment);
            }
            catch
            {
                throw;
            }
        }
    }
}
