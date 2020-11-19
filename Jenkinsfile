pipeline{
  agent any

  tools{
    maven 'Maven 3.6.3'
  }
  
  stages{
    stage('build'){
       steps{
         sh 'mvn compile'
       } 
    }
    stage('test'){
       steps{
         sh 'mvn clean test'
       }
    }
    stage('package'){
       steps{
         sh 'mvn package -DskipTests'
       } 
    }
  } 
}
