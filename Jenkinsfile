pipeline {
  agent {
    docker {
      image 'maven:3.6.3-jdk-11-slim'
    }

  }
  stages {
    stage('build') {
      steps {
        echo 'compiling sysfoo app'
        sh 'mvn compile'
      }
    }

    stage('test') {
      steps {
        echo 'running unit tests'
        sh 'mvn clean test'
      }
    }

    stage('package') {
      steps {
        echo 'packaginf app'
        sh 'mvn package -DskipTests'
        archiveArtifacts 'target/*.war'
      }
    }

   stage('Deploy to Dev') {
    when {
     beforeAgent true
     branch 'master'
    }
    agent any
     steps {
      echo 'Deploying to Dev Environment with Docker Compose'
      sh 'docker-compose up -d'
     }
   }

  }
  tools {
    maven 'Maven 3.6.3'
  }
  post {
    always {
      echo 'This pipeline is completed ...'
    }

  }
}
