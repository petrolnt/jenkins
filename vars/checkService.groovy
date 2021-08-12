def call(body) {
    // Check service
    def strBaseUrl = "http://192.168.1.60";
    def get = new URL(strBaseUrl).openConnection();
    def getRC = get.getResponseCode();
    if (getRC.equals(200)) {
        println("Service is running");
        currentBuild.result = 'SUCCESS';
    }
    else {
        println("Service not started");
        currentBuild.result = 'FAILURE';
    }
    def healthResponse = new URL(strBaseUrl + "/health").openConnection();
    if (healthResponse.equals(500)) {
        println("Service status is unhealthy. Try to restore");
        if ((new URL(strBaseUrl + "/make-healthy")).openConnection().equals(200) &&
                (new URL(strBaseUrl + "/health")).openConnection().equals(200)){
            println("Service status restored");
            currentBuild.result = 'SUCCESS';
        }
        else{
            println("Something went wrong. Service still not unhealthy");
            currentBuild.result = 'FAILURE';
        }
    }
    else if(!healthResponse.equal(200)){
        println("Service status is unhealthy");
        println("Responce code is: " + healthResponse);
        currentBuild.result = 'FAILURE';
    }
    return this
}
