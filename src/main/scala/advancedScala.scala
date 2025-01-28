import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
object advancedScala extends App{

    //lazy evaluation
    lazy val aLazyValue = 2
    lazy val aSideEffect = {
        println("I'm so lazy.")
        43 //randomly assigning value to this code block
    }
    /* if we run the above code block nothing will be printed because lazy
        value won't be evaluated.
        to evaluate a lazy code block we can perform an axtion on top of it */
    val eagerEvaluation = aSideEffect + 1 //I'm so lazy. 

    /* even though we aren't printing anything
     it gets printed because of the evalution of code block */
    /* useful in infinite collections */

    //pseudo-collection : Option, Try
    /* 
    These seem like more advanced methods to avoid exceptions
    as nulls can wreck havoc in JVM languages such as Segmentation error
    or NullPointerException. */
    def methodThatCanReturnNull(): String = "Hi, This is not NULL"
    //to save yourself from nulls you can do something like this
    if (methodThatCanReturnNull() == null) {
        //do something to handle/defend it
    }
    //But in SCALA we've better methods like Option-
    val anOption = Option(methodThatCanReturnNull()) //Some("Hi, This is not NULL")
    //Option is a collection that has atmost one value
    /* 
    if the Option companion object hits a Null it'll return None.
    Hence, atmost two outputs are possible, None or Some(Output)
     */
    //you can pattern match an Option object 
    val anOutputHandler = anOption match {
        case Some(value) => s"I got this $value"
        case None => "I got a Null"
    }
    //Also as they're psuedo-collections you can run map, flatMap, filter on top of it

    //Exception Handling
    /* We can create a very defensive code that handles all the exceptions
    but it'll create a huge try catch block like below */
    def methodWhichCanThrowException(): String = throw new RuntimeException
    try {
        methodWhichCanThrowException()
    }
    catch {
        case e: Exception => "We handle this evil exception here"
    }
    //to do away with this SCALA gives us the try psuedo-collection
    val aTry = Try(methodWhichCanThrowException())
    //Essentially try collection will swallow the exception if any or store the result
    //we can pattern match it further to handle the output better
    val aTryHandler = aTry match {
        case Success(aValidOutput) => s"I've recieved a $aValidOutput"
        case Failure(ex) =>  s"I hit an exception, $ex"
    }

    /* 
    Evaluate Something on another thread
    (Async Programming)
     */
    val aFuture = Future({ //Future.apply()
        println("Loading...")
        Thread.sleep(1000)
        println("I got the value") //this will not get printed
        67
    })
    /* in the above program second print statement doesn't print as 
    it's evaluated in a different thread and as that thread sleeps
    the current thread finishes evaluation. */
    //to print the second print statement we can
    //Thread.sleep(2000) now the other thread gets enough time till the other thread finishes

    //also we can omit the () applied in Future method as the {} act as curly braces
    //Future is also an collection and will contain a value when its evaluated
    //it'll be empty untill its evaluated
    //Future is composable to apply methods like map, flatMap, filter

    //Future, Try, Option are called monads in functional programming

    //implicits
    //Most Powerful features of SCALA compiler
    //#1 implicit args
    def anImplicitMethod(implicit arg: Int): Int = arg + 1
    implicit val anImplicitValInt: Int = 2
    println(anImplicitMethod) //anImplicitMethod(anImplicitValInt) -> 3
    /* 
    The compiler goes and looks for an implicit value as the function
    is called without any arguments so it looks for implicit val 
    that it can inject as an argument
     */

    //#2 implicit conversation
    implicit class myIntegerClass(n: Int) {
        def isEven() = n%2 == 0
    }
    println(23.isEven()) //myIntegerClass(23).isEven()
    /* 
    The above things is very powerful becuase we can device
    methods for classes without instantiating them and the compiler
    understands that the arguments can directly have the methods. */
    




    






  
}
