pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
             catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh 'mvn test'
                stash name: 'allure-results', includes: 'target/allure-results/*' // save results
                 }
            }

        }
        stage('reports') {
    steps {
    script {
            unstash 'allure-results' //extract results
            allure results: [[path: 'target/allure-results']]
    }
    }
}
    }

}