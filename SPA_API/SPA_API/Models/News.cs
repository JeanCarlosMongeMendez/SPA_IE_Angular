using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;
using SPA_API.Converters;

namespace SPA_API.Models
{
    public partial class News
    {
        [JsonConverter(typeof(IntToStringConverter))]
        public int IdNews { get; set; }

        [JsonConverter(typeof(IntToStringConverter))]
        public int IdUserCreator { get; set; }
        public string Description { get; set; }
        public string Documentation { get; set; }
        public string NewsType { get; set; }
        public string Image { get; set; }

        public string Username { get; set; }
     
    }


}
