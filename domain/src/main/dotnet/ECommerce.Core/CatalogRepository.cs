using System.Linq;

namespace ECommerce.Core
{
    public class CatalogRepository : ValueObjectRepository<Catalog>
    {
        public Family GetFamily(string name)
        {
            return items.SelectMany(catalog => catalog.Universes)
                .SelectMany(universe => universe.Families)
                .FirstOrDefault(family => family.Name == name);
        }
    }
}
