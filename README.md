# Stack (Pile) Kata :
En informatique, une pile (en anglais stack) est une structure de données fondée sur le principe
« dernier arrivé, premier sorti » (en anglais LIFO pour last in, first out), ce qui veut dire, qu&#39;en
général, le dernier élément, ajouté à la pile, sera le premier à en sortir.

**`Primitives`**

Voici les primitives communément utilisées pour manipuler des piles. Il n'existe pas de normalisation pour les primitives de manipulation de pile. Leurs noms sont donc indiqués de manière informelle. Seules les trois premières sont réellement indispensables, les autres pouvant s'en déduire.
- « Empiler » : ajoute un élément sur la pile. Le terme anglais correspondant est _push_.
- « Dépiler » : enlève un élément de la pile et le renvoie. Le terme anglais correspondant est _pop_.
- « La pile est-elle vide ? » : renvoie vrai si la pile est vide, faux sinon.
- « Nombre d'éléments de la pile » : renvoie le nombre d'éléments dans la pile.
- « Quel est l'élément de tête ? » : renvoie l'élément de tête sans le dépiler. Le terme anglais correspondant est _peek_ ou _top_.

Extra use cases :
- « Vider la liste » : dépiler tous les éléments. Le terme anglais correspondant est _clear_.
- « Dupliquer l'élément de tête » et « échanger les deux premiers éléments » : existe sur les calculatrices fonctionnant en notation polonaise inverse. Les termes anglais correspondants sont _dup_ et _swap_ respectivement.

Here are the tests that Uncle Bob lays out in his screencast.
- Can create Stack object.
- Newly created stacks should be empty.
- After one push, stack size should be one.
- After one push and one pop, should be empty.
- When pushed passed limit, stack overflows.
- When popped passed limit, stack underflows.
- When two values are pushed then one is popped, size is one.
- When one is pushed one is popped.
- When one and two are pushed two and one are popped.
- When creating stack with negative size, should through IllegalCapacity.
- When creating stack with zero capacity, any push should overflow.
- When one is pushed, one is on top.
- When stack is empty, top throws empty.
- With zero capacity stack, top throws empty.
- Given stack with one two pushed, find one and two.
- Given a stack with no two, find two returns null.
- Elements should be unique
