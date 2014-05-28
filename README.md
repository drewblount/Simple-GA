I'm implementing the "Simple Genetic Algorithm" described in Chapter 1 of Melanie Mitchell's book "Genetic Algorithms".  I'm assuming you have sbt installed on your computer. 
I'm really new to sbt, so I don't know how to do much. But I can direct you to a Scala shell and describe how to use this code. 

navigate to the home directory, generic_GA. 

in the command line, type: 

    sbt console

(you may need to sudo).

This will bring up the familiar Scala shell in the sbt environment, where it is managing dependencies. It's set up this way so that we can use the breeze package to sample from probability distributions. 

Once you're in the shell, you can interact with a few classes: 


Chromosome(size:Int, bitstring: Array\\[Boolean\](size))

Population(numAgents:Int,agentSize:Int)

GAsim(numAgents:Int, agentSize:int, numRounds:Int, pMutation:Double, pCrossover:Double)


The simplest thing you'll want to do is run a quick simulation.  Beware, the output is kind of messy.  
To run a simulation, you will first instantiate an object of class GAsim, for instance with the following parameters: 

    val x = new GAsim(100,8,100,0.01,0.5);

Then you'll want to call the "runSimulation" method.  

    x.runSimulation()

Here, we run a simulation with 100 agents, whose bitstrings are of length 8. We perform 100 iterations where the probability of mutation is 0.01 at each bit, and the probability of crossover is 0.5.  

You can find the scala code where these classes are defined to find out about other methods you have access to. 
They are in "src/main/scala".

Once I'm feeling less lazy, I will put some documentation about those.    