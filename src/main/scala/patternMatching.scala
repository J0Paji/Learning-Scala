import scala.math.Numeric.LongIsIntegral
object patternMatching extends App{

    //switch expression
    val anInteger = 55
    val integerName = anInteger match {
        case 1 => "first"
        case 2 => "second"
        case 3 => "third"
        case _ => anInteger + "th"
    }
    //pattern matching is an expression
    
    //pattern matching for case classes
    case class Person(name: String, age: Int)
    val bob = new Person("Bob", 43)

    //Here we're matching an entire class object against the case expression
    //if the value we're matching conforms to the class blueprint then it'll
    //pass
    val personalGreeting = bob match {
        case Person(name, age) => s"Hi, I'm $name and I'm $age old."
        case _ => "None"
    }
    println(personalGreeting)

    //decounstructing tuples
    val aBand = ("Bon Jovi", "Rock")
    val bandGenre = aBand match {
        case (band, genre) => s"$band is of $genre."
        case _ => "NullPointerException"
    }

    //decomposing lists
    val aList = List(1,2,3)
    val is2InTheList = aList match {
        case (_,2,_) => "Contains 2" //this is exactly (anything,2,anything) and tuple must of size 3.
        case _ => "None"
    }

    //IF PATTERN MATCHING DOESN'T MATCH ANYTHING THEN IT'LL THROW MatchError
    //PM follows case statements in order
    
    

    
  
}
