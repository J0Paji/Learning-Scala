object Basics extends App{ //extends app means anything b/w these curly braces will be executable as a standalone app

  //defining a value 
  val meaningOfLife: Int = 42 //val is a contant value and cant be reassigned
  //need not mention type as its optional
  val aBoolean = false
  // main types Int, Boolean, Char, Double, Float, String

  //Stings
  val aString: String = "Hello"
  val anAnotherString = "Scalabe Language: SCALA"
  val concatString = "Scalable " + "Language"
  //f string equivalent in Python need an s in start
  val interpolatedString = s"This Language is $anAnotherString"

  //Scala everything is an or can be reduced to value, called expressions. 
  //unlike any other language where its more of an instructional syntax
  // if statement is also an expression like python

  val ifExpression = if (meaningOfLife > 50) 50 else 0
  val chainOfExpression = 
    if (meaningOfLife > 50) 50
    else if (meaningOfLife > 100) 100
    else 0

  //code blocks defined by {} and you can have functions
  //objects anything even more codeblocks but you've
  //to return something at the end of the code block because
  //everything is a value, last expression is the value of the
  //codeblock

  val codeBlock = {

        val aLocalValue = 1

        aLocalValue + 1 //is the last exp. and value of this block
  }

  //define a function is similar to python with def

  def myFunction(x:Int, y:Int) : Int = x+y
  //or we can have a codeblock as well

  def funcCodeBlock(x:Int, y:Int) : Int = {
    x + y
  }

  // The Unit Type - No meaningfull value = None in Python
  // Since everything is a value, Hence everything must return
  // something.
  // Its sort of Side Effect for example println() will print something
  // but inherintly doesn't hava a value.

  //You can even return Unit type and Unit type is equivalent to ()


  def unitReturn(x:Int) : Unit = {
    println("We Hate Unit Type")
  }

}


