pipeline {
  agent {
    docker {
      image 'maven:3.6.3-jdk-11-slim'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('Unit Test') {
      steps {
        sh 'mvn clean test'
      }
    }

    stage('Package') {
      steps {
        sh 'mvn package -DskipTests'
        archiveArtifacts 'target/*.war'
      }
    }

  }
  tools {
    maven 'Maven 3.6.3'
  }
}