using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;
using SPA_API.Converters;

namespace SPA_API.Models
{
    public partial class Comment
    {
        [JsonConverter(typeof(IntToStringConverter))]
        public int IdComment { get; set; }
        [JsonConverter(typeof(IntToStringConverter))]
        public int IdNews { get; set; }
        [JsonConverter(typeof(IntToStringConverter))]
        public int IdUserProfile { get; set; }
        public string Commentary { get; set; }

        public string Username { get; set; }
    }
}
