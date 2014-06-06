#####This is a Scala implementation of the "Simple Genetic Algorithm" described in Chapter 1 of Melanie Mitchell's book "Genetic Algorithms".  I'm assuming you have [sbt](http://www.scala-sbt.org/) installed on your computer. 
I'm really new to sbt, so I don't know how to do much. But I can direct you to a Scala shell and describe how to use this code. 

from the home directory of this project, type: 

    sbt console

*(you may need to sudo)*.

This will bring up the familiar Scala shell in the sbt environment, which is managing dependencies. It's set up this way so that we can use the [breeze](https://github.com/scalanlp/breeze) package to sample from probability distributions. 

Note that the files in *src/main/scala* are compiled when the *console* command is executed.

Once you're in the shell, you can interact with a few classes: 


* **Chromosome(size:Int, bitstring: Array\[Boolean\])**
* **Population(numAgents:Int,agentSize:Int)**
* **GAsim(numAgents:Int, agentSize:int, numRounds:Int, pMutation:Double, pCrossover:Double)**


The simplest thing you'll want to do is run a quick simulation.  *Beware, the output is kind of messy.*
To run a simulation, you will first instantiate an object of class **GAsim**, for instance with the following parameters: 

    val x = new GAsim(100,8,100,0.01,0.5)

Then you'll want to call the **runSimulation** method.  

    x.runSimulation()

Here, we run a simulation with 100 agents, whose bitstrings are of length 8. We perform 100 iterations where the probability of mutation is 0.01 at each bit, and the probability of crossover is 0.5.  

You can find the scala code where these classes are defined to find out about other methods you have access to. 
They are in *src/main/scala*.

### TODO - document those classes

# TODO - Some things that could be done

So currently a bistring is an array of ones and zeros. 
As of now, the "fitness" of a string is considered to be the number of ones.

Because a **Chromosome** is instantiated with a given bitstring, the fitness is calculated when a new Chromosome is made. It is simply an attribute of a chromosome, calculated as follows: 

```scala
class Chromosome(s:Int, bitstring:Array[Boolean]) {
    
    val dna:Array[Boolean] = bitstring;
    var fitness:Double = (dna map (x => bool2int(x).toDouble )).sum;

```

Ideally, the fitness function would be modular in some sense. Like maybe it should be specified in a simulation, and the attribute should just be a *Double*, instantiated at 0.  

Then at each iteration, the fitness of all the chromosomes would be calculated according to the function specified in the simulation, and the fitness attribute would be updated.  This sounds kind of inneficient, though, but the best solution isn't occuring to me.  It sounds like a hash map could be useful though? 


