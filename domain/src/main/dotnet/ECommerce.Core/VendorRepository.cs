using System;
using System.Collections.Generic;
using System.Linq;

namespace ECommerce.Core
{
    public class VendorRepository
    {
        private readonly List<Vendor> vendors = new List<Vendor>();

        public void Add(Vendor vendor)
        {
            if (Exist(vendor))
            {
                throw new InvalidOperationException();
            }

            vendors.Add(vendor);
        }

        public bool Exist(Vendor vendor)
        {
            return vendors.Any(item => item.Equals(vendor));
        }
    }
}
