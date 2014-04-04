using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace ECommerce.Core
{
    public class Catalog : INameable
    {
        private readonly List<Universe> universes;

        public Guid Id { get; set; }
        public string Name { get; set; }

        public IReadOnlyCollection<Universe> Universes { get; set; }

        public Catalog(string name)
        {
            Name = name;
            Id = Guid.NewGuid();

            universes = new List<Universe>();
            Universes = new ReadOnlyCollection<Universe>(universes);
        }

        protected bool Equals(Catalog other)
        {
            return string.Equals(Name, other.Name);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != GetType()) return false;
            return Equals((Catalog) obj);
        }

        public override int GetHashCode()
        {
            return (Name != null ? Name.GetHashCode() : 0);
        }

        public void AddUniverse(Universe universe)
        {
            if (Universes.Any(item => item.Equals(universe)))
            {
                throw new InvalidOperationException();
            }

            universes.Add(universe);
        }
    }
}
