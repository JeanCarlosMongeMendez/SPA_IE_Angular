using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace SPA_API.Models
{
    public partial class IF4101_BeatySolutions_API_ISem_2020Context : DbContext
    {
        public IF4101_BeatySolutions_API_ISem_2020Context()
        {
        }

        public IF4101_BeatySolutions_API_ISem_2020Context(DbContextOptions<IF4101_BeatySolutions_API_ISem_2020Context> options)
            : base(options)
        {
        }

        public virtual DbSet<Comment> Comment { get; set; }
        public virtual DbSet<News> News { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Data Source=163.178.107.10;Initial Catalog=IF4101_BeatySolutions_API_ISem_2020;User ID= laboratorios;Password= Saucr.118");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Comment>(entity =>
            {
                entity.HasKey(e => e.IdComment)
                    .HasName("PK__Comment__57C9AD58DD351239");

                entity.ToTable("Comment", "BS_API_ISem_2020");

                entity.Property(e => e.Commentary).HasMaxLength(200);

                entity.Property(e => e.Username).HasMaxLength(50);
            });

            modelBuilder.Entity<News>(entity =>
            {
                entity.HasKey(e => e.IdNews)
                    .HasName("PK__News__4559C72DD2E94E35");

                entity.ToTable("News", "BS_API_ISem_2020");

                entity.Property(e => e.Description).HasMaxLength(200);

                entity.Property(e => e.Documentation).HasMaxLength(200);

                entity.Property(e => e.Image).HasMaxLength(200);

                entity.Property(e => e.NewsType).HasMaxLength(50);

                entity.Property(e => e.Username).HasMaxLength(50);

            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
