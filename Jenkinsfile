pipeline {
  agent {
    docker {
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