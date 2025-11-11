# To Do
- Write task aggregate in Delivery module



# Architecture decisions

- Deal requires prospect to exist


- project split into multi module  :2025-11-11
  - CRM set as parent, Sales (original module) set as child module
  - 2025-11-11


- Delivery module will contain task aggregate :2025-11-11
  - Task must contain a parent deal id. (invariant)
  - Deal does not know about Task. (dependency)
  - (a deal must have tasks at the reality layer but in the abstraction layer those are kept separeted, the reality 
  layer dependency will be composed at the presentation layer)
  - Tasks will own cost so that later when invoices are created the customer will see clearly what they are paying for
  which services. (customer transparency and trust building)

