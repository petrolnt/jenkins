def call(body) {
    // Check service
    def get = new URL("http://192.168.1.60").openConnection();
    def getRC = get.getResponseCode();
    if (getRC.equals(200)) {
        println("Service is running")
        currentBuild.result = 'SUCCESS' 
    }
    else {
        println("Service not started")
        currentBuild.result = 'FAILURE' 
    }
    // Check service health
    def get = new URL("http://192.168.1.60/health").openConnection();
    def getRC = get.getResponseCode();
    if (getRC.equals(200)) {
        println("Service status is healthy")
        currentBuild.result = 'SUCCESS' 
    }
    else {
        println("Service status is unhealthy")
        println("Responce code is: " + getRC)
        currentBuild.result = 'FAILURE' 
    }
    return this
}
