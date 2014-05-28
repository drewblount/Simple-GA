// Jacob Menick
// May 25, 2014
// 
// Chromosome.scala
// 
// This code creates a "chromosome", which is a generic agent.
// The chromosome's "dna" is a sequence of bits (zeroes and ones).  
//
// It may be the case that these bits encode a solution to a problem, 
// but it also may not. This implementation is fully abstract.  

import breeze.stats.distributions._


class Chromosome(s:Int, bitstring:Array[Boolean]) {

  // Definite toInt for Booleans
  def bool2int(b:Boolean):Int = {
    if (b) {
      return 1;
    }
    else {
      return 0;
    }
  }

  val size:Int = s;
  val dna:Array[Boolean] = bitstring;

  // The fitness is calculated as the number of ones in the bitstring
  var fitness:Double = (dna map (x => bool2int(x).toDouble )).sum;

  def mutate(prob:Double):Unit = {
  // This method will randomly "mutate" the dna sequence by flipping a bit. 
  // Any individual bit may be flipped with probability 'pm', usually small.

    val pm:Double = prob;

    // The variable bern is an instance of a Bernoulli random variable, 
    // whose probability parameter is equal to 'pm'.  
    var bern = new Bernoulli(pm);

    //Loop through the 'dna' array and flip each bit with probability pm. 
    for (i <- 0 to (size - 1)) {
      var flip = bern.draw();
        if (flip) {
          dna(i) = !(dna(i));
        }
      }
    }

  override def toString():String = {
    var dna_temp:Array[Int] = dna map {x => bool2int(x) };
    var string:String = dna_temp.mkString("");
    return string;
  }

}
