class X
class Y extends X

class Parent {
  def f(x: X): Unit = ???
  def f(x: Y): Unit = ???
}

class ChildOverridesX extends Parent {
  override def f(x: X): Unit = ???
}

class DoubleChildOverridesX extends ChildOverridesX

class ChildOverridesY extends Parent {
  override def f(x: Y): Unit = ???
}

class DoubleChildOverridesY extends ChildOverridesY

class ChildOverridesBoth extends Parent {
  override def f(x: X): Unit = ???
  override def f(x: Y): Unit = ???
}

class DoubleChildOverridesBoth extends ChildOverridesBoth

object Usage {
  val x: X = ???
  val y: Y = ???

  // compiles
  (null: Parent).f(x)
  // compiles
  (null: ChildOverridesX).f(x)
  // compiles
  (null: ChildOverridesY).f(x)
  // compiles
  (null: ChildOverridesBoth).f(x)
  // compiles
  (null: Parent).f(y)
  // does not compile
  (null: ChildOverridesX).f(y)
  // compiles
  (null: ChildOverridesY).f(y)
  // compiles
  (null: ChildOverridesBoth).f(y)

  // compiles
  (null: DoubleChildOverridesX).f(x)
  // compiles
  (null: DoubleChildOverridesY).f(x)
  // compiles
  (null: DoubleChildOverridesBoth).f(x)
  // does not compile
  (null: DoubleChildOverridesX).f(y)
  // compiles
  (null: DoubleChildOverridesY).f(y)
  // compiles
  (null: DoubleChildOverridesBoth).f(y)
}
