node {
    def mvnHome
    stage('Preparation') {
        // Get some code from a GitHub repository
        git branch: 'master', credentialsId: 'EcentricGithub', url: 'https://github.com/ecentric-ngn/Judiciary-Web-App.git'
        mvnHome = tool 'MAVEN-3'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }
    stage('Deploy') {
        deploy adapters: [tomcat9(credentialsId: '8821ac7f-5af0-400a-953f-d1cf12677812', path: '', url: 'http://172.30.1.24:8180/')], contextPath: 'judiciary', onFailure: false, war: '**/*.war'
    }
}
