object Test {
  case class Foo[+T[_]](activity:T[Long])
  type Cell[T] = T
  def insertCell(u:Foo[Cell]) = ???
  insertCell(Foo(5))
}
