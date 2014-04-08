using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace ECommerce.Core
{
    public class Vendor
    {
        List<Offer> offers;

        public Vendor(string code, string name)
        {
            Code = code;
            Name = name;
            offers = new List<Offer>();
            Offers = new ReadOnlyCollection<Offer>(offers);
        }

        public string Name { get; private set; }

        public string Code { get; private set; }

        public ReadOnlyCollection<Offer> Offers { get; private set; }

        public void AddOffer(Offer offer)
        {
            if (offer.SellPrice < offer.Product.BuyPrice)
            {
                throw new InvalidOperationException();
            }

            offers.Add(offer);
        }

        protected bool Equals(Vendor other)
        {
            return string.Equals(Name, other.Name) && string.Equals(Code, other.Code);
        }

        public override bool Equals(object obj)
        {
            if (ReferenceEquals(null, obj)) return false;
            if (ReferenceEquals(this, obj)) return true;
            if (obj.GetType() != this.GetType()) return false;
            return Equals((Vendor) obj);
        }

        public override int GetHashCode()
        {
            unchecked
            {
                return ((Name != null ? Name.GetHashCode() : 0)*397) ^ (Code != null ? Code.GetHashCode() : 0);
            }
        }
    }
}
