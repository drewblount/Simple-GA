object runSIm {
  def main(args: Array[String]) {
    val numAgents = if (args.length > 0) args(0).toInt else 100;
    val agentSize = if (args.length > 1) args(1).toInt else 8;
    val numRounds = if (args.length > 2) args(2).toInt else 20;
    val pMutation = if (args.length > 3) args(3).toInt else 0.01;
    val pCrossover = if (args.length > 4) args(4).toInt else 0.2;

    val x = new GAsim(numAgents, agentSize, numRounds, pMutation, pCrossover)
    x.runSimulation()
  }
}