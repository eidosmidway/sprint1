pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME" 
    }
    
    parameters {
      choice choices: ['master'], name: 'Branch'
    }

    stages {
        stage('Clone') {
            steps {
                echo 'se inicia stage clone'
                timeout(time: 2, unit: 'MINUTES'){
                    git branch:"${Branch}", url:'https://github.com/eidosmidway/sprint1.git'
                }
            }
        }   
    
    stage('Build') {
            steps {
                echo 'se inicia stage Build' 
                bat "mvn -DskipTests clean package -f demo-crud-repaso/pom.xml"
                
            }
        }
        
        
    stage('Test') {
            steps { 
                echo 'se inicia stage Test' 
                    // Se cambia <test> por <install> para que se genere el reporte de jacoco
                bat "mvn clean install -f demo-crud-repaso/pom.xml"
                
            }
        } 
        
    stage('Sonar') {
            steps {
                echo 'se inicia stage sonarqube' 
                withSonarQubeEnv('sonarqube'){
                    bat "mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar -Pcoverage -f demo-crud-repaso/pom.xml"
                }
            }
        }
        
    stage('Quality gate') {
            steps {
                echo 'se inicia stage Quality gate' 
                sleep(10) //seconds
                
                timeout(time: 2, unit: 'MINUTES'){
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        
    stage('Deploy') {
            steps {
                echo 'se inicia stage Deploy' 
                echo "mvn spring-boot:run -f demo-crud-repaso/pom.xml"
            }
        }
        
        
        
        

    }
}