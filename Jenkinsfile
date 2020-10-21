pipeline {
	agent any

	tools {
		maven 'Maven 3.6.1'
	}

	stages {
		stage('Build') {
			steps {
				sh 'mvn compile'
				echo 'Build passed'
			}
		}
		stage('Test') {
			steps {
				sh 'mvn test'
				echo 'Test passed'
			}
		}
		stage('Package') {
			steps {
				sh 'mvn package'
				archiveArtifacts 'target/*.war'
				echo 'Package passed2'
			}
		}
   	}
}
