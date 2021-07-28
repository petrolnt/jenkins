package net.petrolnt.utilities
class Utilities implements Serializable {

  static def checkOutFrom(repo) {
    git url: "${repo}"
  }

}