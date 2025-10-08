pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando el repositorio desde GitHub...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando el código Java...'
                sh 'mkdir -p build'
                sh 'javac -d build src/main/java/com/example/manager/CustomerOrderManager.java'
            }
        }

        stage('Run') {
            steps {
                echo 'Ejecutando la aplicación...'
                sh 'java -cp build com.example.manager.CustomerOrderManager'
            }
        }
    }

    post {
        success {
            echo 'Pipeline ejecutado correctamente.'
        }
        failure {
            echo 'Hubo un error en la ejecución del pipeline.'
        }
    }
}
