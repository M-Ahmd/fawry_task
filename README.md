# 🛒 E-Commerce System in Java

This is a simple object-oriented e-commerce system implemented in **Java**.  
It supports product definition, cart management, expiration validation, shipping logic, and customer checkout processing with balance validation.

---

## 📦 Features

✅ Define products with:
- `name`, `price`, `quantity`
- Optional expiration (`expiry date`)
- Optional shipping flag with `weight`

✅ Support customers who can:
- Add products to their cart with specific quantities
- Checkout only if:
  - Cart is not empty
  - All items are in stock and not expired
  - Customer has sufficient balance

✅ Checkout process includes:
- Subtotal calculation
- Shipping fee (flat fee if shippable items exist)
- Final amount paid
- Updated customer balance
- Shipping notice with item weights and total package weight

✅ Shipping integration:
- If a product is shippable, it is passed to a `ShippingService`
- ShippingService accepts items implementing `Shippable` interface:
  ```java
  interface Shippable {
      String getName();
      double getWeight();
  }



src/
├── Product.java
├── Cart.java
├── Customer.java
├── ShippingService.java
├── Shippable.java
└── Main.java

