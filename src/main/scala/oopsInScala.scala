object oopsInScala extends App{

  //defining a class
  class Animal {
    // defining an attribute value
    val age: Int = 0
    //defining a method of the class
    def eat() : Unit = println("This animal can eat.")
  }

  // Instantiating a class with new keyword
  val anAnimal = new Animal // creating a instance of class

  //inheritance 
  //inheritance is used by using extends keyword
  // Now Dog inherits all the methods and attributes from its parent class
  //Here name argument is called an constructor argument
  class Dog(name: String) extends Animal 
  //even though we have name as an argument of the class
  //we still cant call that attribute by instantiating and calling the name
  val aDog = new Dog("Kallu")
  aDog.name //this is throwing error because name isn't accessible outside the class
  
  //to fix this we add a val in consutructor argument
  class Dogo(val name: String) extends Animal
  val aDogo = new Dogo("Kallu")
  aDogo.name

  //subtype polymorphism
  //Here even though the instance type is declared as an animal
  //class instance but it'll be called as a Dog type
  //Now when we call .eat() on it if Dog can override the method
  //it will.
  

  val aDeclaredAnimal : Animal = new Dog("Kallu")
  aDeclaredAnimal.eat() //the most derived method will be called at runtime

  //abstract class
  //As python pretty much means that all the attributes/methods
  //need not have an implementation it more of a guideline
  //for children class to implement those methods.
  abstract class walkingAnimal {
    val hasLegs: Boolean = true
    def walk() : Unit //which ever class inherits this class needs to implement this method
  }

  //ALL attributes and methods are PUBLIC by default
  // we can use private and protected keyword.
  //private - only the class and its methods have the access
  //protected - the class and its methods alongside the children have the access.

  //interface - THE ULTIMATE ABSTRACT TYPE
  //pretty much means leave anything unimplemented
  //traits are similar to interfaces we've both in SCALA
  //but usually traits are prefered to define methods to use later
  //in other classes
  trait carnivore{
    def eat(animal: Animal) : Unit 
  } 
  trait  philosipher {
    def ?!(thought: String): Unit //valid name of a method
  }
  //SCALA gives you single class inheritance (unlike Python)
  //and multiple trait inheritance this is called "mixing"
  class crocodile extends Animal with carnivore with philosipher{
    //override is used to override the parent method
    override def eat(animal: Animal): Unit = println("I'm eating, Animal")
    def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }
  //infix notation
  val aCroc = new crocodile
  aCroc.eat(aDog) //this is equivalent to below as eat method takes ONLY ONE ARGUMENT
  aCroc eat aDog //infix notation = object method argument
  aCroc ?! "What if we could fly?" //method looks like an operator

  //operators are actually Methods in SCALA
  val simpleAdd = 1 + 2 //here "+" operator is a method belonging to the INT type

  //anonymous functions
  //it means you can extend a trait on the go as traits are typically
  //in C++/Java used to extend concrete classes but in SCALA
  //you can use them to instantiate objects as well.
  val dinosaur = new carnivore{
    override def eat(animal: Animal): Unit = println("I eat everything.")
  }
  //the above thing pretty much is treated as below by compiler
  //it creates a new class with random name on the fly
  /* 
    class carnivore_anonymous_35737 extends carnivore{
    override def eat(animal: Animal): Unit = println("I eat everything.")
    }
    val dinosaur = new carnivore_anonymous_35737
   */

   //singleton object
   object  mySingleton { //here we've defined the class mySinleton and also the only single instance of this type.
    val mySplValue: Int = 0
    def mySplMethod() : Int = 0
    //special method - apply
    //apply can be applied to any class in SCALA
    def apply(x: Int): Int = x+1
   }

   mySingleton.mySplMethod() //can call methods like any other class
   mySingleton.apply(40) //is equivalent to below line
   mySingleton(40)

   /* the presence of a apply method in a class allows
      that class to be invoked like functions. */

   //in the same file you can have a class and singleton object with the same name

   object Animal { //now class and singleton object Animal are called "companions"
   //companions have a spl property that they can access each other private
   //attributes and methods
   //singleton Animal and instances of Animal are different things
   //usually this singleton animal companion object is used to define
   //things that are not dependent on the animal instances

   val canLiveInDefinetly: Boolean = false
   }
   val animalsCanLiveForever: Boolean = Animal.canLiveInDefinetly //static field/methods

   /*  
   Case Class - lightweight data structures with some boilerplate
   used for -
   sensible equals and hash code
   sensible quick serialization
   companion for apply
   case classes automatically generate a class companion object
   */
  case class Person(name: String, age: Int)
  //may be constructed without keyword new
  val JoPaji = Person("JoPaji", 27) //this is eq to Person.apply("JoPaji", 27) as a companion object is automatically generated

  //Exceptions
  try {
    val x: String = null 
    x.length() //this will cause an error as we're accessing length of null objects
  }
  catch {
    case e:Exception => "Some Error Occured"
  }
  finally {
    //exectue something run no matter what
    //useful for closing connections, files 
  }
  /* 
  Difficult stuff for Python Devs AHEAD
   */
  //generics
  abstract class myList[T]{ //T is a type argument
    def head: T
    def tail: myList[T]
  }
  //if we use it later the T type argument becomes concrete
  //using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) //its actually the companion object of the List object
                                     // eq to List.apply(1,2,3)
  val aHead = aList.head //the head method returns T of type Int 
                         //so the compiler know aHead is of type Int

  /* Key Points in SCALA 
  Point 1 - In SCALA we usually work with IMMUTABLE objects/values.
  Hence, any modification to a value/object must return another object
  
  Benefits - 
  1) works miracles/very fast in distributed/multithreaded enviorments
  2) makes code reasonable in large code bases called "reasoning about"
   */

  val reversedList = aList.reverse // returns a new variable

  /* 
  Point 2 - SCALA is close to OO ideal as everything is inside an instance
  of something. Everything is a part of an object or class. */
  





}
