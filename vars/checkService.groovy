def call(body) {
    // Check service
    def mainUrl = "http://192.168.1.60/"
    //def get = new URL("http://192.168.1.60").openConnection();
    //def getRC = get.getResponseCode();
    if (checkUrl(mainUrl).equals(200)) {
        println("Service is running")
        currentBuild.result = 'SUCCESS'
    }
    else {
        println("Service not started")
        currentBuild.result = 'FAILURE'
    }
    // Check service health
    //get = new URL("http://192.168.1.60/health").openConnection();
    //getRC = get.getResponseCode();
    def healthResponse = checkUrl(mainUrl + "health")
    if (healthResponse.equals(500)) {
        println("Service status is unhealthy. Try to restore")
        if (checkUrl(mainUrl + "make-healthy").equals(200) && checkUrl(mainUrl + "health").equals(200)){
            println("Service status restored")
            currentBuild.result = 'SUCCESS'
        }
        else{
            println("Something went wrong. Service still not unhealthy")
            currentBuild.result = 'FAILURE'
        }
    }
    else if(!healthResponse.equal(200)){
        println("Service status is unhealthy")
        println("Responce code is: " + getRC)
        currentBuild.result = 'FAILURE'
    }
    return this
}

def checkUrl(url){
    def get = new URL(url).openConnection();
    def getRC = get.getResponseCode();
    return getRC
}
