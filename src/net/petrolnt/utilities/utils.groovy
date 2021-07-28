package net.petrolnt.jpipelines

class utils implements Serializable {
  def steps
  Utilities(steps) {this.steps = steps}
  static def checkOutFrom(repo) {
    git url: "${repo}"
  }
}
}

