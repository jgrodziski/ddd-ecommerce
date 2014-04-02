using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ECommerce.Core
{
    public class CatalogRepository
    {
        private readonly List<Catalog> catalogs = new List<Catalog>();

        public bool Exist(Catalog catalog)
        {
            return catalogs.Any(item => item.Equals(catalog));
        }

        public void Add(Catalog catalog)
        {
            if (Exist(catalog))
            {
                throw new InvalidOperationException();
            }

            catalogs.Add(catalog);
        }
    }
}
