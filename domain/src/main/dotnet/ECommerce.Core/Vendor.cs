namespace ECommerce.Core
{
    public class Vendor
    {
        public Vendor(string code, string name)
        {
            Code = code;
            Name = name;
        }

        public string Name { get; set; }
        public string Code { get; set; }

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
