using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ECommerce.Core
{
    public class Catalog
    {
        public Guid Id { get; set; }
        public string Name { get; set; }

        public Catalog(string name)
        {
            this.Name = name;
            this.Id = Guid.NewGuid();
        }

        protected bool Equals(Catalog other)
        {
            return string.Equals(Name, other.Name);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Catalog) obj);
        }

        public override int GetHashCode()
        {
            return (Name != null ? Name.GetHashCode() : 0);
        }
    }
}
