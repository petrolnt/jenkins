def call(body) {
    // GET
    def get = new URL("http://localhost").openConnection();
    def getRC = get.getResponseCode();
    println(getRC);
    if (getRC.equals(200)) {
        currentBuild.result = 'SUCCESS' 
    }
    else {
        currentBuild.result = 'FAILURE' 
    }
    return this
}
