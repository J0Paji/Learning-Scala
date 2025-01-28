object contextualAbstraction {

    //sorting
    val aList = List(1,4,3,2)
    val sortedAList = aList.sorted //actually has an ordering method behind it
    /* will return a  //List(1,2,3,4) originally but the moment we
        declare a ordering variable with given clause it'll replace the
        de facto ordering logic 
        for eg. anOrderedList Ordering object will make the sorted list
        return a descending list.
        
        THIS IS CALLED CONTEXTUAL ARGUMENT- So sorted method has an ordering argument
        and the compiler returns the result as per that argument/logic if
        in the context.
    */


    //ordering
    //when we call the sorted method the complier automatically injects the 
    //ordering method

    given anOrderedList: Ordering[Int] = Ordering.fromLessThan(_ > _) //eq to (a,b) => a>b

    //so this given is analogus to implicit val

    /* 
    the below trait takes in a generic type of A and the combine function
    takes two agrs of type A and returns in type A
     */

    trait Combinator[A] {
        def combine(x:A, y:A): A
    }

    /* 
    The below code can be very confusing at first.
    Here is what we want to achieve - We want to implement a combiner function
    that takes in any list with type A and combines all of them to a single
    value of type A - For eg. sum of list is implemented below.

    now the combine function takes two arguments one is the List input
    and other is the contextual argument which we need not explicitly give 
    but the compiler will automatically look for any implicit functions implemented
    by the keyword "given" - To do this we are employing the "using" keyword
    to tell the compiler that this is a contextual argument.

    we create a combiner function with the given keyword which takes in the Combinator
    trait and overrides its combine function giving the implementation
    summing two args

    now when the compiler hits the combinedList variable which calls 
    for the combineAll function essentially the compiler injects the
    intSummer method to create a sum of the list.

     */
    def combineAll[A](list: List[A])(using combinator: Combinator[A]): A = 
        list.reduce((a,b) => combinator.combine(a,b))

    given intSummer: Combinator[Int] = new Combinator[Int] {
        override def combine(x: Int, y: Int): Int = x + y
    }

    val combinedList = combineAll(aList) //intSummer

    /* 
    Places compiler looks for given/contextual args
    -local scope
    -imported scope
    -the companions of all types involved in the call
        -the companion of list
        -the companion of Int
    */

    //context bounds - smaller syntaxes
    def combineAllV2[A](list: List[A])(using Combinator[A]) = ???
    def combineAllV3[A: Combinator](list: List[A]): A = ???

    //extension methods 
    //Add additional methods to already present types

    case class Person(name: String) {
        def greet(): String = s"Hi, I'm $name"
    }

    extension (string:String)
        def greet(): String = new Person(string).greet()

    val greetBob = "Bob".greet() //type enrichment

    /* 
    Here we extended the string class with an additional method greet
    compiler looks for an extension in string class and adds that instance
    of Person class on the runtime. */

    //Power
    extension [A](list:List[A])
        def combineAllV4Extension(using combinator: Combinator[A]): A = 
            list.reduce(combinator.combine)
    //now we can run this method on all lists

    val sumOfList = aList.combineAllV4Extension
    


    def main(args: Array[String]): Unit = {

    println(sortedAList) //List(1,2,3,4) //after given List(4,3,2,1)
    println(combinedList) // 10
  }
}
