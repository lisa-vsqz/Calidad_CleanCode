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
                // Busca y compila todos los archivos .java dentro de la carpeta com/
                bat '''
                if not exist bin mkdir bin
                javac -d bin com\\example\\manager\\*.java
                '''
            }
        }

        stage('Run') {
            steps {
                echo 'Ejecutando el programa principal...'
                // Ejecuta la clase principal con su paquete completo
                bat 'java -cp bin com.example.manager.CustomerOrderManager'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completado exitosamente.'
        }
        failure {
            echo 'Error durante la ejecución del pipeline.'
        }
    }
}
