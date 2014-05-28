// Jacob Menick
// May 25, 2014
// 
// Population.scala
//
// This code creates a "population" of Chromosome objects.
// A Population has methods that will create a random chromosome  

import breeze.stats.distributions._

class Population(n:Int, s:Int) {
  val numAgents:Int = n;
  val agentSize:Int = s;
  var agents:Array[Chromosome] = new Array[Chromosome](numAgents);

  // the method randChrom will create a chromosome with a random bitstring
  def randChrom():Chromosome = {
    // parameter p is 0.5 so that "1" and "0" occur with equal probability.
    val bern = new Bernoulli(0.5)
    val bs = bern.sample(agentSize).toArray;
    val chromo = new Chromosome(agentSize, bs);
    return chromo;
  }

  // Creates a new population of agents with random dna bitstrings.
  def initialize():Unit = {
    for (i <-0 to numAgents - 1) {
      val chromo = randChrom();
      agents(i) = chromo;
    }
  }

  def avgFit():Double = {
    val fitSum:Double = (agents map {x => x.fitness}).sum
    return fitSum/numAgents;
  }

  def maxFit():Double = {
    return (agents map {x => x.fitness}).max
  }

}