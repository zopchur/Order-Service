pipeline {
    agent any
    tools { 
        maven "mvn" 
        jdk "jdk8"
        dockerTool 'docker'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                sh 'pwd'
                sh 'ls -al'
                echo 'This is a minimal pipeline.'
                sh 'mvn clean package'
            }
        }
        
        stage ('create docker image') {
            steps {
                sh 'sudo usermod -aG docker ${USER}'
                sh 'su -s ${USER}'
                sh 'docker build -t orderapp .'
            }
        }
    }
}
