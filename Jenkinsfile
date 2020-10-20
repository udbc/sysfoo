pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'mvn compile'
      }
    }

    stage('test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('package') {
      steps {
        sh 'mvn package'
        archiveArtifacts 'target/*.war'
      }
    }

  }
  tools {
    maven 'Maven 3.6.3'
  }
}
