package net.petrol-nt.jpipelines

def checkOutFrom(repo) {
  git url: "${repo}"
}

return this
