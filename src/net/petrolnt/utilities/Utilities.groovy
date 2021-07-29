package net.petrolnt.utilities
class Utilities implements Serializable {

  static def checkOutFrom(branchesList, credentials, repo) {
    git([branches: branchesList, credentialsId: credentials, url: repo])
  }
}