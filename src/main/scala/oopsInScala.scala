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
  

}
