pipeline {
  agent {
    docker {
      image 'maven:3.6.3-jdk-11-slim'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'Building ...'
        sh 'mvn compile'
        sleep 3
      }
    }

    stage('Test') {
      steps {
        echo 'Testing ...'
        sh 'mvn clean test'
        sleep 9
      }
    }

    stage('Package') {
      steps {
        echo 'Packaging ...'
        sh 'mvn package -DskipTests'
        sleep 5
      }
    }

  }
  tools {
    maven 'Maven 3.6.3'
  }
  post {
    always {
      echo 'This pipeline is completed..'
    }

  }
}