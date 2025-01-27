object functionalProgramming extends App{

    //Scala is OO
    class Person(name: String) {
        def apply(age: Int) : Unit = println(s"I've aged $age years.")
    }
    val bob = new Person("Bob")
    bob.apply(25) 
    bob(25) //invoking this instance as a function is == bob.apply(25)

    /* 
    Scala runs on the JVM which is originally meant to run Java an OO
    How does Scala implement functional programming?
    Functional programming requires functions to do -
    -compose functions
    -pass functions as args
    return functions as result
    
    TO solve this SCALA implements - FunctionX */

    //Function1 is a simple new trait that implements an apply method
    val simpleIncrementor = new Function1[Int, Int] { //Function1[takes INT, returns INT]
        override def apply(args: Int): Int = args + 1
    }
    simpleIncrementor.apply(23) //will return 24
    simpleIncrementor(23) // eq to  simpleIncrementor.apply(23)
    //so pretty much we've defined a functions
    //ALL SCALA Functions are IMPLEMENTATIONS of this FunctionX type
    //FunctionX = Function1, Function2...Function22
    //22 is the max no of args you can pass a function
    //All SCALA functions are instances of this FunctionX trait

    //Function2 with 2 args
    val stringConcat = new Function2[String, String, String] {
        override def apply(arg1: String, arg2: String): String = arg1 + arg2
    }
    stringConcat("I love", " Python") // I love Python

    //syntax sugars
    val doubler: Function1[Int, Int] = (x: Int) => 2*x
    doubler(2) //4

    /* 
    the above code is eq to 
    val doubler = new Function[Int, Int] {
        override def apply(x:Int) : Int = 2*x
        } */

    //we can be even more further reduced to
    val doublerV2: Int => Int = (x: Int) => 2*x
    doublerV2(2) //4

    //But SCALA Compiler can even infer the type without explicitly decalring it
    val doublerV3 = (x: Int) => 2*x
    doublerV3(2)

    //Higher Order Function - Functions that take functions as args/ return funcs as results
    val aMappedList : List[Int] = List(1,2,4).map(x => x+1)
    //map function takes x => x+1 which is a Function1 function and returns
    //another list

    //flatMap
    val aFlattenedMap = List(1,2,4).flatMap(x => List(x, x+1))
    println(aFlattenedMap) //List(1,2,2,3,4,5)
    /* 
    Another Syntax
    val aFlattenedMap = List(1,2,4).flatMap { x =>
        List(x, x+1)
        } alternative syntax, same as .map(x => List(x, x+1)) */
    
    //filter
    val aFilteredList: List[Int] = List(1,2,3,4,5,6).filter((x: Int) => x%2 == 0)
    println(aFilteredList) // List(2,4,6)
    //to short this
    val anotherFilteredList = List(1,2,3,4,5,6).filter(_ %2 == 0) // _ is equivalent to x => x

    //small example
    //generate all combinations of (1,2,3) with (a,b,c)
    val aCombination = List(1,2,3).flatMap(number => List("a","b","c").map(letter => s"$number - $letter"))
    println(aCombination) //List(1-a,1-b,1-c...)

    //for comprehensions - DOES NOT MEAN for loops!
    //fairly similar to zip in python
    val aCombinationV2 = for {
        number <- List(1,2,3)
        letter <- List("a", "b", "c")
    } yield s"$number - $letter"
    //the SCALA compiler will convert this into a collection of flatmap
    //and maps, it is pretty much equal to previous expression to the 
    //compiler

    /* 
    Collections
     */

     //list
     val aList = List(1,2,3,4,5)
     //every list has the head, first element -> array[0] in Python
     //and a tail, rest of elements -> array[1:] in Python
     //:: and +: operator prepends to a list, :+ appends to the list
     val aPreppendedList = 0 :: aList //List(0,1,2,3,4,5)
     val anExtendedList = 0 +: aList :+ 6 //List(0,1,2,3,4,5,6)

     //sequences
     //Sequence is a trait which has the apply method
     //Sequence allows us to get an element at any index
     //Sequence is more like Pythons List class
     val aSequence: Seq[Int] = Seq(1,2,3) //this is eq to Seq.apply(1,2,3)
     val accessElement = aSequence(1) //eq to aSequence.apply(1) -> 2

     //vectors - a seq for large sequences
     //vectors have very fast access times.
     //vectors have all similar functions as list and seq
     val aVector = Vector(1,2,3,4,5)

     //sets - similar to set in Python - NO DUPLICATES
     val aSet = Set(1,3,4,5,3,4)
     val hasAFive = aSet.contains(5) //True == 5 in set()
     val addedSet = aSet + 5 // adds 5 to aSet == set.add(5)
     val removedSet = aSet - 5 // removes 5 from set == set.remove(5)

     //ranges 
     val aRange = 1 to 1000
     val evenNumbers = aRange.map(x => x*2).toList //List(2,4,6...2000)

     //tuples
     //groups of similar values under a single value
     val aTuple = ("Bon Jovi", "Rock", 1982)

     //maps
     //dicts in python
     //takes a two arg tuple as key value pair
     val aPhonebook: Map[String, Int] = Map(
        ("JoPaji", 1234),
        "Jo" -> 12345 //eq to ("Jo", 12345)
     )









    
}
