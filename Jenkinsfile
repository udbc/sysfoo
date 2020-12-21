pipeline {
  agent any
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
        echo 'package maven app'
      }
    }

  }
  tools {
    maven 'Maven 3.6.3'
  }
}