pipeline {
          agent any
          
        
          stages{
            stage(' GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'brancheEya',
                    url : 'https://github.com/Olfa-Babai/achat.git';
                }

            }
            stage('MAVEN CLEAN'){
            steps{
                echo 'Pulling...';
                sh 'mvn clean'
                }
            }
             stage('MAVEN COMPILE'){
                steps{
                sh 'mvn compile'
                }
             }
             stage('MAVEN PACKAGE'){
                steps{
                sh 'mvn package -DskipTests=true'
                }
             }
             stage('MAVEN Test'){
                steps{
                sh 'mvn test'
                }
             }
              stage('MAVEN SONARQUBE '){
                 steps{
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=54243838'
                 }
              }
                     stage("NEXUS DEPLOY"){
                  steps{
                  nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/Projet/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus-user-credentials', groupId: 'tn.esprit.rh', nexusUrl: '192.168.33.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-nexus-repo', version: '1.0.0'
                  }
               } 
                  
              /* DOCKER */
 stage('BUILD DOCKER IMG') {
                  steps {
                  sh 'docker build -t ouellani/Ouellani:2.2.4 .'
                  }
               }
//////////*DOcker push image*//////////////////
               
 stage('DOCKER IMG PUSH') {
                  steps {
                  withCredentials([usernameColonPassword(credentialsId: 'ouellani', variable: '542438388')]) {
                  sh "docker login -u ouellani -p ${542438388}"
                  }
                  sh 'docker push ouellani/Ouellani:2.2.4'
                  }
               }
                  
                    
                    /*DOCKERCOMPOSE*/
               stage('DOCKER COMPOSE') {
                  steps {
                  sh 'docker-compose up -d --build'
                  }
               }
               }
          ////////////////////////////////* *///////////////
          
 post {
        failure {
            mail to: "eya.ouellani@esprit.tn",
            subject: "${env.PROJECT_NAME} - Build # ${env.BUILD_NUMBER} - ${env.BUILD_STATUS}!",
            body: "Check console output at ${env.BUILD_URL} to view the results."
        }
        success {
            mail to: "ouellanieya@gmail.com",
            subject: "${env.PROJECT_NAME} - Build # ${env.BUILD_NUMBER} - ${env.BUILD_STATUS}!",
            body: "Job has finished successfully."
        }
    }
          } 
