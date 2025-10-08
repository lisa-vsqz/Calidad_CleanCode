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
                // Compila todos los archivos .java en src y coloca los .class en la carpeta bin
                bat '''
                if not exist bin mkdir bin
                javac -d bin src\\*.java
                '''
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando pruebas (si existen)...'
                // Ejecuta la clase principal, ajusta el nombre si tu clase principal no se llama Main
                bat 'java -cp bin Main'
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
