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
                sh 'mvn test -Dmaven.test.failure.ignore=true'
                stash name: 'allure-results', includes: 'allure-results/*' // save results
            }
            post {
                 always {
                    unstash 'allure-results' //extract results
                    allure results: [[path: 'allure-results']]
                }
            }
        }

    }

}