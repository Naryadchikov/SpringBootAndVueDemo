pipeline {
  agent {
    docker {
      args '-v /usr/local/apache-maven/apache-maven-3.5.0'
      image 'maven:3.5.0-jdk-8'
    }
    
  }
  stages {
    stage('Initialize') {
      steps {
        sh 'mvn clean'
      }
    }
  }
}