pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps { bat 'mvn clean compile' }
        }
        stage('Test') {
            steps { bat 'mvn test' }
        }
        stage('Package') {
            steps { bat 'mvn package' }
        }
    }
}