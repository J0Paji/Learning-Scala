val x = 4
print("Hello World")

val testFunction = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
}
testFunction(24)

val doubler: Function1[Int, Int] = (x: Int) => 2*x
doubler(24)

val doubler2 = new Function[Int, Int] {
        override def apply(x:Int) : Int = 2*x
}
doubler2(3)

val doublerV2: Int => Int = (x: Int) => 2*x
doublerV2(2)

val doublerV3 = (x: Int) => 2*x
doublerV3(2)

val aFlattenedMap = List(1,2,4).flatMap(x => List(x, x+1))
println(aFlattenedMap)

List(1,2,3,5,6).filter(_%2 == 0)

val aCombination = List(1,2,3).flatMap(number => List("a","b","c").map(letter => s"$number - $letter"))
println(aCombination)

val aCombinationV2 = for {
        number <- List(1,2,3)
        letter <- List("a", "b", "c")
    } yield s"$number - $letter"