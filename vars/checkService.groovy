def call(body) {
    // GET
    def get = new URL("http://192.168.1.60").openConnection();
    def getRC = get.getResponseCode();
    println(getRC);
    if (getRC.equals(200)) {
        echo "Service is running"
        currentBuild.result = 'SUCCESS' 
    }
    else {
        echo "Service not started"
        currentBuild.result = 'FAILURE' 
    }
    return this
}
